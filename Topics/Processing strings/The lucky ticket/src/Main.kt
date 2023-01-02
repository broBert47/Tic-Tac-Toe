fun main() {
    val unos = readln().toMutableList()

    val first: Int = unos[0].code + unos[1].code + unos[2].code
    val second: Int = unos[3].code + unos[4].code + unos[5].code

    if(first == second){
        println("Lucky")
    }else {
        println("Regular")
    }

}