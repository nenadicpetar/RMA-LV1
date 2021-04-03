enum class Calls {CLUBS, DIAMONDS, HEARTS, SPADES}

data class Cards(val deck: Calls, val rank: Int) {
    override fun toString(): String {
        return when (rank) {
            1 -> "A"
            11 -> "J"
            12 -> "Q"
            13 -> "K"
            else -> rank.toString()
        } + when (deck) {
            Calls.CLUBS -> "-Tref"
            Calls.DIAMONDS -> "-Karo"
            Calls.HEARTS -> "-Herc"
            Calls.SPADES -> "-Pik"
        }
    }
}

class Hands(cardOne: Cards, cardTwo: Cards) {
    private val cards: MutableList<Cards> = mutableListOf()
    private var aces = 0

    fun show() = cards[1]

    init {
        add(cardOne)
        add(cardTwo)
    }

    fun add(card: Cards): Hands {
        if (card.rank == 1) {
            aces++
        }
        cards.add(card)
        return this
    }

    fun values(): Int {
        var aces = aces
        var points = cards.map { it.rank }
            .reduce { acc, i ->
                acc + when (i) {
                    1 -> 11
                    in 10..13 -> 10
                    else -> i
                }
            }
        while (points > 21 && aces > 0) {
            points -= 10
            aces--
        }
        return points
    }

    override fun toString(): String {
        return cards.map { it.toString() }
            .joinToString(separator = " ") { it }
    }
}

class Deck {
    val cards: MutableList<Cards> = mutableListOf()

    init {
        for (rank in 1..13) {
            Calls.values().mapTo(cards) { Cards(it, rank) }
        }
        for (i in 0 until 52) {
            val choose = (Math.random() * (52 - i) + i).toInt()
            val temp = cards[i]
            cards[i] = cards[choose]
            cards[choose] = temp
        }
    }

    fun getCard() = cards.removeAt(cards.size - 1)

    override fun toString(): String {
        return cards.map { it.toString() }
            .joinToString(separator = " ") { it }
    }
}

fun main(args: Array<String>) {
    println(Hands(Cards(Calls.CLUBS, 3), Cards(Calls.DIAMONDS, 1))
        .add(Cards(Calls.SPADES, 12)))
    println(Deck())
}