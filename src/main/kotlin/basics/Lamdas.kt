package basics

fun main() {

    val lamda = Lamdas(GetProfileImpl())

    val result = lamda.authUser("email", "pass")
    println("sync result: $result")

    lamda.authUserCallback("email", "pass") {
        println("lamda result: $it")

    }

    lamda.authUserCallbackLegacy("email", "pass", object: AuthResult {
        override fun authResult(result: Boolean) {
            println("authUserCallbackLegacy result: $result")
        }
    })

    println("out")

    Thread.sleep(5000)


}

// Facebook

class UserProfile

interface GetProfile {

    fun getUserProfile(): UserProfile

    fun authUser(email: String, pass: String): Boolean

}

class GetProfileImpl : GetProfile {
    override fun getUserProfile(): UserProfile {
        return UserProfile()
    }

    override fun authUser(email: String, pass: String): Boolean {
        return false
    }

}

class Lamdas(val userApi: GetProfile) {


    // sincrono
    fun authUser(email: String, pass: String): Boolean {
        val result = userApi.authUser(email, pass)
        return result
    }

    //asincrono
    fun authUserCallback(email: String, pass: String, callback: (result: Boolean) -> Unit) {
        val result = userApi.authUser(email, pass)
        Thread {
            Thread.sleep(3000)
            callback(result)
        }.start()
    }

    //asincrono
    fun authUserCallbackLegacy(email: String, pass: String, callback: AuthResult) {
        val result = userApi.authUser(email, pass)
        Thread {
            Thread.sleep(1000)
            callback.authResult(result)
        }.start()
    }

}

interface AuthResult {
    fun authResult(result: Boolean)
}