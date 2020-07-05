package Lectures.Basics

object Expressions extends App {
  //Expressions
  val x  = 1 + 2 //Here 1+2 is the expression and compiler will assign the values of x as 3 and type as Int
  println(x)
  println(2+3+4)
  //*,/,|,-,&,^,,<<,>>> left shift right shifts
  println(1 == x)
  // similarly, <= ,>= , !=
  println(!(1==x))
  //Operators like !,||,&&

  //Below things only work with variables.. and changing the variable values are called "Side Effects"
  var avar: Int = 2
  avar += 3   //Here it will return 5, Similar to this we can do same for  *=,-=,/=,
  println(avar)

  /*INSTRUCTIONS(do) and EXPRESSIONS(Value)--Scala focuses on Expressions*/

  //IF expressions Example for scala returning Values
  val acondtion = true
  val aconditionvalue = if(acondtion) "Good" else 3      //Here if expression is used to determine value
  println(aconditionvalue)

  var i =0
  while(i<10){
    i+=1
    print(i)
  }

  //NEVER DO THE ABOVE KINDA LOOP EVER AGAIN
  //EVERYTHING IN SCALA IS EXPRESSIONS(WILL RESULT A VALUE)

  val aweirdvalue = (avar = 3)     //Here aweirdvalue is Unit type which equals to void in other programming language
  println(aweirdvalue)

  //Side Effects in scala are - println,while loops,anything that is reassigning

  //Code Blocks-- these are set of codes assigned in a values declared between { and }
  //Code block is an expression and a value of it is the result of last expression

  val blockvalue = {
    var x: Int = 3
    var y: Int = 8
    if (y > x) "CodeBlock RETURN AS true" else "Failed"
  }
  println(blockvalue)

  //Values inside codeblock cannot be assigned outside

  val somevalue = {
    2<3
  }
  println(somevalue)

}
