package Lectures.OOP

import Lectures.OOP.AbstractDataTypes.Dog

object Generics extends  App {
  class MyList[A]{
    //we can later declare the types while creating instance
  }
  //traits can also be type parameterised as above
  class MyMap[key,value]      //Parameterised class

  val listofIntegers = new MyList[Int]      //Here instead of "A" we have given the type as Int
  val listofStrings  = new MyList[String]

  //Generic Mehtods
  object MyList {
    def empty[A]: MyList[A]   = ???
  }
  val emptylistofIntegers = MyList.empty[Int]

  //variance problems
  class Animal
  class cat extends Animal
  class dog extends Animal

  //1.Yes, List[Cat] extends with list[Animal]    = COVARIANCE
  class CovariantList[+A]
  val animal:Animal = new cat
  val animalList:CovariantList[Animal] =new CovariantList[cat]

  //2.INVARIANCE =No
  class InvariantList[A]
  val invariantAnimalList:InvariantList[Animal] = new InvariantList[Animal]

  //3. Helll Nooo  CONTRAVARIANT
  class Trainer[-A]
  val trainer : Trainer[cat] = new Trainer[Animal]

  /*Bounded Types
  class Cage[A <: Animal](animal:A)     //Upper Bounded Types
  val cage =  new Cage (new Dog)

  class Cage1[A >: Animal](animal:A)     //Lower Bounded Types cage accepts only if something is super type of Animal
  val cage1 =  new Cage1(new Dog)\

   */







}
