package com.github.OlgaHook

//https://mvnrepository.com/

import java.nio.file.{Files, Paths}

object Day21ReadingJSONFromWeb extends App{
  val url = "https://www.fruityvice.com//api/fruit/all"

  //first I need a folder to save the data
  val dstFolder = "src/resources/json"
  //https://stackoverflow.com/questions/28947250/create-a-directory-if-it-does-not-exist-and-then-create-the-files-in-that-direct
  Files.createDirectories(Paths.get(dstFolder)) //will do it only once - no error if it exists

  val fileName = "fruitFacts.json"
  val dst = s"$dstFolder/$fileName"
  println(s"Will save in $dst")

  val text = MyUtil.getTextFromWebAndSave(url, dst)
  println(text.take(500))

}
