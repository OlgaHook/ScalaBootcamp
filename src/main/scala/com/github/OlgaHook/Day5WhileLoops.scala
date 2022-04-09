package com.github.OlgaHook

object Day5WhileLoops extends App {

  println("Alice did")
  println("talk")
  println("talk")
  println("talk")

  var i = 0 // i stands for iterator or index, something that we iterate/loop through
  while (i < 20) { //so this code block will repeat as long as i < 20 == true
    println("talking")
    println(s"index is $i")
    i += 1 //same as typing i = i + 1, Scala does not use the even sorter i++ syntax

  }
  println(s"Once while loop finishes i is $i")
  //  //what to do if we want to run "talk" say 50 times? It would be silly to paste above line 50 times
  //  var i = 0
  //  //so while loops run while the condition in parenthesis below is true
  //  while (i < 10) {
  //    println(s"talking when i is $i")
  //    //we need to do one more thing if we want to exit this loop...
  //    //    i = i + 1 //increment the counter
  //    i+=1 //increment the counter same as i = i + 1
  //  }
  //
  //  //there is room for forever loops in some application
  //
  var floor = 5 // for while loops our condition has to be variable since we are going to be changing
  while (floor > 0) {
    println(s"Taking the elevator now at floor $floor")
    if (floor == 2) println("Hey I live on the 2nd floor I need to get off!")
    floor -= 1 //which is same as floor = floor - 1
  }
  println(s"Should be at the ground floor $floor)")
  //
  //  //there might be occasions when we do obvious forever loops
  //  //  while(true) {
  //  //    //do something
  //  //    //ask for some exit condition
  //  //    //exit on that condition
  //  //  }
  //
  //    var sum = 0.0 //I could have also use toDouble
  //  //  var sum = 0.toDouble
  //  var sum:Double = 0 //one more option
  //  while (sum < 1000) {
  //    val num = readLine("Enter any number, program will quit when sum is over 1000").toDouble
  //    sum += num //same as sum = sum + num
  //    println(s"New sum is $sum")
  //  }
  //
  var userInput = ""
  var counter = 0
  //  //we need to negate the check so while userInput does not start with Q
  //  //  while (userInput != "Y") { //very strict only "Y" will quit
  //  //  while (!userInput.startsWith("Y")) { //anything starting with Y will end this loop
  //  while (!userInput.toUpperCase.startsWith("Y")) { //now anything text input starting with Y or y will quit the program
  //    counter +=1
  //    println(s"New Counter value is $counter")
  //    userInput = readLine("Do you want to quit (Y/N)?")
  //  }

  //it is possible to make a true loop with boolean checks, this would run forever.... :)
  //  while (i > 5 || i <= 5) {
  //    println("This will run forever")
  //    i+=1
  //  }
  //
  //  //we can also combine conditions inside loop check
  //  println("Starting another loop")
  //  while (counter < 10 && userInput != "Exit") {
  //    counter +=1
  //    println(s"New Counter value is $counter")
  //    userInput = readLine("Enter Exit to quit or count to 10 first...") //not very friendly
  //  }

  val start = 0
  val end = 50
  val step = 4
  i = start //i am reusing i, since I already made it
  while (i < end) {
    println(s"Doing something i is $i")
    i += step
  }
  println(s"We are done with while loops and i is $i")

  //in general while loops are for looping when we do not know exactly how many iterations we need
  //in other words - indefinite iteration

}
