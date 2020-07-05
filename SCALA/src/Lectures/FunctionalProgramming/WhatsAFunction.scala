package Lectures.FunctionalProgramming

object WhatsAFunction extends App {
  /*
  Use function as First class elements--purpose
  Problem--OOP
  only way to simulate functional programming is to create a class
   */
  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(3))       //Here an instance of a class can be called like function using apply method

  /*FUNCTION TYPES are supported in scala
  function type = Function1[A,B]
  by default SCALA Supports upto 22 parameters Function1, Function2, Function3 etc.,
   */
  val stringtoIntConverter = new Function[String,Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringtoIntConverter("23") + 7)

  val adder  =new Function2[Int,Int,Int]{
    override def apply(a:Int,b:Int): Int = a + b
  }
  println(adder(2,3))

  val adder1: ((Int,Int) => Int)  =new Function2[Int,Int,Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  println(adder1(2,3))
  //Function types Function2[A,B,R] = (A,B) => R
  /******ALL SCALA FUNCTIONS ARE OBJECTS*****/

  //a function with 2 strings and concatenate them
  val concat = new Function2[String,String,String]{
    override def apply(string1:String,string2:String): String = string1 + " " + string2
  }
  println(concat("Gokul","Rajaram"))

  //A Function which takes an int and returns a function which takes int and returns int

  val SuperAdder: Function1[Int,Function1[Int,Int]]   = new Function1[Int,Function1[Int,Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
    //Here, Adder3 will return 7 while passing parameter SuperAdder(3) would be value of x and adder3(4) would be y
    val adder3 = SuperAdder(3)        //3 + 4
    println(adder3(4))
    println(SuperAdder(3)(4))       //Curried function
    //these 2 prints 7 as result 2 ways of creating a result



}
trait MyFunction[A,B]{
  def apply(element:A): B       //defined apply method to make it call by ()
}
