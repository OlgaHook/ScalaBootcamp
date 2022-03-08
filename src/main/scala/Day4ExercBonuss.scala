import scala.io.StdIn.readLine

object Day4ExercBonuss extends App{

  println("Xmas bonus calculator")
  //Ask for person's name
  //Ask for how long they have worked at the firm
  //Ask for monthly wage
  //Calculate Xmas bonus if they have worked at least 2  years otherwise print sorry no bonus
  //Bonus is years worked over 2 years * 15% of monthly wage
  //so 5 years worked, 1000 Euros wage would give 450 Euro bonus (3 years * 150)

  val personName = readLine("What is your name ?")
  println(s"Hello $personName !")
  val workExperience = readLine("How long do you worked at the firm?").toDouble
  println(s"Nice $workExperience years is pretty impressive experience")
  val wage = readLine("What is your monthly wage ?")
  if (workExperience < 5 ){
    println(s"You working less than 5 years, so sorry - bo bonus .")}else{
println(s"You earned a bonus - 450 eur")
  }

}
