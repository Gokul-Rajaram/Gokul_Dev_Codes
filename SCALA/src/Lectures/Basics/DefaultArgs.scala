package Lectures.Basics

object DefaultArgs extends App {
  //For the below type of function Accumulator is a variable where it will get parameter as 1 most of the time
  //So we can assign default values to these type of parameters
  def FactHelper(x: Int , accumulator: Int = 1): BigInt = {
    if(x <= 1) accumulator
    else
      FactHelper(x-1,x*accumulator)
  }
  println(FactHelper(3))      //this will return the factorial of 10 considering accumulator passed as 1 which is default value

  /* We can also pass value for those parameters which is having default value,if we give value as in below case
  we need to give with the parameter name to avoid confusion to the compiler
   */
  def DownloadFile(FileName: String = "Scala", FileFormat: String ="txt", FileSize: Int =10): Unit ={
    println("File is Downloaded Successfully")
  }
  println(DownloadFile())   //as all the variables are assigned with default value it will work
  println(DownloadFile("Python",".py",100))   //this will work as usual
  println(DownloadFile(FileName="Java"))      //if need to provide 1 default value then we can use the parameter name

}
