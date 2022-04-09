package com.github.OlgaHook

class Song(title: String = "", author: String= "", lyrics:Seq[String]){

  println(s"New song $title made by $author")
  println(s"The song has ${lyrics.length} lines")


  //  def sing():Unit={
  //    println(s"$title, Author: $author")
  //    for (line <- lyrics) println(line)
  //
  //  }

  //internal utility function
  private def printLyrics(lines:Seq[String], maxLines: Int = -1):Unit = {
    val numLines = if (maxLines == -1) lines.length else maxLines
    for (line <- lines.take(numLines)) println(line)
  }

  //private unless we want to allow outside use of this function
  private def printTitle():Unit = {
    println("-"*20)
    if (author != "") print(s"$author")
    if (title != "") print(s" - $title\n")
    println("-"*20)
  }

  def sing(maxLines: Int = -1):Song= {
    printTitle()
    printLyrics(lyrics, maxLines) //sometimes these pass along chains can get too long 3 or 4 functions deep
    this //so we return a com.github.OlgaHook.Song itself then we can chain the next command
  }

  def yell(maxLines: Int = -1):Song = {
    printTitle()
    val capitalLyrics = lyrics.map(_.toUpperCase)
    printLyrics(capitalLyrics, maxLines)
    this
  }

  //it is now trivial to add a similar whisper function
  def whisper(maxLines: Int = -1):Song= {
    printTitle()
    val capitalLyrics = lyrics.map(_.toLowerCase)
    printLyrics(capitalLyrics, maxLines)
    this
  }

}

class Rap(title:String, author:String, lyrics: Seq[String])
  extends Song(title:String, author:String, lyrics: Seq[String]) {

  //now any com.github.OlgaHook.Rap will have access to ALL com.github.OlgaHook.Song methods and values /fields
  def dropIt(drop:String, maxLines:Int = -1): Unit = {
    println(s"Dropping some beats with $drop on $title")
    //TODO actually add drop in between words for each line
    //TODO  you want to split each line in words
  }
}