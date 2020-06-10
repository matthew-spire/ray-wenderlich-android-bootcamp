import helper.CafeController
import helper.dummyEmployees
import helper.dummyProducts

fun main() {
    val cafeController = CafeController() // print the data using CafeController functions

    // adopt a cat
    cafeController.adoptCat("2", dummyEmployees.first())
    println("Adopted cats ${ cafeController.getAdoptedCats() }.")

    // information about adoptions
    println(cafeController.getNumberOfAdoptionsPerShelter())
    println(cafeController.getUnadoptedCats())
    println(cafeController.getAdopters())

    // information about days at the cafe
    cafeController.showNumberOfNonEmployeeCustomersForDay("Tuesday")
    cafeController.showNumberOfReceiptsForDay("Saturday")
    println(cafeController.getWorkingEmployees())
    println(cafeController.getTopSellingProducts())
    cafeController.sellItems(dummyProducts.toList(), "7")
}