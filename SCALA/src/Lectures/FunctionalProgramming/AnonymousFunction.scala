package Lectures.FunctionalProgramming

object AnonymousFunction extends App {
  //normal way of creating a function
  val doubler = new Function[Int,Int] {
    override def apply(x:Int): Int = x * 2
  }

  //In scala we can create the exact same function as Below
  val doubler1 = (x: Int) => x * 2      //Syntactic sugar for the above function
  //It is called Anonymous Functions(LAMBDA)
  //We can also declare the same function with compiler letting know the type as below
  val doubler2: Int => Int = x => x * 2
  //Need to specify the type

  //Multiple Parameters in Lambda
  val adder: (Int,Int) => Int = (a: Int ,b: Int) => a + b   //Better use this type by specifying the return type
  val adder1: (Int,Int) => Int = (a,b) => a + b

  //When there no parameters supplied
  val dosomething = () => "When it's come to lambda you should call function with () then only it will return value " +
    "else it will return the function itself"
  /*****Should be very carefull while using the lambda functions*****/
  println(dosomething)      //Function itself
  println(dosomething())    //this will be returning the value

  //curly braces with the lambdas
  val stringtoInt = {
    (str:String) => str.toInt
  }
  println(stringtoInt("232"))

  /****MORE Syntactic Sugar*****/
  val incrementer: Int => Int = _+1   //equivalent to x => x+1
  val addition: (Int,Int) => Int = _ + _  //equivalent to x => x+y
  //when using the _ should need to use the proper types for each parameters

 val superAdd = (x:Int) => (y:Int) => x + y
  val adderres = superAdd(30)       //this will also returns  7 previously we have used the different function
  println(adderres(2))
  println(superAdd(3)(4))


}
