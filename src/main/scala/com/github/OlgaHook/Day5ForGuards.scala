package com.github.OlgaHook

object Day5ForGuards extends App {

  println("For Loops with Guards")
  //some more info here: https://alvinalexander.com/scala/scala-for-loop-examples-syntax-yield-foreach/
  for (i <- 1 to 10) {
    if (i % 2 == 0) println(s"Even!$i")
    else println(s"Odd $i")
  }

  //if we do not need the else we can put the if inside the loop iteration
  for (i <- 1 to 10 if i % 2 == 0) println(s"Even!$i")
  //sidenote: later we will se other methods of filtering

  //so the difference is when we do the filtering early or late

  //of course in the even odd example I could have use step (by) to do the same thing
  for (i <- 2 to 10 by 2) println(s"Even!$i") //but that is special case because or if was testing for evenness

  //we can have multiple if guards
  //this might be less writing that putting multple if statements inside the loop
  for {
    i <- 1 to 10
    if i > 3
    if i < 6
    if i % 2 == 0
  } println(i) //so this sould only print 4 the only number that matches ALL 3 conditions

  //we can use zipWithIndex to generate automatic numbering to our sequence items
  //this numbering starts with 0
  val name = "Valdis"
  for ((c, i) <- name.zipWithIndex) { //so we put a index to our sequence so we get two values each loop
    println(s"Letter No. $i is  $c")
  }

  //we can also use foreach to loop through collections / sequences of items
  name.foreach(letter => println(s"This is a $letter"))

}
