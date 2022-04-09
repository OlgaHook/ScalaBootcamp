package com.github.OlgaHook

object Day11Exercise extends App {
  //TODO write a pangram tester
  //https://en.wikipedia.org/wiki/Pangram
  //check if text contains every letter of an alphabet at least once
  val charSet = "abcdefghijklmnopqrstuvwxyz".toSet
  println(charSet)
  val arr = charSet.toArray.sorted
  println(arr.mkString(","))
  for (n <- arr) {
    println(s"Item $n is in my set")
  }
  /*
def isPangram(text:String, alpha:String="abcdefghijklmnopqrstuvwxyz"):Boolean = {
    val charSet = text.toLowerCase.toSet
    //println(charSet)
    val alphaSet = alpha.toSet
    //println(alphaSet)
    val check = charSet & alphaSet
    //println(check)
    check.subsetOf(alphaSet)
  }
 */

  //for this task consider upuper and lower case the same
  def isPangram(text: String, alpha: String = "abcdefghijklmnopqrstuvwxyz"): Boolean = {

    false //FIXME
  }

  val myTestText = "The five boxing wizards jump quickly."
  println(isPangram(myTestText)) //should be true
}
