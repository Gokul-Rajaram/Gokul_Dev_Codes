package Lectures.OOP

object OOPBasics extends App {
  //Instantiating the class as below
  val classperson = new Person      //instantiated
  println(classperson)              //using the function

  val emp = new Employee("Gokul",25)
  println(emp.age)

  val methovr = new methodOverload("Gokul",25)
  println(methovr.x)      //will execute all the statement even though x alone is called
  println(methovr.greet("John"))
  println(methovr.greet1("John"))
  println(methovr.greet())
}

//Creating a class -It should be outside the object implementations since it is top level implementations
class Person
//Class implementations with constructors
class Employee(name: String, val age: Int)
//Class Parameters are NOT FIELDS   for declaring it as Feed need to declare with "val" or v"var"
//only then we can able to print class values
/*Class can include the following
    val and var definition
    method/function definitions
    Expressions
    NOTE: for every instantiation calls whole class is executed
 */
class methodOverload (name: String,age: Int)
{
  //body of the class
  val x = 2         //val definition
  println(1+3)      //Expressions

  //method
  def greet(name:String): Unit = println(s"$name says: Hi $name")     //this returns the name which is passed as param of method
  def greet1(name:String): Unit = println(s"${this.name} says: Hi $name")   //Here, this.name will be returning the value of class parameter

  /*OVERLOADING --> Over loading is defining a function with same name but with different parameter. Scala compiler will
  identify the functions with parameters and execute without issues
   */
  //Here name indicates the class parameter even without key word this as the function is not having parameter
  def greet(): Unit = println(s"$name Says: I am $name")

}
