package Lectures.OOP

object MethodNotations extends App {
  /* Calling a method using INFIX Notations are called SYNTACTIC Sugar*/

  //Since we have created the Person class outside the object in previous OOPExercise.scala file
  //we need to create inside to avoid conflict
  class Person(val name: String,favouritemovie:String ){
    def isfav(movie: String) = movie == favouritemovie
    def HangoutWith(person: Person):Unit = {
      println(s"${this.name} is going to ${this.favouritemovie} with ${person.name}")
    }
    def unary_! : String = s"Ohh My God !!!, It's a blessing from $name"
    def isAlive : Boolean = true
    def apply(): String = "Apply will be the keyword of () which can be used for Syntactic Sugar"
  }
  val gokul = new Person("Gokul","Interstellar")
  println(gokul.isfav("Interstellar"))
  println(gokul isfav "Interstellar")     //both the statements are equivalent
  //infix notations(above space are called) == Operator notations (infix can be passed with single parameter easily)
  //Infix STYLE can be used for single parameter methods/class implementations
  //OPERATORS in SCALA
  val amma = new Person("Amma","Rajini Movies")
  println(gokul HangoutWith amma)       //using infix operator as the method recieves only single operator

  //ALL OPERATORS in SCALA are methods
  println(1.toFloat)
  println(10.equals(10))

  //we can use method name as + , - and etc., any thing can be used in SCALA

  /*Prefix Operator*/
  val x = -1
  val y = 1.unary_-       //here unary_- is equals to -(prefix)

 println(!gokul)
  println(gokul.unary_!)        //Here both implementations of the functions are same

  //these type of operator usage is limited to + - ! ~
  //All these are called Syntactic SUGAR

  //postfix notations
 println(gokul.isAlive)
  println(gokul isAlive)      //both are equivalent

  //apply
  println(gokul.apply())
  println(gokul())      //Both will be equivalent


}

