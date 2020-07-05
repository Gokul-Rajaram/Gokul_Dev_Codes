package Lectures.OOP

object OOPExcercise extends App {
  val writer = new Writer("Gokul","Rajaram",1994)
  println(writer.fullname())

  val author = new Writer ("George R.R","Martin",1965)
  val Novel = new Novel ("Game of Thrones, Song of ICE and FIRE",2012,author)
  println(author.fullname())
  println(Novel.authorAge)
  println(Novel.isWrittenBy(author))
  println(s"I love the Novel ${Novel.Book} which is return by ${author.fullname()}")

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.print
  counter.inc(10).print
  counter.dec.print
  counter.dec(3).print

}
/* Novel and Writer Class
  Writer: First name, sur name, age
    method: returns full name

  Novel:name, year of release, author
    -authorAge
    -isWrittenBy(author)
    -copy new year of release = new instance of the author
 */
class Writer(firstname: String,surname:String,val year: Int){
  def fullname(): String = firstname + " " + surname
}
//we can use class type as parameter --here Writer is used as parameter
class Novel(name:String,year:Int,author:Writer){
  def Book =  name
  def authorAge = year - author.year
  def isWrittenBy (author:Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name,newYear,author)
}

/*counter class
  -recieves and int value
  -method current count
  -method to increment/decrement => new counter
  -overload inc/dec to recieve an amount
 */
class Counter(val count: Int = 0){
  def inc = {
    println("Incrementing")
    new Counter(count + 1)
    // here we need to instantiate as val is immutable if we declare the instantiate
    // the val it will not return so for loops we need to instantiate it every time
  }
  def dec = {
    println("decrementing")
    new Counter(count -1)
  }
  def inc(n:Int): Counter = {
  if(n<=0) this
  else inc.inc(n - 1)
  }
  def dec(n:Int): Counter ={
    new Counter(count - n)
  }
  def print: Unit =println(count)

}