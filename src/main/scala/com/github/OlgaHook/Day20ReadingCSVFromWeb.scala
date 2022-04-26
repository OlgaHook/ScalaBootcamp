package com.github.OlgaHook

import java.nio.file.{Files, Paths}

object Day20ReadingCSVFromWeb extends App{

  val url = "https://assets.publishing.service.gov.uk/government/uploads/system/uploads/attachment_data/file/1069435/fruitvegprices-19apr22.csv"

  //first I need a folder to save the data
  val dstFolder = "src/resources/csv"
  //https://stackoverflow.com/questions/28947250/create-a-directory-if-it-does-not-exist-and-then-create-the-files-in-that-direct
  Files.createDirectories(Paths.get(dstFolder)) //will do it only once - no error if it exists

  val fileName = url.split("/").last
  val dst = s"$dstFolder/$fileName"
  println(s"Will save in $dst")

  val text = MyUtil.getTextFromWebAndSave(url, dst)
  println(text.take(500))

}
