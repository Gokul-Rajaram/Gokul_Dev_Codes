package Lectures.FunctionalProgramming

/**
 * Higher Order Functions and Curries
 */

object HOFsandCurries extends App {
  // Here in this below function the Parameters are including (type,Function) => Function
  //These functions are called Higher Order Functions--Function which includes another function as a type.
  val SuperFunction: (Int,(String,(Int => Boolean) => Int) => (Int => Int)) = null
  /*
  Either takes function as parameters or returns functions as return type then those are called
  Higher Order Functions (HOF)
  E.g => map,filter,flatmap --HOFs

  HOF--Classic Example function
  -Function 'f' that applies 'n' times over a value 'x'
  FuncName(f,n,x)
  FuncName(f,3,x) => f(f(f(x)))
  --nTimes(f,n,x) => f(f(.....f(x))) =>nTimes(f,n-1,f(x))=> nTimes(f,n-2,f(f(x)))     //RECURSION IN HOFs
   */
  def nTimes(f: Int => Int,n:Int,x:Int): Int = {
    if(n <= 0)
      x
    else
      nTimes(f,n-1,f(x))
  }
  val plusOne = (x:Int) => x + 1
  println(nTimes(plusOne,10,1))     //Applying plusOne method for 10 times  it should return 11
  println(nTimes(plusOne,2,1))
  //Above one is very simple example for HOFs

  //Above Function can also be written as below
  //ntb(f,n) = x => f(f(...f(x)))
  //increment10 = ntb(plusOne,10) = x => plusOne(plusOne(.....x))
  //val y = increment10(1)
  def nTimesBetter(f: Int => Int,n:Int): (Int => Int) ={
    if(n <= 0)
      (x: Int) => x
    else
      (x: Int) => nTimesBetter(f,n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne,10)
  println(plus10(1))      //which will also return 11 as output

  /*
  Curried Functions--These are used when you want to use various values using a helper functions
   */
  val superAdder: Int => (Int => Int) = (x:Int) => (y: Int) => x + y
  val add3 = superAdder(3)      //helper functions
  println(add3(17))


  //functions with multiple parameter'ed lists
  def curriedFormatter(c:String)(b:Double):String = c.format(b)     //String contains the format

  //Various implementations of above functions
  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")
  //In curried functions we can give fewer parameters at the beginning and can be further add the rest of the parameters
  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  println(Math.PI.formatted("%4.2f"))     //Function Execution is like this

  //Proper way to use Curried Functions are Partial Function Substitution (ADVANCED)

  /*
  toCurry (f: (Int,Int) => Int) = Int => Int => Int
  fromCurry (f: Int => Int => Int) = (Int,Int) => Int
   */
  def toCurry(f: (Int,Int) => Int): Int => Int => Int ={
    x => y => f(x,y)
  }
  def fromCurry(f: Int => Int => Int): (Int,Int) => Int =
    (x,y) =>f(x)(y)

  /*
  compose(f,g) => x => f(g(x))
  andThen(f,g) => x => g(f(x))
   */
// f and g both are function for our assumption we can say like f and g both are Int to Int function
  def compose(f: Int => Int , g: Int => Int): Int => Int =
    x => f(g(x))

  def andThen(f: Int => Int , g: Int => Int): Int => Int =
    x => g(f(x))

  //Generalised version of the above function is ryt below
  //Here in composeG f(x) will return B so g(x) should return type A and the f(g(x)) should return type B
  def composeG[A,B,T](f: A => B , g: T => A): T => B =
    x => f(g(x))

  //Here in composeG g(x) will return C so f(x) should return type B and the f(g(x)) should return type C
  def andThenG[A,B,C](f: A => B , g: B => C): A => C =
    x => g(f(x))

  //Implementing the above functions
  def Multiplier: Int => Int => Int = toCurry(_*_)
  val multiply = Multiplier(3)
  println(multiply(5))          //should return 15

  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(5,5))     //should return 10

  val add = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add,times3)
  val ordered = andThen(add,times3)

  println(composed(5))      //x => f(g(x)) =>  2 + (5 * 3) => 17
  println(ordered(5))       //x => g(f(x)) =>  (5+2) * 3  => 21


}