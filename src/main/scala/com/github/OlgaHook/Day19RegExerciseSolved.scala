package com.github.OlgaHook

import scala.util.matching.Regex

object Day19RegExerciseSolved extends App{
  val src = "src/resources/ChristieA_Poirot_Investigates.txt" //you can choose another text if you wish
  //you can test your regex here first: https://regex101.com/ or somewhere else

  val text = MyUtil.getTextFromFile(src)

  val yearRegEx = raw"^\d{4} | \d{4} |\d{4}".r
  val years = yearRegEx.
    findAllIn(text).
    map(year => year.trim.toInt).
    filter(year => year > 1800 && year < 2100). //adjust to your liking
    toArray
  println(years.mkString(","))

  val regexYear = raw"\D*(\d{4})\D*".r
  def extractYear(line:String, regexYear: Regex = regexYear):Int = {
    line match {
      case regexYear(year) => year.toInt
      case _ => 0
    }
  }

  val linesWithYears = MyUtil.getLinesFromFile(src)
  val yearsArray = linesWithYears.map(l => extractYear(l)).filter(_ != 0)
  println(yearsArray.mkString(","))


  //  val dateRedEx = raw"\D+(\d{4})\D+".r
  //  val dateRedEx = raw" (\d{4}) ".r
  //thank you SO
  //https://stackoverflow.com/questions/4187356/regular-expression-to-extract-numbers-from-a-string
  val dateRedEx = raw"\b(\d{4})\b".r

  //  val allYears = (for (y <- dateRedEx.findAllMatchIn(text)) yield y.group(1)).toArray
  //  allYears.foreach(println)
  for (y <- dateRedEx.findAllMatchIn(text)) {
    println(y.group(1))
  }

  val phoneRegEx = raw"(\(\d{3}\) \d{3}-\d{4})".r
  val phoneNumbers = for (y <- phoneRegEx.findAllMatchIn(text)) yield y.group(1)
  phoneNumbers.foreach(println)

  val emailRegEx = raw"\S+@\S+\.\S+".r //not full email regex but good for 99.9% of emails
  //full email regex is monstrous: https://stackoverflow.com/questions/201323/how-can-i-validate-an-email-address-using-a-regular-expression

  val emails = emailRegEx.findAllIn(text).toArray
  println(emails.mkString(","))
}
