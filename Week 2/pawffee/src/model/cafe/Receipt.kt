package model.cafe

class Receipt (
    val id: String,
    val customerId: String,
    val products: List<Product>,
    val totalPrice: Double
)