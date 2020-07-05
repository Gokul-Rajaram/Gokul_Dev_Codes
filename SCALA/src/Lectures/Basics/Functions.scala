package Lectures.Basics

object Functions extends App{
  //General function declarations
  //def -Keyword ,aFunction -FunctionName, (Parameters): Return Type = {Statement}
  def aFunction(a: String,b: Int): String = {
    a + " " + b
    //Returns the result of concatanations
  }
  //Function call
  println(aFunction("Hello",1) + "st time")

  //Parameter Less Function
  //we can declare function without type for below
  def aParameterLessFunction () = {
    "Parameter Less Functions can be just called by its name alone !!!"
  }
  //Calling by just name as the above is parameter less function
  println(aParameterLessFunction)

  //Recursive Functions are functions which is calling itself inside the function. this should be used instead of Loops in SCALA
  //On using recursive function should declare a return type
  def aRecursiveFunction(str: String,n: Int): String ={
    if (n == 1)
      str
    else
      str + aRecursiveFunction(str,n-1)
  }

  println(aRecursiveFunction("Scala Recursive Function \n",3))

  /****WHEN YOU USE LOOPS IN SCALA--MUST USE RECURSION****/

  def aFunctionwithSideEffects(aStr: String): Unit = println(aStr)
  aFunctionwithSideEffects("Function can have types which return with side effects like Units here in this function it will print the string passed as parameters")

  //AUXILLARY Functions -which functions can be defined inside another function
  def aBigFunction(n:Int): Int = {
    //Function defined inside another function
    def aSmallFunction(a:Int, b: Int): Int = a * b
    //Return Expressions
    aSmallFunction(n,n-1)
  }
  println(aBigFunction(10))




}
