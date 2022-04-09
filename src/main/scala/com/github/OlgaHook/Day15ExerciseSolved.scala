package com.github.OlgaHook

object Day15ExerciseSolved extends App {
  def getDay(day: Int): String = {
    //I could do some calculations here
    //then maybe use different internal result and give that to my matcher
    //here of course nothing needs to be done
    day match {
      case 1 => "Monday" // "Monday"
      case 2 => "Tuesday"
      case 3 => "Wednesday"
      case 4 => "Thursday"
      case 5 => "Friday"
      case 6 => "Saturday"
      case 7 => "Sunday"
      case default => s"Unknown Weekday - $default" //so default is just the last case we could use another name
    }
  }

  def getDayType(day: String): String = day match {
    case "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" => "Weekday"
    case "Saturday" | "Sunday" => "Weekend"
    case default => s"Groundhog Day - got $default"
  }

  println(getDay(8))
  println(getDay(1))
  println(getDay(5))

  println(getDayType("Tuesday"))
  println(getDayType(getDay(9)))
  println(getDayType(getDay(6)))
}
