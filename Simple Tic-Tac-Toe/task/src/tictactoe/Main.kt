package tictactoe

import java.lang.Exception

fun main() {
    val glavnaLista = mutableListOf<MutableList<String>>()
    val red1 = mutableListOf<String>(" ", " ", " ")
    val red2 = mutableListOf<String>(" ", " ", " ")
    val red3 = mutableListOf<String>(" ", " ", " ")
    glavnaLista.add(red1)
    glavnaLista.add(red2)
    glavnaLista.add(red3)

    layout(glavnaLista)

    do {

        var madeMove = false
        do {
            val diffX = playerTurn(glavnaLista)
            val (num1, num2) = unosBroja()
            if (glavnaLista[num1 - 1][num2 - 1] == "X" || glavnaLista[num1 - 1][num2 - 1] == "O") {
                println("This cell is occupied! Choose another one!")
            } else {
                if (diffX == 0) {
                    glavnaLista[num1 - 1][num2 - 1] = "X"
                } else if (diffX == 1) {
                    glavnaLista[num1 - 1][num2 - 1] = "O"
                }
                layout(glavnaLista)
                madeMove = true
            }
        } while (!madeMove)

        val (winsX, winsO) = winCon(glavnaLista)
        var someoneWon = false
        if (winsX == 1 || winsO == 1) {
            if(winsX == 1){
                println("X wins")
            } else {
                println("O wins")
            }
            someoneWon = true
        } else if(drawStatus(glavnaLista) == 9 && winsX == 0 && winsO == 0){
            println("Draw")
            someoneWon = true
        }
    } while(!someoneWon)

}

fun playerTurn(list: MutableList<MutableList<String>>): Int {
    var noX = 0
    var noO = 0
    var noU = 0
    for (i in list) {
        for (j in i) {
            when (j) {
                "X" -> noX++
                "O" -> noO++
                " " -> noU++
            }
        }
    }
    return noX - noO
}

fun layout(list: MutableList<MutableList<String>>) {
    println("---------")
    for (red in list) {
        print("| ")
        for (kolona in red) {
            print(kolona)
            print(" ")
        }
        print("|")
        println()
    }
    println("---------")
}

fun winCon(list: MutableList<MutableList<String>>): Pair<Int, Int> {
    var winsX = 0
    var winsO = 0
    val conX = mutableListOf<String>("X", "X", "X")
    val conO = mutableListOf<String>("O", "O", "O")

    val con1 = mutableListOf<String>(list[0][0], list[0][1], list[0][2])
    val con2 = mutableListOf<String>(list[1][0], list[1][1], list[1][2])
    val con3 = mutableListOf<String>(list[2][0], list[2][1], list[2][2])

    val con4 = mutableListOf<String>(list[0][0], list[1][0], list[2][0])
    val con5 = mutableListOf<String>(list[0][1], list[1][1], list[2][1])
    val con6 = mutableListOf<String>(list[0][2], list[1][2], list[2][2])

    val con7 = mutableListOf<String>(list[0][0], list[1][1], list[2][2])
    val con8 = mutableListOf<String>(list[0][2], list[1][1], list[2][0])

    if(con1 == conX) winsX++
    if(con2 == conX) winsX++
    if(con3 == conX) winsX++
    if(con4 == conX) winsX++
    if(con5 == conX) winsX++
    if(con6 == conX) winsX++
    if(con7 == conX) winsX++
    if(con8 == conX) winsX++

    if(con1 == conO) winsO++
    if(con2 == conO) winsO++
    if(con3 == conO) winsO++
    if(con4 == conO) winsO++
    if(con5 == conO) winsO++
    if(con6 == conO) winsO++
    if(con7 == conO) winsO++
    if(con8 == conO) winsO++


    return Pair<Int, Int>(winsX, winsO)

}

fun drawStatus(list: MutableList<MutableList<String>>): Int{
    var noX = 0
    var noO = 0
    var noU = 0
    for (i in list) {
        for (j in i) {
            when (j) {
                "X" -> noX++
                "O" -> noO++
                " " -> noU++
            }
        }
    }
    return noX + noO
}

class NoText {
    fun correctInput(): Int {
        var value: Int? = null
        while (value == null) {
            try {
                value = readln().toInt()
            } catch (e: Exception) {
                println("You should enter numbers!")
            }
        }
        return value
    }
}

fun unosBroja(): Pair<Int, Int>{
    val numInput = NoText()
    var num1 = 0
    var num2 = 0

    do{
        val unosPozicije = readln().split(" ")
        num1 = unosPozicije[0].toInt()
        num2 = unosPozicije[1].toInt()
        if(num1 < 0 || num1 > 3 || num2 < 0 || num2 > 3){
            println("Coordinates should be from 1 to 3!")
        }
    } while(num1 < 0 || num1 > 3 || num2 < 0 || num2 > 3)

    return Pair<Int, Int>(num1, num2)
}