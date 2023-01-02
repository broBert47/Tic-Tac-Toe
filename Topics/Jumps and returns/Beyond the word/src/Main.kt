fun main() {

    val word = readln().toMutableList()

    for(i in 'a'..'z'){
        if(i in word){
            continue
        }
        print(i)
    }
}