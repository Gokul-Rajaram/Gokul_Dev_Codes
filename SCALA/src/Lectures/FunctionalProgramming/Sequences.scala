package Lectures.FunctionalProgramming

import scala.util.Random

object Sequences extends App{

  /*
  Sequences uses apply method with keyword seq  as Seq()
  It is considered to be a list, IT can be indexed,iterated,concatenated,appended,reversed and etc.,
  a lot of other grouping,sorting, searching and slicing besides maps and flatMaps
   */

  val aSequence = Seq(1,4,3,2,9)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence.head)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7,8))    //Adds the sequence (concatenating)
  println(aSequence.sorted)

  /*Ranges
  * Ranges can be used to get values between a range
  * we can use ranges to do some specific function for specific times
  * */
  val aRange: Seq[Int] = 1 to 10      //or we can give range using until instead of to
  aRange.foreach(println)

  //to do some specific tasks n number of times
  (1 to 10).foreach(x => println(s"Printing $x time"))
  aRange.foreach(x => println(s"$x time"))

  /* LISTS
  Lists are immutable, sort length,reverse can be done
   */
  val aList = List(1,2,3,4)
  println(List)
  aList.foreach(println)

  //to prepend a value to the list we need to use :: operator or +: -prepend :+ append
  val prepend = 8 :: aList
  println(prepend)
  val append = aList :+ 10
  println(append)
  val preappend = 0 +: aList :+ 5
  println(preappend)

  //fill in lists --fill is curried value for list will print n times a value fill(n)(value)
  val apple5 = List.fill(5)("APPLE")
  println(apple5)

  //mkString will print the list as string and concatenate with the value passed
  println(aList.mkString("_-_"))

  /*
  ARRAYS
  --Can be equivalent to JAVA Arrays
  --Array is sequence
  --can be mutated
  --indexing is fast
  SYNTAX:   var arrayname = new Array[datatype](size)         -1D

   */
  //constructing an array
  val numbers = Array(1,2,3,4)
  val threElemeents = Array.ofDim[Int](3)
  println(threElemeents)      //this will print the definition

  threElemeents.foreach(println)    //Actual value of arrays will be printed
  //values are not initialized so it is printing as default values which are null or 0 based on data type
  numbers.foreach(println)

  //mutations in Array
  numbers(2) = 0        //This is syntactic sugar for arrays in scala we can directly update the value of existing array
  println(numbers)
  numbers.foreach(println)
  println(numbers.mkString("_str_"))

  //Array and Sequences   //these can be possible in scala and the final array formed is called wrapped array
  val numberSeq: Seq[Int] = numbers       //implicit conversions ==converting an array to sequences
  println(numberSeq)

  /*
  Vectors
  --constant indexed read and write
  --fast append and prepend
  --good performances for very large sizes
  --Offers same functionality as other collections
   */

  val vector: Vector[Int] = Vector(1,2,3,4)
  println(vector)

  //Vectors vs Lists   => Performance Comparision

  val maxRuns = 1000
  val maxCapacity = 100000

  //Creating a function to determine time take for an Operation
  def getWriteTime(collection: Seq[Int]): Double = {
    val r= new Random()
    val times = for {
      it <- 1 to maxRuns
    }yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity),r.nextInt())
      System.nanoTime()- currentTime
    }
    times.sum * 1.0 /maxRuns
  }
  val numberList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

    //keeps reference to tail
  //updating an element in the middle take long time
  println(getWriteTime(numberList))         // time taken usingList

  //depth of the tree is very small
  // it needs to replace entire chunk of list
  println(getWriteTime(numbersVector))      // time taken by vectored values

  //Vector values returning so fast and it is very fast compared to lists
  









  




}
