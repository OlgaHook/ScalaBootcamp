package com.github.OlgaHook

object Day5ForLoops extends App {

  //for numbers 1 to 100 (included!)
  //print FizzBuzz if number divides evenly by both 5 and 7
  //print Fizz if number only divides by 5
  //print Buzz if number divides by 7
  //print number if number does not divide by 5 or 7
  //so something like this 1,2,3,4,Fizz,6,Buzz,..... 34,FizzBuzz,36,...., 99,Fizz (because 100 divides evenly by 5
  //printing can be done with number on new line like we have been doing

  /* Variant 1
  val numberOne = 5
  val numbetTwo = 7
  for (n <- 1 to 100) { //Define n (number), include 100
    if (n % numberOne == 0 && n % numbetTwo == 0)
      println(s"Fizzbuzz")
    else if (n % numberOne == 0)
      println(s"Fizz")
    else if (n % numbetTwo == 0)
      println(s"Buzz")
    else println(n + s",")
  }
   */

  //Option 2
  /*
  val fizz = 5
  val buzz = 7
  val start = 1
  val end = 100
  for (n <- start to end) { //Define n (number), include 100
    if (n % fizz == 0 && n % buzz == 0)
      println(s"Fizzbuzz")
    else if (n % fizz == 0)
      println(s"Fizz")
    else if (n % buzz == 0)
      println(s"Buzz")
    else println(n + s",")
    */
  //Option 3
  val fizz = 5
  val buzz = 7
  val start = 1
  val end = 100

  var textBuffer = "" //for longer String it should be a String buffer type
  for (n <- start to end) { //Define n (number), include 100
    if (n % fizz == 0 && n % buzz == 0) {
      println("Fizzbuzz")
      textBuffer += "FizzBuzz"
    } else if (n % fizz == 0) {
      println("Fizz")
      textBuffer += "Fizz"
    } else if (n % buzz == 0) {
      println("Buzz")
      textBuffer += "Buzz"
    } else println(n + ",")
    textBuffer += n.toString // need to convert the number to String before String concatenation
  }
  println("*" * 40)
}
