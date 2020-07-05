package Lectures.OOP

object AbstractDataTypes extends App {
  abstract class Animal {
    val creatureType : String
    def eat:Unit
  }
  //abstract classes cannot be instantiated so we cannot create an instance of abstract classes
  //abstract class can be inherited in child class as below
  //Here we need to implement the Parent class object in child class while inheriting the abstract type classes
  class Dog extends Animal{
    override val creatureType: String = "DoOOOOOOGGGGGGGGG"
    override def eat: Unit = "Crunch Crunch"
  }
//traits
  //ultimate abstract data types
  trait Carnivore{
  def eat(animal:Animal): Unit
}
  //trait can be inherited with the classes(Multiple inheritance) like below
  class Crocodile extends Animal with Carnivore {
   val creatureType = "Croc"
    def eat: Unit = "katakuputaku katakuputaku"
    def eat(animal:Animal):Unit = println(s"I am a crocodile and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)


  /*
  Traits can be inherited multiple times unlike abstract classes
  multiple traits can be inherited to a single class using the keyword "with"
  traits = behaviour , abstract class = "thing"
   */
}
