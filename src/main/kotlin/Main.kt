fun main() {
// create an instance of the enum class courseType
    val StudentList = ArrayList<Student>()

    StudentList.add(Student("John", "Crane", 18, courseType = CourseType.CSG, 9,1))
    StudentList.add(Student("Jane", "Thomas", 19, courseType = CourseType.CS, 6,2))
    StudentList.add(Student("Jack", "Skinners", 20, courseType = CourseType.CSG, 5,3))
    StudentList.add(Student("Jill", "Car", 21, courseType = CourseType.SE, 4,4))
    StudentList.add(Student("James", "King", 22,courseType = CourseType.SE, 8,5))
    StudentList.add(Student("Jenny", "Cooper", 23, courseType = CourseType.CS, 7,6))
    StudentList.add(Student("Joe", "Donald", 24, courseType = CourseType.CSG, 8,7))
    StudentList.add(Student("Jade", "Smith", 25, courseType = CourseType.CS, 7,8))

menu(StudentList)



}


// function to print the list of students
fun printStudents(StudentList: ArrayList<Student>) {
   StudentList.forEach { println(it) }
    enter()
    menu(StudentList)
}





// function to add a student to the list based on user input and add id automatically
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
    val studentId = StudentList.size + 1
    StudentList.add(Student(firstName, surname, age, CourseType.valueOf(courseType), grade, studentId))
    printStudents(StudentList)
    enter()
    menu(StudentList)
}


// function to remove a student from the list based on user input
fun removeStudent(StudentList: ArrayList<Student>) {
    println("Enter the student ID of the student you wish to remove")
    val studentId = readLine()!!.toInt()
    StudentList.removeIf { it.studentId == studentId }
    printStudents(StudentList)
    enter()
    menu(StudentList)
}



// function to print the list of students grouped by course type with handeling for invalid input
fun printStudentsByCourseType(StudentList: ArrayList<Student>) {
    println("Enter the course type of the student you wish to find")
    val courseType = readLine()!!
    try {
        StudentList.filter { it.courseType == CourseType.valueOf(courseType) }
            .forEach { println(it) }
    } catch (e: IllegalArgumentException) {
        println("Invalid course type") // if the user enters an invalid course type
        printStudentsByCourseType(StudentList)
    }
    enter()
    menu(StudentList)
}

// function to get student by id
fun getStudentById(StudentList: ArrayList<Student>) {
    println("Enter the student ID of the student you wish to find")
    val studentId = readLine()!!.toInt()
    StudentList.forEach { if (it.studentId == studentId) println(it) }
    enter()
    menu(StudentList)
}



// function to get student by course and sort by grade
fun getCourseAndSortByGrade(StudentList: ArrayList<Student>) {
    println("Enter the course type of the student you wish to find")
    val courseType = readLine()!!
    StudentList.filter { it.courseType == CourseType.valueOf(courseType) }
        .sortedBy { it.grade }
        .forEach { println(it) }
    enter()
    menu(StudentList)
}


// function to get student by first letter of first name
fun getStudentByFirstLetter(StudentList: ArrayList<Student>) {
    println("Enter the first letter of the first name of the student you wish to find")
    val firstLetter = readLine()!!
    StudentList.filter { it.firstName.startsWith(firstLetter) }
        .forEach { println(it) }
    enter()
    menu(StudentList)
}

// function to get student by name
fun getStudentByName(StudentList: ArrayList<Student>) {
    println("Enter the first name of the student you wish to find")
    val firstName = readLine()!!
    StudentList.filter { it.firstName == firstName  }
        .forEach { println(it) }
    enter()
    menu(StudentList)
}


// menu function
fun menu(StudentList: ArrayList<Student>) {
    println("1. Add a student")
    println("2. Remove a student")
    println("3. Print the list of students")
    println("4. Print the list of students grouped by course type")
    println("5. Get a student by ID")
    println("6. Get a student by course and sort by grade")
    println("7. Get a student by first letter of first name")
    println("8. Get a student by name")
    println("9. Exit")
    println("Enter your choice")

    val stringChoice = readLine()!!
    if( !stringChoice.contains("[0-9]".toRegex()))  {
        println("Invalid choice")
        menu(StudentList)
    }

    val choice = stringChoice.toInt()


    when (choice) {
        1 -> addStudent(StudentList)
        2 -> removeStudent(StudentList)
        3 -> printStudents(StudentList)
        4 -> printStudentsByCourseType(StudentList)
        5 -> getStudentById(StudentList)
        6 -> getCourseAndSortByGrade(StudentList)
        7 -> getStudentByFirstLetter(StudentList)
        8 -> getStudentByName(StudentList)
        9 -> println("Exiting")
        else -> println("Invalid choice")
    }
}

//function to wait for user to press enter
fun enter() {
    println("Press enter to continue")
    readLine()
}