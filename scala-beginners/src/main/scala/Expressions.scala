import scala.annotation.tailrec

object Expressions {
    def main(args: Array[String]): Unit = {

        val x = 3
        val codeBlocks = {
            val y = 2
            val z = y + 1
            if (z > 2 + x) "hello" else "goodbye"
        }
        // cannot be referenced
        //        println(z)
        println(codeBlocks)
    }
}

// when u need loops, use recursion
object Functions extends App {
    def repeatedFun(s: String, n: Int): String = {
        if (n == 1) s
        else s + repeatedFun(s, n - 1)
    }

    println(repeatedFun("hello", 3))
}

