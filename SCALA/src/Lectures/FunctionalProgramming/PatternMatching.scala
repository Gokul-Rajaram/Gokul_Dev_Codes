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

  /*
  Few Important things to be noted while using Pattern Matching
  ->Cases are in Order
  ->If there is no Match found then it will throw Match error (this can be avoided by keeping default case)
  ->type of Pattern Match Expression -WHen we have multiple data type in our match like String in one case and Int in another case and so on
  in that case compiler will try to get the unified data type of the match
  -> PM(Pattern Matching) works really well with case classes
   */

  //Don't use Pattern Matching everywhere as it might seems to be done everything pattern matching
  val isEvenPM = x match {
    case n if(n % 2 == 0) => "It is Even"
    case _ => "Not an even Number"
  }
  println(isEvenPM)
  val isEvenCond = if(x%2==0) true else false
  println(isEvenCond)
  val isEvenNormal = x % 2 == 0       //We can do the same thing as simple as this so don't complicate the simple things
  println(isEvenNormal)

  /*
  Exercise
   */

  trait expr
  case class Number(n: Int) extends expr
  case class Sum(e1:expr,e2:expr) extends expr
  case class Prod(e1:expr,e2:expr) extends expr

  def Show(e: expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1,e2) => Show(e1) + " + " + Show(e2)
    case Prod(e1,e2) => {
      def Prodtempfunction(exp: expr) = exp match {
        case Prod(_,_) => Show(exp)
        case Number(_) => Show(exp)
        case _ => "(" + Show(exp) + ")"
      }

    Prodtempfunction(e1) + " * " + Prodtempfunction(e2)
    }

  }
  println(Show(Sum(Number(2),Number(3))))
  println(Show(Sum(Sum(Number(2),Number(3)),Number(4))))
  println(Show(Prod(Sum(Number(2),Number(3)),Number(4))))
  println(Show(Sum(Prod(Number(2),Number(3)),Prod(Number(4),Number(5)))))




}
