package Excercises

object Function extends App{
  //1.Greeting Function
  def aGreeting(name: String,age: Int): String = {
    "Hi, My name is " + name + " and I am " + age + " years old"
  }
  println(aGreeting("Gokul",25))

  //2.Finding Factorial of a given number
  def aFactorial(n: Int): Int = {
    if(n==1) n
    else
      n * aFactorial(n-1)
  }
  println(aFactorial(5))

//3.Fibonocci series of 'n' Numbers
  def fibonocci(n: Int): Int = {
    if(n<= 2) 1
    else
      fibonocci(n-1) + fibonocci(n-2)
  }
  println(fibonocci(22))

  //4.Getting if 'n' is prime number
  def isPrime(n: Int): Boolean = {
    def isPrimeNumber(t: Int): Boolean =
      if(t <=1) true
      else n%t != 0 && isPrimeNumber(t-1)

    isPrimeNumber(n/2)
  }
  println(isPrime(37))
  println(isPrime(23*4))

}
