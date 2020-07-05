package Lectures.OOP
import java.sql

import PlayGround.{Learning, Studying}
//we can always use alias name as below when importing a class
//import PlayGround.{Learning, Studying => Student}  // ALIAS name as Student and we need to use this to create an instance
/* this alias naming will be usefull when you import 2 same name classes with different packages as below */
import java.util.Date
import java.sql.{Date => sqlDate}

/*ON declaring/Creating instance it will be assumed to take first import*/

//this will be automatically grouped when you import a class from an already imported package

//import PlayGround._       //this will import all the classes inside the package we need to use ._ keyletters

//Our Package name will present here

object PackagingandImports extends App {
  //Package members can be accessible using their simple name as below
  val writer = new Writer("Gokul","Rajaram",2020)
  println(writer.fullname())

  //if we are not in proper package we need to import the package
  import PlayGround.Learning        //in the package playground Learning class is present

  //Packages are orderedn hierarchically
  //matching folder structures

  //Package Objects--SCALA Specifics
  println(Say)

  //we can import packages using the Package._ name and it will import all the classes
  val study = new Studying

  val day = new Date      //first import = java.util
  println(day.getTime)

  // for using second import sql.util we can use either alias or fully qualified name as below
  val dy = new sqlDate(2020,2,23)
  println(dy.getTime)




}
