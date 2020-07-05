package PlayGround

object ScalaPlayground extends App{
  println("Hello Scala !!!!")
  val x:Int = 10
  val astring: String = "Hello"
  val aboolean: Boolean = false
  val achar: Char = 'a'
  val anint: Int = x
  val ashort:Short = 1234
  val along: Long = 1288398382
  val aFloat:Float = 1.2f
  //VAL is IMMUTABLE
  //IF DATA TYPE IS NOT DECLARED COMPILER CAN INFER THE TYPES OF VALUES

  /* Variables*/
  //Variables are mutable and has side effects
  var aval:Int = 23
  println(aval)
  aval = 43
  println(aval)


}
