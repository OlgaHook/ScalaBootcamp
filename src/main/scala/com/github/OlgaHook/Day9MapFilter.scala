package com.github.OlgaHook

import scala.collection.mutable.ArrayBuffer

object Day9MapFilter extends App {
  println("Mapping and filtering sequences")
  //the big idea is to have your loops done for you
  //no need to write loops by hand
  //we saw this with yield as well which is basically is syntactic sugar on top of map/filter

  val numbers = (0 to 12).toArray
  println(numbers.mkString(","))

  val squares = numbers.map(n => n * n) //so we go through all items in my collection/sequence and mapping onto new collection
  println(squares.mkString(","))

  //we could have done this using yield, you can keep using yield if it feels better but it is the same thing
  val squaresAgain = for (n <- numbers) yield n * n
  println(squaresAgain.mkString(","))

  //less efficient would be using a buffer then changing to immutable
  val squareBuffer = ArrayBuffer[Int]()
  for (n <- numbers) {
    squareBuffer += n * n
  }
  val squaresFromBuffer = squareBuffer.toArray
  println(squaresFromBuffer.mkString(","))

  //for simple mapping operations we can do even better
  val squaresFromMap = numbers.map(Math.pow(_, 2).toInt) //in this syntax _ refers to the item automatically
  //downside to this syntax that we can only use it once
  val plusTen = numbers.map(_ + 10) //so we create a new sequence from numbers by adding 10 to each item
  println(plusTen.mkString(","))

  def complicatedCalculation(n: Int): Double = {
    (n - 32) * 9 / 5.0
  }

  //  val calculatedNumbers = numbers.map(complicatedCalculation)
  //  val calculatedNumbers = numbers.map(complicatedCalculation(_)) //so slightly longer way of writing
  //the long from gives you the most flexibility
  val calculatedNumbers = numbers.map(item => complicatedCalculation(item)) //so slightly longer way of writing
  println(calculatedNumbers.mkString(","))

  val myName = "Valdis Rīga"
  val myUnicode = myName.map(_.toInt)
  println(myUnicode.mkString(","))
  val myChars = myUnicode.map(_.toChar)
  println(myChars.mkString(",")) //i might want to save it again
  println(myChars.mkString("")) //this will create a new string from the characters with no spaces or symbols

  //Second related idea is a Filter instead of mapping something we filter by some so called predicate some condition

  val myOddNumbers = numbers.filter(it => it % 2 == 1) //i check each item in numbers and see if divided by 2 it gives 1 in reminder
  //  val myOddNumbers = numbers.filter(it => true) //this would return everything in the new Sequence
  //  val myOddNumbers = numbers.filter(it => false) //this would return nothing meaning empty Sequence
  println(myOddNumbers.mkString(","))

  //shorter syntax
  val evenNumbers = numbers.filter(_ % 2 == 0) //so same as saying _ => _ % 2 == 0, or n => n % 2 == 0
  println(evenNumbers.toSeq)

  //so in effect filter uses a mapped array of truth values to select which item to keep
  val myOddTruths = numbers.map(it => it % 2 == 1)
  println(myOddTruths.toSeq)

  //we can create more complex filters
  def complexFilter(n: Int): Boolean = {
    //lots of complicated calculations perhaps
    n % 3 == 0
  }

  val myFilteredValues = numbers.filter(complexFilter)
  println(myFilteredValues.toSeq)

  //we can chain map and filter multiple times

  val myNewValues = numbers.filter(_ % 4 == 0).map(_ + 100).map(_ * 8) //I could keep adding maps and filters
  println(myNewValues.toSeq)

  val myNewValuesFromDifferentOrder = numbers.map(_ + 100).map(_ * 8).filter(_ % 4 == 0) //here filter is useless
  println(myNewValuesFromDifferentOrder.toSeq)


}
