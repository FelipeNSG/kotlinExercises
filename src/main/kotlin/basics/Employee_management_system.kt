package basics

enum class JobPosition {
    DOCTOR,
    ANESTHESIOLOGY,
    NURSE
}

interface EmployeeOperations {
    fun describeEmployee()
}

class Employee(private val name: String, private val age: Int) : EmployeeOperations {
    private var jobPosition: JobPosition? = null
    private var height: Float = 0f

    fun attendanceRecord() {
        println("Your attendance was recorded")
    }

    override fun describeEmployee() {
        println("The employee $name is $age years old")
    }

    constructor(name: String, age: Int, jobPosition: JobPosition) : this(name, age) {
        this.jobPosition = jobPosition
    }

    constructor(name: String, age: Int, jobPosition: JobPosition, height: Float) : this(name, age, jobPosition) {
        this.height = height
    }

    fun describeEmployeeAndJob() {

        println("The employee $name is $age years old and his job is $jobPosition")
    }

    fun describeEmployeeAndJob2() {
        println("The employee $name is $age years old, his height is: $height feet tall and his job is $jobPosition")
    }
}

class BusinessEmployee :EmployeeOperations{
    override fun describeEmployee() {
        println("Business Employee")
    }
}


fun main() {
    val businessEmployee = BusinessEmployee()
    val sarah = Employee("Sarah", 19)
    val juan = Employee("Juan", 23, JobPosition.DOCTOR)
    val smith = Employee("Smith", 23, JobPosition.ANESTHESIOLOGY, 4f)
/*    smith.describeEmployeeAndJob2()
    smith.attendanceRecord()*/

    val employee: List<EmployeeOperations> = listOf(smith, businessEmployee)
    for (i in employee){
        i.describeEmployee()
    }

}