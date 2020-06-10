package model.cafe

// import model.animals.Cat
import model.people.Employee
import model.people.Person

class Cafe {
    /*
     * Imitate a week-long cafe turnaround
     *
     * Add the receipts, w/ data, to each set
     */
    private val receiptsByDay = mutableMapOf(
        "Monday" to mutableSetOf<Receipt>(),
        "Tuesday" to mutableSetOf<Receipt>(),
        "Wednesday" to mutableSetOf<Receipt>(),
        "Thursday" to mutableSetOf<Receipt>(),
        "Friday" to mutableSetOf<Receipt>(),
        "Saturday" to mutableSetOf<Receipt>(),
        "Sunday" to mutableSetOf<Receipt>()
    )

    private var numberOfReceipts: Int = 13

    // As employees check-in, add them to the list of working employees
    private val employees = mutableSetOf<Employee>()
    private val customers = mutableSetOf<Person>()

    // Add sponsorships and tie them to people
    private val sponsorships = mutableSetOf<Sponsorship>()

    // Add logic for checking in and checking out
    fun checkInEmployee(employee: Employee) {
        // check in
        employee.clockIn()

        employees.add(employee)
    }

    fun checkOutEmployee(employee: Employee) {
        // check out
        employee.clockOut()

        employees.remove(employee)
    }

    fun showNumberOfReceiptsForDay(day: String) {
        val receiptForDay = receiptsByDay[day] ?: return // wrong day inserted ???

        println("On $day you made ${ receiptsByDay.size } transactions.")
    }

    fun showNumberOfCustomersForDay(day: String) {
        val receiptForDay = receiptsByDay[day] ?: return // wrong day inserted ???
        val customersForDay = receiptForDay.map { it.customerId }.toSet()

        println("On $day you had ${ customersForDay.size } unique customers.")
    }

    fun showNumberOfNonEmployeeCustomersForDay(day: String) {
        val receiptForDay = receiptsByDay[day] ?: return // wrong day inserted ???
        val customersForDay = receiptForDay.mapNotNull { receipt ->
            customers.firstOrNull { it.id == receipt.customerId } }.filter { it !is Employee }.toSet()

        println("On $day you had ${ customersForDay.size } customers who are not employees.")
    }

    fun getReceipt(items: List<Product>, customerId: String): Receipt {
        val hasDiscount = employees.any { it.id == customerId }
        val totalPrice = items.map { it.price }.sum() * (if (hasDiscount) 0.60 else 1.0)

        numberOfReceipts++

        return Receipt(numberOfReceipts.toString(), customerId, items, totalPrice)
    }

    fun getWorkingEmployees(): Set<Employee> = employees

    fun getCustomers(): Set<Person> = customers

    fun addCustomer(person: Person) {
        customers.add(person)
    }

    fun addSponsorships(catId: String, personId: String) {
        sponsorships.add(Sponsorship(personId, catId))
    }

    fun getSponsorships(): Set<Sponsorship> = sponsorships

    fun getAdopters(): List<Person> {
        return (employees + customers).filter { it.cats.isNotEmpty() }
    }

    fun getTopSellingItems(): Product? {
        // get all the receipts
        val allReceipts = receiptsByDay.flatMap { it.value }
        val productGroups = allReceipts.flatMap { it.products }.groupBy { it }

        val productsByAmountSold = productGroups.mapValues { it.value.size }

        return productsByAmountSold.maxBy { it.value }?.key
    }
}