data class Card(
    val pip: String,
    val suit: Char
)

fun createDeck(): MutableSet<Card> {
    val pip = setOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
    val suit = setOf('\u2663', '\u2660', '\u2666', '\u2665')

    // Create a MutableSet<Card>
    val cards = mutableSetOf<Card>()

    // Use a nested for loop to create a card of each pip for each suit and place it in the MutableSet<Card>
    pip.forEach { PIP -> suit.forEach { SUIT -> cards.add(Card(PIP, SUIT)) } }

    // Return the MutableSet<Card>
    return cards
}

fun dealHand(deck: MutableSet<Card>): MutableSet<Card> {
    val handDealt = mutableSetOf<Card>()
    var sizeOfHand = 2

    while (sizeOfHand > 0) {
        val card = deck.random()
        deck.remove(card)
        handDealt.add(card)
        sizeOfHand--
    }

    return handDealt
}

fun evaluateHand(handDealt: MutableSet<Card>): Int {
    var cardTotal = 0

    val firstCard = handDealt.elementAt(0)
    val secondCard = handDealt.elementAt(1)

    when (firstCard.pip) {
        "2", "3", "4", "5", "6", "7", "8", "9", "10" -> cardTotal += firstCard.pip.toInt()
        "J", "Q", "K" -> cardTotal += 10
        "A" -> cardTotal += 11
    }

    when (secondCard.pip) {
        "2", "3", "4", "5", "6", "7", "8", "9", "10" -> cardTotal += secondCard.pip.toInt()
        "J", "Q", "K" -> cardTotal += 10
        "A" -> cardTotal += 11
    }

    return cardTotal
}

fun printResults(handDealt: MutableSet<Card>, handEvaluated: Int) {
    val firstCard = handDealt.elementAt(0)
    val secondCard = handDealt.elementAt(1)

    println("Your hand was:")
    println(firstCard.pip + firstCard.suit)
    println(secondCard.pip + secondCard.suit)
    println("For a total of: $handEvaluated")

    if (handEvaluated == 21) {
        println("You Win!")
    } else if (handEvaluated == 22) {
        println("You Lose!")
    }
}

fun main() {
    val deck = createDeck()

    val handDealt = dealHand(deck)

    val handEvaluated = evaluateHand(handDealt)

    printResults(handDealt, handEvaluated)
}
