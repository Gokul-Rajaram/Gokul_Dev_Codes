package Lectures.FunctionalProgramming
/*
Flat maps and Maps are generally used instead of using loops to connect every element and do transformations
 */
object MapFilterFlatMap extends App {
  val list = List(1,2,3,4)
  println(list)
  println(list.head)
  println(list.tail)
  //map   --Transforms one element to one another element (one to one transformations) for every element in the list
  println(list.map(_+1))        //add value 1 with each and every value of the list
  println(list.map(_+ " is a Number"))   //Concatenates the number with the string

  //filter --filters the values in the list based on given condition
  println(list.filter(_%2 == 0))    //Even Number
  println(list.filter(_ == 1))      // value  = 1 will be printed

  //flatMap --Transforms one element to many(one to many transformations) element of each and every element in the collection or list
  val toPair = (x: Int) => List(x,x+1)
  println(list.flatMap(toPair))
  println(list.map(toPair))       // to show the difference added this statement

  //Exercise--printing all the combinations of chars and numbers list
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("Red","Blue","Green")

  //Here flat mapping all the characters with numbers as shown below.. using map concatenated the number and chars
  //****Iterating*****
  val combinations = numbers.map(n => chars.flatMap(c => colors.map(d => d +"" + c + "" + n)))    //Numbers.flatMap should not be used
  val combination = numbers.flatMap(n => chars.flatMap(c => colors.map(d => c + "-" + n + "_" + d)))
  println(combinations)
  println(combination)

  //******Foreach******
  list.foreach(println)      //using foreach printing every element of the list

  //*******for Comprehensions***** to make it understandable -- rewrtting the combination val function
  val forCombination = for {
    n <- numbers
    c <- chars
    d <- colors
  } yield (c + "-" + n + "_" + d)         //yield is a result keyword
  println(forCombination)

  //To make it meaning full for -Comprehensions are used
  //Below is same for Comprehension including the GUARD(which is used to filter some values in a list or value)\
  val forCombination1 = for {
    n <- numbers if n%2 == 0        //only take even numbers which will pass the condition
    c <- chars
    d <- colors
  } yield (c + "-" + n + "_" + d)         //yield is a result keyword
  println(forCombination1)

  /*we can always use for comprehensions in our code to make it meaning full
  * For -Comprehensions can be used instead of foreach statement to give side effects like below*/
  val forPrint = for {
    n <- numbers
  }println(n)
    //above code will print the values in numbers as it while using foreach loop

    //SYNTAX OVERLOAD
  val syovl = list.map{ x => x * 10}    //these type is called as syntax overload
  println(syovl)    //prints the overloaded values

  //Exercise --Maybe
}
