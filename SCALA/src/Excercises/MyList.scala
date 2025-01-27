package Excercises

abstract class MyList {
  //head - returns first element of the list
  def head: Int
  def tail: MyList
  def isEmpty:Boolean
  def add(element:Int): MyList
  def printElement: String
  //polymorphic call
  override def toString: String = "[" + printElement + "]"
}
object Empty extends MyList{
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add(element:Int): MyList = new Cons(element, Empty)
  def printElement:String = ""
}
class Cons(h: Int, t: MyList) extends MyList{
  def head: Int = h
  def tail: MyList = t
  def isEmpty:Boolean = false
  def add(element:Int): MyList = new Cons(element,this)
  def printElement:String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElement
}
object LisTest extends App{
  val list = new Cons(1,new Cons(2,new Cons(3,Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)

  println(list.toString)
}

