import java.util.*

class Die {
    var value:Int = 0
    val rand:Random

    init {
        value = 0
        rand = Random()
    }

    fun roll() {
        value = 1 + rand.nextInt(6)
    }

    fun get():Int {
        return (value)
    }
}

fun input(prompt:String):String {
    var inputLine = ""
    print(prompt)
    try {
        val sys = java.io.InputStreamReader(
            System.`in`
        )
        val inBuffer = java.io.BufferedReader(sys)
        inputLine = inBuffer.readLine()
    }
    catch (e:Exception) {
        val err = e.toString()
        println(err)
    }
    return inputLine
}

fun inputInt(prompt:String):Int {
    var result = 0
    result = try {
        Integer.parseInt(input(prompt).trim { it <= ' ' })
    } catch (e:Exception) {
        0
    }
    return result
}

class Numbers{
    var ones = 0
    var twos = 0
    var threes = 0
    var fours = 0
    var fives = 0
    var sixes = 0
    var numbers:Int = 0
    fun checkNumbers(aDice: IntArray){

    }
}

class Winnings{
    var score:Int = 0
    var choice:Int = 0

    init{
        score = 0
    }

    fun checkWinnings(aDice:IntArray, wins:IntArray) {
        if (wins[0] == 0)
        {
            println("1 - Jamb")
        }
        if (wins[1] == 0)
        {
            println("2 - Full")
        }
        if (wins[2] == 0)
        {
            println("3 - Velika skala")
        }
        if (wins[3] == 0)
        {
            println("4 - Mala skala")
        }
        if (wins[4] == 0)
        {
            println("5 - Četiri iste")
        }
        if (wins[5] == 0)
        {
            println("6 - Tri iste")
        }
        if (wins[6] == 0)
        {
            println("7 - Par")
        }
        if (wins[7] == 0)
        {
            println("8 - Dva para")
        }
        if (wins[8] == 0)
        {
            println("9 - Broj 1-ica")
        }
        if (wins[9] == 0)
        {
            println("10 - Broj 2-ica")
        }
        if (wins[10] == 0)
        {
            println("11 - Broj 3-ica")
        }
        if (wins[11] == 0)
        {
            println("12 - Broj 4-ica")
        }
        if (wins[12] == 0)
        {
            println("13 - Broj 5-ica")
        }
        if (wins[13] == 0)
        {
            println("14 - Broj 6-ica")
        }
        if (wins[14] == 0)
        {
            println("15 - Zbroj")
        }
        println("Što želite vidjeti, ako imate?")
        choice = inputInt("")
        var pairs = 0 //varijabla za parove
        var numbers = 0 //varijabla za brojeve
        var winnings = 0
        var winningsA = 0
        var ones = 0
        var twos = 0
        var threes = 0
        var fours = 0
        var fives = 0
        var sixes = 0
        Arrays.sort(aDice)

        //brojevi
        while (numbers < 6){
            if (aDice[numbers] == 1) {
                ones++
            }
            if (aDice[numbers] == 2) {
                twos++
            }
            if (aDice[numbers] == 3) {
                threes++
            }
            if (aDice[numbers] == 4) {
                fours++
            }
            if (aDice[numbers] == 5) {
                fives++
            }
            if (aDice[numbers] == 6) {
                sixes++
            }
            numbers++
        }

        //parovi
        while (pairs < 6)
        {
            if (pairs != 0) {
                if ((aDice[0] == aDice[pairs])) {
                    winnings++
                }
            }
            if ((pairs != 0) && (pairs != 1)) {
                if ((aDice[1] == aDice[pairs])) {
                    winnings++
                }
            }
            if ((pairs != 0) && (pairs != 1) && (pairs != 2)) {
                if ((aDice[2] == aDice[pairs])) {
                    winnings++
                }
            }
            if ((pairs != 0) && (pairs != 1) && (pairs != 2) && (pairs != 3)) {
                if ((aDice[3] == aDice[pairs])) {
                    winnings++
                }
            }
            if ((pairs != 0) && (pairs != 1) && (pairs != 2) && (pairs != 3) && (pairs != 4)) {
                if ((aDice[4] == aDice[pairs])) {
                    winnings++
                }
            }
            if ((pairs != 0) && (pairs != 1) && (pairs != 2) && (pairs != 3) && (pairs != 4) && (pairs != 5)) {
                if ((aDice[5] == aDice[pairs])) {
                    winnings++
                }
            }
            pairs++
        }


        if (winnings > 0){
            if (((aDice[0] == aDice[1] - 1) && (aDice[1] == aDice[2] - 1) //Skala
                        && (aDice[2] == aDice[3] - 1) && (aDice[3] == aDice[4] - 1)
                        && (aDice[4] == aDice[5] - 1)
                        && (choice == 3)))
            {
                winningsA = 1
            }
            else if ((ones > 0) && (twos > 0) && (threes > 0) && (fours > 0))
            {
                winningsA = 2
            }
            else if ((threes > 0) && (fours > 0) && (fives > 0) && (sixes > 0))
            {
                winningsA = 2
            }
            else if ((twos > 0) && (threes > 0) && (fours > 0) && (fives > 0))
            {
                winningsA = 2
            }
        }

        if((winningsA == 1) && (choice == 3))
        {
            println("Imate Veliku skalu.")
            score = 40
        }
        else if ((winningsA == 1) && (choice == 4))
        {
            println("Imate Malu skalu.")
            score = 30
        }
        else if ((winnings == 10) && (choice == 1))
        {
            println("Jamb!")
            score = 50
        }
        else if ((winnings == 3) && (choice == 6))
        {
            println("Imate tri iste.")
            score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4] + aDice[5]
        }
        else if ((winnings > 0) && (choice == 7))
        {
            println("Imate par.")
            score = 5
        }
        else if ((winnings == 2) && (choice == 8))
        {
            println("Imate dva para.")
            score = 10
        }
        else if ((winnings == 4) && (choice == 2))
        {
            println("Imate Full!")
            score = 25
        }
        else if ((winnings >= 6) && (choice == 5))
        {
            println("Imate četiri iste.")
            score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4] + aDice[5]
        }
        else if (choice == 9)
        {
            println("Imate $ones jedinica.")
            score = ones
        }
        else if (choice == 10)
        {
            println("Imate $twos dvica.")
            score = twos * 2
        }
        else if (choice == 11)
        {
            println("Imate $threes trica.")
            score = threes * 3
        }
        else if (choice == 12)
        {
            println("Imate $fours četvrtica.")
            score = fours * 4
        }
        else if (choice == 13)
        {
            println("Imate $fives petica.")
            score = fives * 5
        }
        else if (choice == 14)
        {
            println("Imate $sixes šestica.")
            score = sixes * 6
        }
        else if (choice == 15)
        {
            score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4] + aDice[5]
            println("Osvojili ste $score bodova.")
        }
        else
        {
            println("Niste osvojili ništa.")
            score = 0
        }

    }


    fun score():Int {
        return (score)
    }

    fun choice():Int {
        return (choice)
    }
}

fun ispisKockica(aDice: IntArray) {
    println("Kockica 1: " + aDice[0])
    println("Kockica 2: " + aDice[1])
    println("Kockica 3: " + aDice[2])
    println("Kockica 4: " + aDice[3])
    println("Kockica 5: " + aDice[4])
    println("Kockica 6: " + aDice[5])
}

class Player{
    var play = 1
    var scorea = 0
    var sum = 0
    val wins = IntArray(15)

    fun gamePlay(){

        while ((play == 1) && (sum < 15))
        {
            sum = 0
            val aDice = intArrayOf(0, 0, 0, 0, 0, 0)
            var roll = 0
            var point:Int //varijabla za broj kockica
            var diceNumber:Int // varijabla za broj kockice
            var rollA = 0
            var rollB = 3
            val die = Die()
            var numDice:Int = 0
            while (numDice < 6)
            {
                die.roll()
                aDice[numDice] = die.get()
                numDice++
            }
            ispisKockica(aDice)

            do {
                rollA = inputInt("Koliko kockica želite ponovno bacati? (0 - 6)")
                if (rollA > 0)
                {
                    val reroll = IntArray(rollA)
                    point = 0
                    while (point < rollA)
                    {
                        rollB = inputInt("Koje?")
                        reroll[point] = rollB
                        point++
                    }
                    diceNumber = 0
                    while (diceNumber < rollA){
                        if (reroll[diceNumber] == 1) {
                            die.roll()
                            aDice[0] = die.get()
                        }
                        if (reroll[diceNumber] == 2) {
                            die.roll()
                            aDice[1] = die.get()
                        }
                        if (reroll[diceNumber] == 3) {
                            die.roll()
                            aDice[2] = die.get()
                        }
                        if (reroll[diceNumber] == 4) {
                            die.roll()
                            aDice[3] = die.get()
                        }
                        if (reroll[diceNumber] == 5) {
                            die.roll()
                            aDice[4] = die.get()
                        }
                        if (reroll[diceNumber] == 6) {
                            die.roll()
                            aDice[5] = die.get()
                        }
                        diceNumber++
                    }
                    roll++
                    ispisKockica(aDice)
                }
            }

            while ((roll < 2) && (rollA > 0))
            val prize = Winnings()
            prize.checkWinnings(aDice, wins)
            wins[prize.choice() - 1] = 1
            var scoreSum:Int = 0
            while (scoreSum < 15)
            {
                sum += wins[scoreSum]
                scoreSum++
            }
            scorea += prize.score()

            println("Vaš trenutni rezultat je: $scorea")
            if (sum < 3)
            {
                play = inputInt("Želite li ponovno igrati? (1 = da; 2 = ne)")
            }
            else
            {
                println("Igra završena!")
            }
        }
    }
}

fun main() {
    Player().gamePlay()
}