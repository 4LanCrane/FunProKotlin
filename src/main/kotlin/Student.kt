



data class Student(
    var firstName: String,
    var surname: String,
    var age: Int,
    var courseType: CourseType,
    var grade: Int,
    val studentId:Int) {

    // function to add a student to the list using the users input
    fun addStudent(StudentList: ArrayList<Student>) {
        println("Enter the first name of the student")
        val firstName = readLine()!!
        println("Enter the surname of the student")
        val surname = readLine()!!
        println("Enter the age of the student")
        val age = readLine()!!.toInt()
        println("Enter the course type of the student")
        val courseType = readLine()!!
        println("Enter the grade of the student")
        val grade = readLine()!!.toInt()
        println("Enter the student ID of the student")
        val studentId = readLine()!!.toInt()
        StudentList.add(Student(firstName, surname, age, CourseType.valueOf(courseType), grade, studentId))


    }
}