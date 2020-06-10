package model.animals

import model.cafe.Sponsorship

data class Cat(
    val id: String,
    val shelterId: String,
    val name: String,
    val breed: String,
    val color: String,
    val sex: String,
    val sponsorships: MutableSet<Sponsorship> = mutableSetOf()
)