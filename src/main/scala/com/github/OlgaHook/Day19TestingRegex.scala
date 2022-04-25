package com.github.OlgaHook

import scala.util.matching.Regex

object Day19TestingRegex extends App{
  //documentations on regular expressions in Scala
  //https://www.scala-lang.org/api/2.13.x/scala/util/matching/Regex.html
  //test and build your regular expressions - https://regex101.com/

  val dateString = "   2004-01-20"
  val anotherDateString = "2022:04:21"
  val notADate = "202233-042312-21231" //NOT A DATE!

  def getYearMonthDay(dateString:String): (String, String, String)  = dateString match {
    case s"$date-$month-$day" => (date, month, day)
    case s"$date:$month:$day" => (date, month, day)
    case _ => ("NO YEAR", "NO MONTH", "NO DAY")

  }
  println(getYearMonthDay(dateString))
  println(getYearMonthDay(anotherDateString))
  println(getYearMonthDay(notADate)) // we should not get a date out of this...
  println(getYearMonthDay("1300-34:342"))

  //https://docs.scala-lang.org/overviews/core/string-interpolation.html raw interpolator
  //usefuls for building regex - less escaping especialy good to avoid mess like \\\\d

  val dateRegEx = raw"\D*(\d{4})\D(\d{2})\D(\d{2})\D*".r // .r at the end signifies regular expression

  def getYearMonthDayRegEx(dateString:String, dateRegEx: Regex= dateRegEx):(String, String, String) = {
    dateString match {
      case dateRegEx(year, month, day) => (year, month, day)
      case _ => ("NO YEAR", "NO MONTH", "NO DAY")
    }
  }

  println(getYearMonthDayRegEx(dateString))
  println(getYearMonthDayRegEx(anotherDateString))
  println(getYearMonthDayRegEx(notADate)) // we should not get a date out of this...
  println(getYearMonthDayRegEx("1300-34:342"))
  println(getYearMonthDayRegEx("1300-34:34andValdis"))


  //Find first match
  val dates = "Important dates in history: 2004-01-20, 1958-09-05, 2010-10-06, 2011-07-15"
  val firstFind = dateRegEx.findFirstIn(dates).getOrElse("No date found.")
  println(firstFind) //so this matches everything
  val firstYear = for (m <- dateRegEx.findFirstMatchIn(dates)) yield m.group(1)
  println(s"First year $firstYear") //this is an option so should have called getOrElse

  val allYears = for (m <- dateRegEx.findAllMatchIn(dates)) yield m.group(1)
  allYears.foreach(println)

  //TODO let's do some exercises with regex!
}
