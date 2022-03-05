import java.time.Year
import scala.io.StdIn.readLine

object AgeCalculator extends App {
//greet the person with their name
  // Calculate when they will be 100 years old and print it out
  //val year = 2022 //This would be ok
  //but, we can import java.time.Year

  val year = Year.now.getValue
  println(year)
  val yourName = readLine("What is your name friend?") //func imported
  println(s"Nice, your name is $yourName, isn't it?")


  val yearsCount = readLine("How old are you?")
  println(s"Cool you are $yearsCount old.")

  //val hundredYearsOldYear = year.toInt + 100 - yearsCount.toInt


  //val total = yearsCount.toDouble * cost //converted String to Double to get Double * Double
  //val rounded = Math.round(total * 100) / 100.00 //Old trick to round and have 2 digits of percision
  //println(s"You will get 100 years old in $hundredYearsOldYear .")
}
