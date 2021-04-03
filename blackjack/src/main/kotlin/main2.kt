sealed class Player(val deck: Deck) {
    protected val hands: Hands = Hands(deck.getCard(), deck.getCard())

    abstract fun playing(): Boolean
    fun points() = hands.values()

    fun newCard() {
        hands.add(deck.getCard())
    }

    fun isOver(): Boolean {
        return points() > 21
    }
}

class Human(deck: Deck) : Player(deck) {
    override fun playing(): Boolean {
        println("Vaš red")
        while (true) {
            println("Vaša ruka: $hands, rezultat: ${points()}")
            if (isOver()) {
                println("Izgubili ste")
                return true
            }

            print("Želite li još igrati? (Upišite: dalje, d ili da)")
            if (readLine()?.toLowerCase()?.trim() in listOf("dalje", "d", "da")) {
                newCard()
            } else {
                return false
            }
        }
    }
}

class Computer(deck: Deck, val playerScore: Int) : Player(deck) {
    override fun playing(): Boolean {
        println("Djeliteljev red")
        while (true) {
            if (isOver()) {
                println("Djeliteljeva ruka: $hands, rezultat: ${points()}")
                println("Djelitelj je izgubio sa " + points())
                return true
            }
            if (points() < 17 && points() < playerScore) {
                newCard()
            } else {
                println("Djeliteljeva ruka: $hands, rezultat: ${points()}")
                return false
            }
        }
    }

    fun show() = hands.show()
}

fun main(args: Array<String>) {
    var playAgain: Boolean
    do {
        val deck = Deck()
        val player = Human(deck)
        val computer = Computer(deck, player.points())
        var win: Boolean
        println("Djelitelj pokaziva: " + computer.show())
        if (player.playing()) {
            win = false
        } else if (computer.playing()) {
            win = true
        } else {
            win = player.points() > computer.points()
        }

        println(if (win) "Pobijedili ste!" else "Djelitelj je pobijedio.")
        println("Želite li ponovno igrati? (da ili ne) ")
        playAgain = readLine()?.toLowerCase()?.trim() in listOf("d", "da")
    } while (playAgain)
}