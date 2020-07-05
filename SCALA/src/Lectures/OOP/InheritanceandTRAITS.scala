package Lectures.OOP

object InheritanceandTRAITS extends App {
  /*Scala allow inheritance through the key word "extends" as most of the languages it SCALA also
  allow Single CLASS Inheritance.
   */
  class Animal {
    def sound = "meeeeeeoooooow meeeeeeoooow"
    private def content ={ "Private class cannot be used from child/inherited class"}
    protected def protect ={ "Protected class only be used inside the child class can't be instantiated "}
  }
  //Below Inheriting class Animal in the cat class
  class cat extends Animal{
    def sleep = "purrrrr purrrrr purrrrrr"
    def exampleProtect: Unit = {
      println(protect)
    }
  }
  //Implementing class cat and using the def sound from class Animal
  val imp = new cat
  println(s"Cats are curious and when they are curious they " +
    s"sound like ${imp.sound} and when the sleep they give ${imp.sleep} sound")

  /*Access Modifiers --> PRIVATE    Accessible only in its class,
                     --> PROTECTED  Accessible in parent class and inside the inherited class but cannot use in the instance of child class
                     --> PUBLIC     Accessible in all the instance of child class and inside.
   */
  imp.exampleProtect
  val pvt = new Animal
  println(pvt)
  //constructors
  class Person (name:String, Age: Int)
  class Employee (name: String,Age:Int, idcard: String) extends Person(name,Age)
  //Here Person(name and age are the constructors as the parent class contains the parameters and we need to give the parameters

  /*overriding
  In scala overriding can be done to methods and val types as below
   */

  class dog extends Animal{
    override def sound = "bark bark bark bark"
  }
  val dogie = new dog
  println(dogie.sound)

  //polymorphism type substitution
  val unknown: Animal= new dog
  println(unknown.sound)

  /*
  Preventing Overrides--> by giving
   keyword "final" on methods we can make that function or method or types not to be override in any other child class
   final can be used in class level as
   */

}
