package com.github.OlgaHook

import java.nio.file.{Files, Paths}

object Day22ReadingXMLFromWeb extends App{
  //original source for XML is here: https://docs.microsoft.com/en-us/previous-versions/windows/desktop/ms762271(v=vs.85)

  val url = "https://gist.github.com/Ram-N/5189462/raw/46db0b43ad7bf9cbd32a8932f3ab981bd4b4da7c/books.xml"

  //first I need a folder to save the data
  val dstFolder = "src/resources/xml"
  //https://stackoverflow.com/questions/28947250/create-a-directory-if-it-does-not-exist-and-then-create-the-files-in-that-direct
  Files.createDirectories(Paths.get(dstFolder)) //will do it only once - no error if it exists

  val fileName = "books.xml"
  val dst = s"$dstFolder/$fileName"
  println(s"Will save in $dst")

  val text = MyUtil.getTextFromWebAndSave(url, dst)
  println(text.take(500))
}
