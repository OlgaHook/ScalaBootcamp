package com.github.OlgaHook

import scala.io.StdIn.readLine

object Day10ExerciseWordCountSolved extends App {
  val sentence = readLine("Please enter sentence. ")
  val words = sentence.split(" ") //we split by whitespace

  val wordLengths = words.map(words => words.length)
  val wordsMap = Map(words.mkString(", ") -> wordLengths.mkString(", "))
  println(wordsMap)
  println(wordsMap.size) //will be only one long right

  //with zip we can loop through two sequences at once
  val wordsLengthArray = for ((word, length) <- words zip wordLengths) yield word -> length //also (word,length) would work
  println(wordsLengthArray.mkString(","))
  println(wordsLengthArray.length)
  val realWordsLengthMap = wordsLengthArray.toMap //here any duplicate keys will be lost of course
  println(realWordsLengthMap)

  //so about counts words but we want characters

}
