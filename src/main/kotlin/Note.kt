import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext


data class User(val name: String, val friends: List<User> = emptyList())

class UserServices {

    suspend fun doLogin (newUser: String, pass: String) : User = withContext(Dispatchers.IO){
        //server request
         User("Antonio")
    }



    suspend fun requestCurrentFriends(user: User) : List<User>  =  withContext(Dispatchers.IO) {
        //server request

        listOf(User("1"), User ("2"))
    }



    suspend fun requestSuggestedFriends(user: User) : List<User> =  withContext(Dispatchers.IO){
        //server request
         listOf(User("3"), User ("4"))
    }


}


@DelicateCoroutinesApi
suspend fun test() {
    val userServices = UserServices()
   /* val userServices = UserServices()
    println("Starting")
    userServices.doLogin("user", "pass") { user ->
        userServices.requestCurrentFriends(user) { currentFriends ->
            userServices.requestSuggestedFriends(user) { suggestedFriends ->
                val finalUser = user.copy(friends = currentFriends + suggestedFriends)
                println(finalUser)
            }
        }
    }*/

  val job = GlobalScope.launch(Dispatchers.Main) {
        println("Starting")
        val user = userServices.doLogin("user", "pass")
        val currentFriends =  async {  userServices.requestCurrentFriends(user) }
        val suggestFriends = async { userServices.requestSuggestedFriends(user) }
        val finalUser = user.copy(friends = currentFriends.await() + suggestFriends.await())
        println(finalUser)
    }
    job.join()


}






fun main(){

}


