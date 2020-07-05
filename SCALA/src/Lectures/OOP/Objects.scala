package Lectures.OOP
//every Application need to have main functions to runnable below is the main Function
object Objects extends App{
  /*scala does not have class level functionality/definition(val x= 12)
  no "static" function in scala.
  To create static functionality we need to create an object
   */
  //an Object can have val,var and method definition
  //Object cannot have parameter
  //can be implemented same way as class
  object Person{
    //Static--Class level functionality
    val name: String = "Gokul"
    def print = println(s"${Person.name} is learning SCALA Objects right now")
    def apply(name: Person): Person = new Person("Gokul")
  }
  /* Declaring Object and Class with same name and together they are called as COMPANIONs*/
  class Person(name: String){
    //Instance level functionality

  }
//We can directly call the object values without creating an instance as below
      println(Person.name.toUpperCase)
      Person.print
  //we can create instance of object as below without "new" Keyword
  val Obj = Person        //scala Object = SINGLETON INSTANCE
  val Obj1  =Person
  println(s"${Obj.name} has learnt creating instance of an object and implementation")
  println(Obj == Obj1)      //returns true as scala Objects are singleton INSTANCE

  val person1 = new Person("Kalai")    //creating instance for companion class
  val person2 = new Person("Raja")
  //Here it won't match person1 with person2 as these are class instance
  println(person1==person2)

  val gokul = Person(person1)
  println(gokul)
}
