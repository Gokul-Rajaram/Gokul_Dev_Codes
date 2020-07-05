package Lectures.OOP

object CaseClass extends App  {
  //CASE CLASSES
  /*
  Light weight data structures --equals hashcode, toString
  case classes are used to define lot of defaults and expressions with keyword "CASE"
   */

  case class Person(name:String, age: Int)      //case class definition
  class Person1(name:String, age: Int)

  //1.Class Parameters are Fields --Person1 Normal Class and Person is Case Class
  val gok = new Person("Gokul",25)
  println(gok.name)

  /*
  val gok1 = new Person1("Gokul",25)
  println(gok1.name)
  Here in this instance since the name consider to be just parameters it cannot be printed as above
 */
  //2.When we print the class definition or instance toString it will give meaningful info unlike normal class
  //println(instance) ==println(instance.toString)
  println(gok)
  println(gok.toString)     //Output is Person(Gokul,25)

  //3.In case classes equals,hashcode are implemented unlike normal class
  //these are used in Collections
  val gok2 = new Person("Gokul",25)
  println(gok == gok2)      //Here it prints true since both the instance are same but whereas in normal class result will be false

  //4.Case Class have COPY method
  //In this case we can copy an instance into another instance as below and passing change of parameters if there is any'
  val gok3 = gok.copy(name = "Rajaram")
  println(gok3)
  println(gok3.name)

  //5.Case classes have companion Objects
  //companion objects can make use of apply method when declared
  val thePerson = Person
  val kalai = Person("Kalaiyarasi",45)
  println(kalai)

  //6.Case Classes are serializable
  //7.case classes has extractor patterns== used in pattern matching very important function

  //case object also there in scala
  case object UK{
    def name: String = "United Kingdom"
  }
  //all the functionalities are similar to case classes except they cannot be companion objects they are their own companions








}
