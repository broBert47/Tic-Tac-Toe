import kotlin.system.exitProcess

fun main() {
     val userInput = readln().split("")
     val novaLista = ArrayList<String>()
     for(i in userInput){
          if(i != ""){
               novaLista.add(i)
          }
     }

     var result = ""
     var currentCharacter = ""
     var currentCount = 0

     for (i in novaLista.indices) {
          if (currentCharacter != novaLista[i]) {
               if (currentCount != 0) {
                    result += "$currentCharacter$currentCount"
               }
               currentCharacter = novaLista[i]
               currentCount = 1
          } else {
               currentCount++
          }
     }
     if (currentCount != 0) {
          result += "$currentCharacter$currentCount"
     }
     println(result)
}



/*
for(i in novaLista){
         var letter = novaLista[0]
         var count = 1
         if(i == letter){
              count++
         }
         if(i )

    }


   if(noA > 0 && noB > 0 && noC > 0){
          println("$a" + "$noA" + "$b" + "$noB" + "$c" + "$noC")
     } else if(noA > 0 && noB > 0 && noC == 0){
          println("$a" + "$noA" + "$b" + "$noB")
     } else (noA > 0 && noB == 0 && noC == 0){
          kotlin.io.println("$a" + "$noA" + "$b" + "$noB" + "$c" + "$noC")
     }
 */