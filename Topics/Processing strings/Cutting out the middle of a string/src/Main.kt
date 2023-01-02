fun main() {
    val input = readln()

    if (input.length % 2 == 1) {
        val pola = input.length / 2
        println(input.substring(0, pola) + input.substring(pola+1, input.length))
    } else {
        val pola = input.length / 2
        println(input.substring(0, pola-1) + input.substring(pola+1, input.length))
    }



}