package helper

import model.animals.Cat
import model.cafe.Product
import model.cafe.Receipt
import model.cafe.Sponsorship
import model.people.Employee
import model.people.Patron
import model.shelter.Shelter

// Dummy data for the shelters
val shelterOne = Shelter("242", "Hampton County Animal Shelter",
    "460 Cemetery Rd, Varnville SC 29944", "(803)914-2269")
val shelterTwo = Shelter("249", "San Diego Humane Society's Escondido Campus",
    "3500 Burnet Dr, Escondido CA 92027", "(619)299-7012")

// Dummy data for the cats
val shelterOneCats = setOf(
    Cat(
        "456",
        "242",
        "Morris",
        "Tabby",
        "Orange",
        "M",
        mutableSetOf(Sponsorship("2", "456"))
    ),
    Cat(
        "457",
        "242",
        "Sippi",
        "Maine Coon",
        "Brown",
        "F",
        mutableSetOf(Sponsorship("3", "457"))
    )
)

val shelterTwoCats = setOf(
    Cat(
        "911",
        "249",
        "Lewis Carol",
        "Chesire",
        "Purple",
        "M",
        mutableSetOf(Sponsorship("5", "911"))
    ),
    Cat(
        "918",
        "249",
        "Choupette",
        "Birman",
        "Blue-cream tortie",
        "F",
        mutableSetOf(Sponsorship("7", "918"))
    )
)

// Dummy data for the employees
val dummyEmployees = setOf(
    Employee(
        "2",
        "Matthew",
        "Spire",
        "(760)123-4567",
        "random_email_1@yahoo.com",
        "03/01/2020",
        "123-45-6789",
        50000.00
    ),
    Employee(
        "3",
        "Steven",
        "Emond",
        "(803)123-4567",
        "random_email_2@yahoo.com",
        "02/24/2020",
        "987-65-4321",
        45000.00
    )
)

// Dummy data for the patrons
val dummyPatrons = setOf(
    Patron(
        "5",
        "John",
        "Smith",
        "(619)123-4567",
        "random_email_3@yahoo.com"
    ),
    Patron(
        "7",
        "Elizabeth",
        "Free",
        "(858)123-4567",
        "random_email_4@yahoo.com"
    ),
    Patron(
        "11",
        "Kelly",
        "Smith",
        "(207)123-4567",
        "random_email_5@yahoo.com"
    )
)

// Dummy data for the products
val bagel = Product("1", "Jalapeno-Cheddar Bagel", 0.99)
val muffin = Product("2", "Blueberry Muffin", 2.25)
val latte = Product("3", "Cafe Latte", 5.00)
val doubleEspresso = Product("4", "Double-Shot Espresso", 2.50)
val appleJuice = Product("5", "Apple Juice", 1.50)

val dummyProducts = setOf(
    bagel,
    muffin,
    latte,
    doubleEspresso,
    appleJuice
)

val dummyReceiptDayOne = setOf(
    Receipt(
        "1",
        "5",
        listOf(bagel, latte),
        bagel.price + latte.price
    ),
    Receipt(
        "2",
        "7",
        listOf(muffin, doubleEspresso),
        muffin.price + doubleEspresso.price
    )
)

val dummyReceiptDayTwo = setOf(
    Receipt(
        "3",
        "11",
        listOf(bagel, appleJuice),
        bagel.price + appleJuice.price
    ),
    Receipt(
        "4",
        "5",
        listOf(muffin, latte),
        muffin.price + latte.price
    )
)