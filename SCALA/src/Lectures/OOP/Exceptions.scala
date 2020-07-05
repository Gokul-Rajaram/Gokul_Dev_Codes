package Lectures.OOP

object Exceptions extends App {
  //Throwing and Catching Exceptions
  val x:String = null
  //println(x.length)
  //1. Throwing an Exception
  //val aWeirdValue = throw new NullPointerException

  /*Throw classes are extends of throw class
  Exceptions and error are the major subtypes of those classes
  EXCEPTIONS come from JAVA Language not from SCALA
   */

  //2.how to CATCH Exception     --Need to use try --Catch Block
  //method which will have exceptions below
  def getIn(withExceptions: Boolean): Int = {
    if(withExceptions)  throw new RuntimeException("No Int for You !!!!")   //throwing exception with message
    else 42
  }
  try{
    //statement need to be catch'd when it is getting exceptions
    getIn(true)
  }catch {
        //Catching the exception and based on the exception type showing the message
    case e: RuntimeException => println("Caught in the Exception Catch block")
    //On commenting this and running it will throw exception since we are throwing Run time Exceptions
    case f: NullPointerException => println("Having Null Pointer Exception")
  }finally{
    //finally execution that need to be happen if an exception occurs
    //optional
    //use finally when something need to be logged
    println("Finally Block which executes the statement irrespective of there is an Exception or not")
  }

  //3. Creating our Own EXceptions
  class MyExceptions extends Exception {

  }
  val exception = new Exception
  //throw exception


}
