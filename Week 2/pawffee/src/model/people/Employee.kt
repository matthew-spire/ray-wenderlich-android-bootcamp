package model.people

class Employee (
    id: String,
    firstName: String,
    lastName: String,
    phoneNumber: String,
    email: String,
    hireDate: String,
    socialSecurityNumber: String,
    salary: Double
) : Person(firstName = firstName, lastName = lastName, phoneNumber = phoneNumber, email = email) {
    override fun toString(): String {
        return "" // format the data super.toString()
    }

    // Format and print the time the employee clocked in
    fun clockIn() {
        // Get the time by creating a `Date` object
        // Use SimpleDateFormatter to format the time
    }

    // Format and print the time the employee clocked out
    fun clockOut() {
    }
}