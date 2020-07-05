package Lectures.FunctionalProgramming

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {
  //creating success and failure methods
  val asuccess = Success(3)
  val afailure = Failure(new RuntimeException("An Exception is occurred "))

  println(asuccess)
  println(afailure)    //since the failure method is used it wont error out instead prints the error

  //Using Try via apply method and catching the error
  val PotentialFailure = Try(throw new RuntimeException("Please check the code flow an exception is thrown"))
  println(PotentialFailure)

  //syntax sugar
  val anotherFailure = Try {
    //Code that might throw error --note here Try and try is different Try-apply method for catching error
  }

  //Utilities
  println(PotentialFailure.isSuccess)

  //orElse like options
  def unSafe(): String = throw new RuntimeException("Please check the code flow an exception is thrown")

  def Safe(): String = "UnSafe Failed and Safe method is executed"
  val fallbacktry = Try(unSafe()).orElse(Try(Safe()))
  println(fallbacktry)

  //When Designing --Make it easily readable
  def BetterunSafe(): Try[String] = Failure(new RuntimeException)
  def BetterSafe(): Try[String] = Success("A Better Result")
  val BetterFallBack = BetterunSafe() orElse BetterSafe()
  println(BetterFallBack)

  //map flatMap filter
  println(asuccess.map(_ * 10))
  println(asuccess.flatMap(x => Success(x * 100)))
  println(asuccess.filter(x => x > 10))   //if the filter values is not there it will return as failure

  /*
  Exercise
   */

  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String): Unit = println(page)

  class Connection {
    def get(url:String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>.....</html>"
      else throw new RuntimeException("Connection is Interrupted")
    }
     def getSafe(url:String): Try[String] = Try(get(url))
    }

  object HttpService {
    val random = new Random(System.nanoTime())
    def getConnection(host: String, port: String): Connection =
      if(random.nextBoolean())  new Connection
      else throw new RuntimeException("Could not connect the service please check ur network")

    def getSafeConnection(host: String, port:String): Try[Connection] = Try(getConnection(host,port))
  }

  val possibleconnection = HttpService.getSafeConnection(hostname,port)
  val possibleHtml = possibleconnection.flatMap(connection => connection.getSafe("/Home"))
  possibleHtml.foreach(renderHTML)

  //Short Hand
  println("ShortHand")
  HttpService.getSafeConnection(hostname,port)
    .flatMap(connection => connection.getSafe("/Home"))
    .foreach(renderHTML)



}
