package playground

import scala.{:+, ::}

object Generics {

    class Animal

    class Cat extends Animal

    class Dog extends Animal

    // if B extends A , should List[B] extend List[A] ?

    // yes List[Cat] extends List[Animal] = covariance 共変
    class CovariantList[+A]

    val animal = new Cat

    val animalList: CovariantList[Animal] = new CovariantList[Cat]

    // no invariant 不変
    class InvariantList[A]

    val invariantList: InvariantList[Animal] = new InvariantList[Animal]

    // hell no contravaliant 反変
    class ContravariantList[-A]

    val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

    class Trainer[-A]

    val trainer: Trainer[Cat] = new Trainer[Animal]

    // bounded type

    // accepts sub type of Animal
    class Cage[A <: Animal](animal: A)

    // accepts super type of Animal
    // class Cage[A >: Animal](animal: A)
    val cage = new Cage(new Dog())


}
