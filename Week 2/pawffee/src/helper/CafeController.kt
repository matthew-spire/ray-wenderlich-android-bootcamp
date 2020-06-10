package helper

import model.animals.Cat
import model.cafe.Cafe
import model.cafe.Product
import model.people.Person
import model.shelter.Shelter

class CafeController {
    // cafe related items
    private val cafe = Cafe()

    fun sellItems(items: List<Product>, customerId: String) {
        val receipt = cafe.getReceipt(items, customerId)

        // print receipt information out
        println("Customer ID: ${ receipt.customerId }")
        println("Items sold: ${ receipt.products.map { it.name }}")
        println("Total: ${ receipt.totalPrice }")
    }

    // shelter items
    private val shelters = mutableSetOf(shelterOne, shelterTwo)
    private val shelterToCat = mutableMapOf(
        shelterOne to shelterOneCats.toMutableSet(),
        shelterTwo to shelterTwoCats.toMutableSet()
    )

    // cat adoption items
    fun adoptCat(catId: String, person: Person) {
        // check if the cat exist and retrieve their entry
        val catInShelter = shelterToCat.entries.firstOrNull { (_, catsInShelter) ->
            catsInShelter.any { it.id == catId }
        }

        // cat is adoptable
        if (catInShelter != null) {
            val cat = catInShelter.value.first{ cat -> cat.id == catId } // find the cat with the given ID

            // remove the cat from the shelter
            catInShelter.value.remove(cat)

            // assign the cat to the person
            person.cats.add(cat)

            cafe.addCustomer(person)
        }
    }

    /*
     * First, get a list of all adopters
     * Second, query shelters
     */
    fun getNumberOfAdoptionsPerShelter(): Map<String, Int> {
        // find which cats belong to which shelter
        val adoptedCats = getAdoptedCats()
        val shelters = shelterToCat.keys

        // create a map of shelter name to number of adoptions
        return shelters.map { shelter -> shelter.name to
                adoptedCats.count { cat -> cat.shelterId == shelter.id } }.toMap()
    }

    fun getAdoptedCats(): Set<Cat> {
        val customers = cafe.getCustomers()
        val adoptedCats = customers.flatMap { it.cats }

        return adoptedCats.toSet()
    }

    fun getUnadoptedCats(): Set<Cat> = shelterToCat.flatMap { it.value }.toSet()

    fun getSponsoredCats(): Set<Cat> {
        val sponsoredCatIds = cafe.getSponsorships().map { it.catId }
        val unadoptedCats = getUnadoptedCats()

        return unadoptedCats.filter { it.id in sponsoredCatIds }.toSet()
    }

    fun getMostPopularCats(): Set<Cat> {
        val sponsoredCats = getSponsoredCats()
        val mostPopularCats = sponsoredCats.filter { it.sponsorships.size > 2 }

        return mostPopularCats.toSet()
    }

    fun getTopSellingProducts() = cafe.getTopSellingItems()

    fun getWorkingEmployees() = cafe.getWorkingEmployees()

    fun getAdopters() = cafe.getAdopters()

    fun showNumberOfNonEmployeeCustomersForDay(day: String) = cafe.showNumberOfNonEmployeeCustomersForDay(day)

    fun showNumberOfReceiptsForDay(day: String) = cafe.showNumberOfReceiptsForDay(day)
}