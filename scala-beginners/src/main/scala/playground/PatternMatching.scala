package playground

object PatternMatching extends App {


    class Person(val name: String, val age: Int)

    // name peron is best practice
    // name personPatter is not best practice
    object Person {
        // https://docs.scala-lang.org/ja/tour/extractor-objects.html
        def unapply(person: Person): Option[(String, Int)] =
            if (person.age < 21) None
            else Some((person.name, person.age))

        def unapply(age: Int): Option[String] =
            Some(if (age < 21) "minor" else "major")
    }

    val bob = new Person("Bob", 22)
    val greeting = bob match {
        case Person(n, a) => s"Hi, my name is $n and I am $a years old."
        case _ => "Something else"
    }

    val legalStatus = bob.age match {
        case Person(status) => s"My legal status is $status"
    }
    println(legalStatus)

    object even {
        def unapply(arg: Int): Boolean = arg % 2 == 0
    }

    object singleDegit {
        def unapply(arg: Int): Boolean = arg > -10 && arg < 10
    }

    val n: Int = 8
    val mathProperty = n match {
        case singleDegit() => "single degit"
        case even() => "an even number"
        case _ => "no property"
    }

    println(mathProperty)


    // infix pattern
    case class Or[A, B](a: A, b: B)

    val either = Or(2, "two")

    val humanDescription = either match {
        // equals Or(number, string)
        case number `Or` string => s"$number is written as $string"
    }
    println(humanDescription)

    val numbers = List(1, 25, 26, 27, 28, 41)

    // deconstructing sequences
    val varargs = numbers match {
        case List(1, _*) => "starting with 1"
    }
    println(varargs)

    // +A covariance 共変
    abstract class MyList[+A] {
        def head: A = ???

        def tail: MyList[A] = ???
    }

    case object Empty extends MyList[Nothing]

    case class Cons[+A](override val head: A, override val tail: MyList[A]) extends MyList[A]

    object MyList {
        def unapplySeq[A](list: MyList[A]): Option[Seq[A]] =
            if (list == Empty) Some(Seq.empty)
            else unapplySeq(list.tail).map(list.head +: _)
    }

    val myList: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))

    val decomposed = myList match {
        case MyList(1, 2, _*) => "starting with 1, 2"
        case _ => "something else"
    }

    println(decomposed)

    //
}
