package com.github.OlgaHook

import scala.io.StdIn.readLine

object Day3InputHandling extends App {

  val myName = readLine("What is your name friend?") //func imported
  println(s"Cool, your name is $myName, isn't it?")
  //using $ sign before my VARIABLE we can put our val Directly into String
  //called String interpolation

  val potatoeCount = readLine("How many kg of potatoes do you have?")
  println(s"Cool you have $potatoeCount kg potatoes")

  val cost = 0.78
  val total = potatoeCount.toDouble * cost //converted String to Double to get Double * Double
  val rounded = Math.round(total * 100) / 100.00 //Old trick to round and have 2 digits of percision
  println(s"So those must cost you $rounded Eur.")

}
