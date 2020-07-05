package Lectures.Basics

object CBName_CBValue extends App {
  /***Below Function is Example for Call by Value
   Here "Value" is passed as the value of System.nanotime() function***/
    //VALUE IS COMPUTED BEFORE THE FUNCTION CALL AND SAME VALUE USED IN ALL OVER THE FUNCTION
  def CallByValue(Value: Long): Unit = {
    println("Called By Value :" + Value)        //println(System.nanotime()) -- Exact value is passed here
    println("Called By Value :" + Value)        //Exact value is passed as above here
  }

  /***Below Function is Example for Call by Name
   Here "Name" is passed as Actual Statement/function which is "System.nanotime()" ***/
    //Here the Call By Name is declared using "=>" operator while assigning type
    //VALUE IS NOT COMPUTED AN EXPRESSION IS PASSED SO EXPRESSION IS CALCULATED EVERYTIME IT IS USED IN THE FUNCTION
  def CallByName(Name: => Long): Unit = {
    println("Called By Name :" + Name)        //Here it is diff value of the same function
    println("Called By Name :" + Name)        //Here it is diff compared to above value of the same function
  }
  CallByValue(System.nanoTime)              //Call By Value Function Call
  CallByName(System.nanoTime)              //Call By Value Function Call

  //Example
  def infinite(): Int = 1 + infinite()
  def PrintFirst(x: Int, y: => Int): Unit = println(x)

  //println(infinite(),34)      // Here value of x is call by value and y is call by function so on caling it will threw overflow error
  //Below statement will execute without issues as here infinite() is never calculated until it is called and first value is printed
  //So No error will be thrown \
  /****CALL BY NAME DELAYS THE FUNCTION/STATEMENT EXECUTION*****/
  //println(34,infinite())


}
