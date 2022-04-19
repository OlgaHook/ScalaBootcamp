package com.github.OlgaHook

object GutenbergUtil {
  def getAuthor(lines: Array[String], prefix:String="Author:"):String = {
    val authorLines = lines.filter(_.startsWith(prefix))
    if (authorLines.length > 0) authorLines.head.replace(prefix, "").trim
    else "NO AUTHOR"

  }

  def getTitle(lines: Array[String], prefix:String="Title:"):String = {
    val titleLines = lines.filter(_.startsWith(prefix))
    if (titleLines.length > 0) titleLines.head.replace(prefix, "").trim
    else "NO TITLE"
  }
}
