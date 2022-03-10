import scala.io.StdIn.readLine

object Day5Factorials extends App {
println("Factorials")

  val number = readLine("What positive integer you want to know Factorial for?").toInt
println(s"Calculating Factorial for $number")
  var result: Long = 1 //Do put 0 for multiplication !!!
  //Need to make a loop
  for (n <- 2 to number) result *= n

  println(s"Factorial of $number is $result")

}
