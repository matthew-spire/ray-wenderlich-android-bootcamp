// Create a data class called Card with two members, a String for the pip and a Char for the suit
data class Card(
        val pip: String,
        val suit: Char
)

// Implementation of the createDeck function. Returns the MutableSet<Card>
fun createDeck(): MutableSet<Card> {
    // Create a collection of suits using unicode characters for the suit
    val suits = setOf('\u2663', '\u2660', '\u2666', '\u2665')
    // Create a collection of pips
    val pips = setOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")

    // Create a MutableSet<Card>
    val cards = mutableSetOf<Card>()

    // Use a nested for loop to create a card of each pip for each suit and place it in the MutableSet<Card>
    pips.forEach { pip -> suits.forEach { suit -> cards.add(Card(pip, suit)) } }

    // Return the MutableSet<Card>, which is a standard 52-card deck
    return cards
}

/*
 * Implementation of the dealHand function. Receives the MutableSet<Card> and sizeOfHand as parameters and returns a
 * collection of two cards
 */
fun dealHand(deck: MutableSet<Card>, sizeOfHand: Int): MutableSet<Card> {
    // Create a collection to store the cards dealt in the hand
    val handDealt = mutableSetOf<Card>()

    // Deal the hand using a for loop, ensuring that the card is removed from the deck after it is dealt
    for (i in 1..sizeOfHand) {
        val card = deck.random()
        handDealt.add(card)
        deck.remove(card)
    }

    // Return the handDealt, which is a collection containing the number of cards specified (i.e. two cards)
    return handDealt
}

/*
 * Implementation of the evaluateHand function. Receives the handDealt as a parameter and returns the total of the pip
 * values of the two cards in the hand
 */
fun evaluateHand(handDealt: MutableSet<Card>): Int {
    // Declare a variable to store the total of the pip values
    var cardTotal = 0

    // for loop implementation to evaluate the hand
    for (card in handDealt) {
        val pip = card.pip
        cardTotal += if (pip == "A") {
            11
        } else if (pip == "J" || pip == "Q" || pip == "K") {
            10
        } else {
            pip.toInt()
        }
    }

    // Return the cardTotal, which is an integer that is the sum of the pip values of the two cards
    return cardTotal
}

/*
 * Implementation of the printResults function. Receives the handDealt (i.e. the pip and the suit of both cards) and
 * the handEvaluated (i.e. the total of the pip values of the two cards).
 */
fun printResults(handDealt: MutableSet<Card>, handEvaluated: Int) {
    println("Your hand was:")

    // Print the pip and suit of each card in the hand
    for (card in handDealt) {
        val pip = card.pip
        val suit = card.suit
        println(pip + suit)
    }

    // Print the total of the hand
    println("For a total of: $handEvaluated")

    /*
     * Prints additional messages if the player wins (i.e. hits Blackjack with the total equaling 21) or if the player
     * loses (i.e. the total exceeds 21)
     */
    if (handEvaluated == 21) {
        println("You Win!")
    } else if (handEvaluated > 21) {
        println("You Lose!")
    }
}

// Implementation of the main function
fun main() {
    // Call the createDeck function to create the deck of playing cards
    val deck = createDeck()

    // Size of the hand to be dealt
    val sizeOfHand = 2

    // Call the dealHand function to deal the hand using the created deck of playing cards
    val handDealt = dealHand(deck, sizeOfHand)

    // Call the evaluateHand function to determine the pip total of the two cards in the hand dealt
    val handEvaluated = evaluateHand(handDealt)

    // Call the printResults function to print out information about the hand dealt and its total
    printResults(handDealt, handEvaluated)
}