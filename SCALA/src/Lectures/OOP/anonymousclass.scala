package Lectures.OOP

object anonymousclass extends App {
  abstract class Animal{
    def eat : Unit = "Crunch Crunch"
  }
  //here we have created the instance of an abstract class which is called as an anonymous class
  val funnyAnimal = new Animal{
    override def eat : Unit = println("Haha haha Haha Hehe Hehe WoooooHoooooo")
  }
  funnyAnimal.eat
  println(funnyAnimal.getClass)
  //above class in same way creating an instance without anonymously
  class anonymousclass$$anon$1 extends Animal {
    override def eat : Unit = println("Haha haha Haha Hehe Hehe WoooooHoooooo")
  }
  val anonymous = new anonymousclass$$anon$1

  println(anonymous.eat)

  //een traits can be instantiated anonymous class
  //parameters should be correctly passed as in the class when we use the anonymous class
  



}
