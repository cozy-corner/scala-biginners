package playground

import scala.annotation.tailrec

// dont raise stack over flow error
object Recursion extends App {
    def anotherFactorial(n: Int): BigInt = {
        @tailrec
        def factHelper(x: Int, accumulator: BigInt): BigInt =
            if (x <= 1) accumulator
            else factHelper(x - 1, x * accumulator) // tail recursion = use recursive call as the last expression

        factHelper(n, 1)
    }
}
