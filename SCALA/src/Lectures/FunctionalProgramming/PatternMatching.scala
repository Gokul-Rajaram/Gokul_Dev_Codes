package Lectures.FunctionalProgramming

import scala.util.Random

object PatternMatching extends App{
  /*
  Pattern Matching is Similar to switch case statements in other languages but more power full
   */
  val random = new Random
  val x = random.nextInt(10)    //assign value between 0 to 10 for x randomly

  //Pattern Matching value x and returning different actions based on x value
  val Matching = x match {
    case 1 => "An Apple a day keeps doctor away"
    case 2 => "Every rose has it's thorn"
    case 3 => "3 Monkeys"
    case _ => "What we know is a drop ! what we don't know is an Ocean !"  //Here _ -> like keeping default value in case statements
  }
  println(x)
  println(Matching)

  /*
  Different uses of Pattern Matching
   */

  //1.Decompose Values --we can extract values from a case class and do pattern matching
  case class Person(name: String, Age: Int)
  val person = Person("Gokul",25)

  val greet = person match {
    case Person(n,a) => s"Hi.. I am $n and I am $a years old"
    case _ => "I don't know who I am !!!!!!!!!!!!!"
  }
  println(greet)
  //we can also conditions as below
  val greet1 = person match {
    case Person(n,a) if(a>20) => s"Hi.. My Name is $n and I am a Grown Man with loads of responsibility"
    case Person(n,a) => s"Hi.. I am $n and I am $a years old"
    case _ => "I don't know who I am !!!!!!!!!!!!!"
  }
  println(greet1)







}
