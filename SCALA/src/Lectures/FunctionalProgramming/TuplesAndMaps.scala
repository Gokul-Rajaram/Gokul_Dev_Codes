package Lectures.FunctionalProgramming

object TuplesAndMaps extends App {
 //Tuples & Maps
  /*
  Tuples --> Finite Ordered Lists(Like Lists not exactly lists)
  Tuples are used for Group things together generally
  Tuples can be used to group most 22 elements of different data types
   */
  val aTuple = new Tuple2(2,"Tuple With INT and String Grouped")  //Tuple[Int,String] Syntactic sugar can be used without declaring types
  val aTupl = Tuple2(2,"Tuples can be created without the new keyword")
  val aTuple1 = (2,"Tuple without Tuple Key word")

  //Tuples can get the elements using _1 and _2.,
  println(aTuple._2)
  println(aTupl._2)
  println(aTuple1._2)

  //Tuples can be copied or swap the elements inside
  println(aTuple.copy("Copied Tuple"))        // by default it has replaced the first element (_1) and printed the Tuple
  println(aTuple.copy(10,"Copied Tuple"))
  println(aTuple.swap)      //swaps the position of elements

  /*
  MAPS
    --They associate Keys with Values
    Maps ->Keys(Items by which indexing is done) -> Values(Data corresponding to those maps)
    when doing the mapping there should be unique keys if the keys overlap then there will be a data lose
   */
  //Declaring maps    --General Syntax for declaring a Map
  val aMap:Map[String,Int] = Map(("Gokul", 7),("GOKUL", 999))    //General Syntax
  println(aMap)
  println(aMap.map(name => (name._1.toUpperCase(),name._2)))   //this will print only 1 result since the keys are overlapping


  //we can fetch the map values like below
  println(aMap.contains("Gokul"))     //returns true or false
  println(aMap("Gokul"))        //returns the paired value of the key "Gokul"


  /*
  println(aMap("TCS"))
  //This will return NoSuchValue Exceptions since the aMap does not have that key
   */

  //to avoid the above scenario we need to declare map as below which will return the default value of the Map
  //syntactic sugar of a,b in map --> (a,b) is equal to a->b

  val EmpDetail  = Map("Gokul"-> 16,"Sachin"->10,"Dhoni"->7).withDefaultValue("Invalid Value")


  println(EmpDetail.contains("Gokul"))
  println(EmpDetail("Dhoni"))
  println(EmpDetail("Virat"))     //WIll return DEFAULT VALUE since it is not present

  //Adding a value (Paired) into a Map
  //val emp =Map("Kohli"->18)   //this cannot be concatenated with another map
  //need to declare as pair as shown below
  val emp = "Virat"->18
  val EmpDetails = EmpDetail + emp      //adding a pair into a new Map //Combining 2 maps
  println(EmpDetails)


  //Functions on Maps
  //Maps,flatMap,filter
  //Map
  //prints all the values and maps the first element to uppercase
  println(EmpDetails.map(pair => pair._1.toUpperCase -> pair._2))

  //filters
  println(EmpDetail.filterKeys(x => x.startsWith("G")))    //gets the key starts with letter 'G'
  println(EmpDetails.filterKeys(_.startsWith("G")))   // x=>x can be _

  //MapValues
  println(EmpDetail.mapValues(x => "001_" + x ))   //it checks for all the values in the map and modifies it as mentioned here


  //CONVERSIONS to OTHER COLLECTIONS
  println(EmpDetail.toList)     //Map to List
  println(List(("Gokul",16)).toMap)     //List to Map

  /*****GROUPBY Statement*****/
  val names = List("Gokul","Raja","Sachin","Shivan","Ganapathy","Rama","Brahma")
  //Below command will groupBy will map the values present in list with index(0) of an element
  println(names.groupBy(name => name.charAt(0)))

  /*Exercise
  --Creating a Very Simple Social networking details based on Maps
  Person =String
  - add a person to a network
  - remove
  - friend
  - unfriend

  find  -Number of friends for a person
  - person with most friends
  - how many people have no friends
  - return if there is a social connection between two people or not
   */
  //Method to add a person to the Social Network
  def add(SocialNetwork:Map[String,Set[String]] , Person:String):Map[String,Set[String]] = {
    SocialNetwork + (Person -> Set())
  }

  //Method to add friend to a Person in Social Network
  def friend(SocialNetwork:Map[String,Set[String]],a:String,b:String):Map[String,Set[String]] = {
    val friendsA = SocialNetwork(a)
    val friendsB = SocialNetwork(b)

    SocialNetwork + (a -> (friendsA + b)) + (b -> (friendsA + a))
  }

  //Method to Unfriend a person from friendships
  def unFriend(SocialNetwork:Map[String,Set[String]],a:String,b:String):Map[String,Set[String]] = {
    val friendsA = SocialNetwork(a)
    val friendsB = SocialNetwork(b)

    SocialNetwork + (a -> (friendsA - b)) + (b -> (friendsA - a))
  }

  //Method to remove persons in Social Network
  def remove(SocialNetwork:Map[String,Set[String]],person:String):Map[String,Set[String]] = {
    def removeAux(friends: Set[String],NetworkAccu:Map[String,Set[String]] ):Map[String,Set[String]] = {
      if(friends.isEmpty) NetworkAccu
      else removeAux(friends.tail,unFriend(NetworkAccu,person,friends.head))
    }
      val unfriended = removeAux(SocialNetwork(person), SocialNetwork)
      unfriended - person
  }


  //Implementing the functions
  val empty:Map[String,Set[String]] = Map()       //Network initialization at first as empty
  val SocialNetwork = add(add(add(empty,"Gokul"), "Vishnu"),"Muruga")
  println(SocialNetwork)        //Social network without friendships
  println(friend(SocialNetwork,"Gokul","Vishnu"))
  println(unFriend(friend(SocialNetwork,"Gokul","Vishnu"),"Gokul","Vishnu"))
  println(remove(friend(SocialNetwork,"Gokul","Vishnu"),"Gokul"))

  val people = SocialNetwork
  val goks = friend(people,"Gokul","Muruga")
  val nfrnd = friend(goks,"Gokul","Vishnu")
  println(nfrnd)

  //Method for finding Number of friends of a person
  def nFriends(SocialNetwork:Map[String,Set[String]],person:String):Int =
    if(!SocialNetwork.contains(person)) 0
    else  SocialNetwork(person).size

  println(nfrnd,"Gokul")

  //Method to find most friends in the network
  def mostFriends(SocialNetwork: Map[String,Set[String]]):String ={
    SocialNetwork.maxBy(pair => pair._2.size)._1
  }

  println(mostFriends(SocialNetwork))

  //Method to find n People with no friends
  def PeoplenoFriends(SocialNetwork: Map[String,Set[String]]): Int = {
    SocialNetwork.filterKeys(k => SocialNetwork(k).isEmpty).size
  }

  println(PeoplenoFriends(SocialNetwork))

  //Method to find socila connection between friends
  def SocialConnection(network:Map[String,Set[String]],a:String,b:String):Boolean ={
    def bfs(target:String,considerpeople:Set[String],discoverpeople:Set[String]):Boolean ={
      if(discoverpeople.isEmpty) false
      else {
        val person = discoverpeople.head
        if(person == target)  true
        else if(considerpeople.contains(person))  bfs(target,considerpeople,discoverpeople.tail)
        else bfs(target,considerpeople + person,discoverpeople.tail ++ network(person))
      }
    }
    bfs(b,Set(),network(a) + a)
  }

  println(SocialConnection(SocialNetwork,"Gokul","Muruga"))
  println(SocialConnection(SocialNetwork,"Gokul","Vishnu"))
















}
