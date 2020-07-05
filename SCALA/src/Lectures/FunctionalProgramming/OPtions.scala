package Lectures.FunctionalProgramming

import scala.util.Random

object Options extends App {
  /*
  An option is a wrapper of a value that might be present or not
  it encapsulates the possible options of a value
   */
  val MyFirstOption: Option[Int] = Some(4)
  val NoOption: Option[Int] = None

  println(MyFirstOption)
  println(NoOption)

  //Options are implemented for unsafe API's

  def UnSafeMethod: String = null
  //val result = Some(UnSafeMethod())     //this will return error because compiler does not know the value as none or Some(datatype)
  //to avoid the above error we need to use option like below
  val result = Option(UnSafeMethod)
  println(result)

  //Options are used for Chained methods like when we have safe method as a possibility when un safe method returns none
  //then we will use option to choose
  def SafeMethod: String = "A Valid Result"
  val ChainedResult = Option(UnSafeMethod).orElse(Option(SafeMethod))
  println(ChainedResult)

  //Above can be done in below way while designing
  def BetterUnSafeMethod(): Option[String] = None
  def BetterSafeMethod(): Option[String] = Some("A Better Result")

  val BetterChainedResult = BetterUnSafeMethod() orElse BetterSafeMethod()
  println(BetterChainedResult)

  //functions on Option
  println(MyFirstOption.isEmpty)
  println(MyFirstOption.get)    //get is UnSafe -when there is none passed it will through null pointer exception so
  //DO NOT USE get function


  //map flatMap filter
  println(MyFirstOption.map(_ * 2))     //x => x*2 written as _ * 2
  println(MyFirstOption.filter(x => x > 10))        //since there is no value greater than 10 so it will return None
  println(MyFirstOption.flatMap(x => Option(x* 10)))

  /*
  Exercise
   */

  val config: Map[String,String] = Map(
    ("host","10.5.10.103"),
    ("port","80")
  )

  class connection {
    def connect = "Connected"
  }

  object connection {
    val random = new Random(System.nanoTime())

    def apply(host:String,port:String):Option[connection] =
      if(random.nextBoolean()) Some(new connection)
        else
          None
  }

  //trying to establish connection
  val host = config.get("host")
  val port = config.get("port")
  /*
  if(h!=null)
    if(p!=null)
      return.connection.apply(h,p)
   return null
   */
  val Connection = host.flatMap(h => port.flatMap(p => connection.apply(h,p)))
  /*
  if(c!=null)
    return c.connect()
  return null
   */
  val ConnectionStatus = Connection.map(c => c.connect)
  println(ConnectionStatus)
  ConnectionStatus.foreach(println)

  //for the above short hand version in scala -Chained Calls
  config.get("host")
    .flatMap(host => config.get("port")
    .flatMap(port => connection(host,port))
    .map(Connection => Connection.connect))
    .foreach(println)




}
