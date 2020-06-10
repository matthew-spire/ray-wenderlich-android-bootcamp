package model.people

class Patron (
    id: String,
    firstName: String,
    lastName: String,
    phoneNumber: String,
    email: String
) : Person(firstName = firstName, lastName = lastName, phoneNumber = phoneNumber, email = email) {
    override fun toString(): String {
        return "" // format the data super.toString()
    }
}