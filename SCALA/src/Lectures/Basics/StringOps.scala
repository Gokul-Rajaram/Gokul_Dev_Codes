package Lectures.Basics

object StringOps extends App {
  //String Operations
  val str: String = "Hi I am Gokul and I am learning Spark and Scala"

  println(str.charAt(3))    //Prints the character at index 2
  println(str.substring(8,13))   //substring
  println(str.split(" ").toList)
  println(str.startsWith("Hi"))     //returns boolean
  println(str.length)
  println(str.replace(" ", "+"))
  println(str.toUpperCase)

  val aNum: String = "2"
  val Num = aNum.toInt

  //prepending +:   Appending   :+
  println('A' +: aNum :+ 'Z')
  println(str.reverse)
  println(str.take(2))

  /*String Interpolators*/
  //S-Interpolators
  val name = "Gokul"
  val age = 25
  val greeting = s"Hello I am $name and my age is $age years"
  println(greeting)
  val agreet  =s"Hello I am ${name.toUpperCase} and next year my age wil be ${age+1}"   //we can do string operations like this
  println(agreet)

  /*F-Interpolators*/
  //These are for FORMATTED STRINGS,
  val speed = 1.2f
  println(f"$name%s can eat $speed%2.2f Samosa per minute")
  /*here f -> Key Word for formatted string
        $ -> will expand value
        %s -> Indicates it is string value
        %2.2f -> Indicates it is float value with 2 decimal places
   */

  /*Raw Interpolator*/
  println(raw"This is a \n NewLine")      //Back slashes wont be escaped
  val escape = "This is a \n NewLine"
  println(raw"$escape")       //when printing like this it will print the new line
}
