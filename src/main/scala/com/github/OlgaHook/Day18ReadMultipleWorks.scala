package com.github.OlgaHook

import com.github.OlgaHook.GutenbergUtil.{getAuthor, getTitle}

case class Book(fileName: String, author: String, title: String, textLines: Array[String] =Array[String]()) {
  def printStats():Unit = {
    println(s"File: $fileName")
    println(s"Author: $author")
    println(s"Title:: $title")
    println(s"First 20 lines:\n${textLines.take(20).mkString("\n")}")
  }
}//no lines by default


object Day18ReadMultipleWorks extends App {
  val files = MyUtil.getListOfFiles("src/resources")
  println(files.head)
  val lines = MyUtil.getLinesFromFile(files.head.getPath)
  println(files.head.getName)
  println(files.head.getParent)
  val author = getAuthor(lines)
  println(author)
  println(getTitle(lines))

  def getBooksFromFiles(files:Array[String]):Array[Book] = {
    val bookArray = for (file <- files) yield {
      val lines = MyUtil.getLinesFromFile(file)
      val author = getAuthor(lines)
      val title = getTitle(lines)
      //TODO filter the lines until *** START OF THIS PROJECT - need to find the index of that line
      //      "*** START OF THIS PROJECT".r.findAllMatchIn()
      var index = 0
      for ((line, i) <- lines.zipWithIndex) {
        if (line.contains("*** START OF THIS PROJECT")) {
          index = i
        }
      }
      val contentLines = lines.drop(index) // so we drop everything before the last find, or 0 drop if nothing was found
      Book(file, author, title, contentLines) //TODO get only relevant lines so skip UNTIl *** START OF THIS PROJECT
    }
    bookArray
  }

  //so I need to convert my List of Files into Array of Strings
  val myBooks = getBooksFromFiles(files.map(_.getPath).toArray)
  println(myBooks.head)
  println(myBooks.last)
  println(myBooks.last.textLines.mkString("\n"))
  println(myBooks.head.textLines.take(20).mkString("\n"))

  myBooks.foreach(_.printStats())

}
