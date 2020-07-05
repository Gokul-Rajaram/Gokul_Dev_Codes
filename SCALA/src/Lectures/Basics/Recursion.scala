package Lectures.Basics

import scala.annotation.tailrec

object Recursion extends App {
  def aFactorial(n: Int): Int = {
    if(n==1) n
    else{
      println("Calculating factorial of " + n + " - I first need " +(n-1))
      val result = n * aFactorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }
  println(aFactorial(5))      //JVM Needs as in this output to calculate

  /*On executing these functions JVM will have limited memory. So when executing below statement it will give
  Stack Over Flow Error --*/
  //println(aFactorial(5000))

  // to avoid these issue we can use tail recursive function
  // Here declared types as BigInt as at some point factorial of big number exceed the limit and will be printing as '0'
  /*****We can declare TAIL RECURSIVE function using the "@tailrec" keyword infront of the function compiler will give
   the error********/

  def anotherFact(n: Int): BigInt = {
    @tailrec      //Optional to make sure it is tail recursive if not compiler will threw error
    def FactHelper(x: Int,accumulator: BigInt): BigInt =      //accumulator is the key to store intermediate value instead of looping over and over again
      if(x <= 1) accumulator
    else
        FactHelper(x-1,x*accumulator)       //TAIL RECURSION --use RECURSIVE CALL as our LAST FUNCTION in our function
    FactHelper(n,1)
  }
  println(anotherFact(10000))

  /****NEED TO USE TAIL RECURSIVE when LOOPS***/
  @tailrec
  def ConcatTailRec(str:String,n:Int,accum:String): String = {
    if (n <= 0) accum
    else
      ConcatTailRec(str,n-1,str+accum)
  }
  println(ConcatTailRec("Hello Gokul" , 2, ""))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimetailrec(t: Int,isPrime: Boolean): Boolean =
      if(!isPrime) false
      else if(t<=1) true
      else isPrimetailrec(t-1,n % t !=0 && isPrime)

    isPrimetailrec(n/2,true)
  }

  println(isPrime(10))
  println(isPrime(31))



}
