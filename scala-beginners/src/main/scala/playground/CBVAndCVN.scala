package playground

object CallByValue extends App {
    def callByValue(x: Long): Unit = {
        // same result
        println(x)
        println(x)
    }

    callByValue(System.nanoTime())
}

object CallByName extends App {
    def callByName(x: => Long): Unit = {
        // different result
        println(x)
        println(x)
    }

    callByName(System.nanoTime())
}
