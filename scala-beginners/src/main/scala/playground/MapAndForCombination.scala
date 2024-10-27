package playground

object MapAndForCombination extends App {


    val numbers = List(1, 2, 3)
    val chars = List('a', 'b', 'c')

    val colors = List("white", "black")

    val forCombination = for {
        n <- numbers if n % 2 == 0
        c <- chars
        cl <- colors
    } yield "" + c + n + "-" + cl
    println(forCombination)
    // List(a2-white, a2-black, b2-white, b2-black, c2-white, c2-black)

    // kotlin
    //    val forCombination = numbers
    //      .filter { it % 2 == 0 }
    //      .flatMap { n ->
    //        chars.flatMap { c ->
    //          colors.map { cl ->
    //            "$c$n-$cl"
    //          }
    //        }
    //      }

}
