package com.github.OlgaHook

import scala.io.StdIn.readLine

object Day9Excercise extends App {
  /*
  val greeting = readLine("Hello!Please write a sentence.")
  println(s"Good! You wrote : $greeting")
  //Split sentence into words using split , you will will have a sequence of words, we did this on Day 8
  val words = greeting.split(" ")
  println(words.mkString(" * "))
  val newGreeting = words.mkString(" - ")
  println(newGreeting.mkString(" - "))
  //Generate word length sequence (can use map or yield)
  val greetSequence = greeting.toSeq
  //println(greetSequence.getClass)
  println(greetSequence)
  //Filter only words of length over 5
  //print word lengths for every word
  //print the long words
  //you are allowed to use yield or map/filter
  */
  val sentence = readLine("Enter any sentence, please:\n") //  \n - entering from new line

  val words = sentence.split(" ")
  println(s"The words from sentence:\n${words.mkString(",")}")

  val wordsLength = words.map(_.length) //so new sequence will be word lengths for each word in the words
  println(s"Word lengths:\n${wordsLength.mkString(",")}")

  val wordsOver5 = words.filter(it => it.length > 5)
  println(s"Words of length over 5:\n${wordsOver5.mkString(",")}")

  for (word <- words) {
    println(s"$word length is ${word.length}")
    //advantage of a regular for loop is that it is much easier to add extra instructions
    //we could do more stuff here
  }
  //with foreach we can also do more work but then we need { }
  //  words.foreach(word => println(s"$word length is ${word.length}"))
  words.foreach(word => {
    println(s"$word length is ${word.length}")
    //do more stuff
    println(s"Still with the same $word")
  })

}
