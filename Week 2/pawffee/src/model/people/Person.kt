package model.people

import model.animals.Cat

open class Person (
    val id: String = "",
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val cats: MutableSet<Cat> = mutableSetOf() // every person can adopt cats and can adopt as many as they want
)