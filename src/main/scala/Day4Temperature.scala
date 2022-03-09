
import scala.io.StdIn.readLine

object Day4Temperature extends App {

  println("Temperature exercise")

  //Ask for their temperature
  //if temperature is below 35 print "That is a bit too cold"
  //if temperature is between 35 and 37 (both sides inclusive) then print "You are all right!"
  //finally if the temperature is over 37 then print "You have a fever! Consider contacting a doctor"
 /*
  val normalTemperature = 36.6
val minNormalTemp =  35
  val maxNormalTemp = 37
  val temperature = readLine("What is your temperature?").toDouble
  if (temperature<minNormalTemp){
    println("That is a bit too cold")
  }else if (minNormalTemp>=temperature){
    println("You are all right!")
  }else if (temperature<=maxNormalTemp){
    println("You are all right!")
  }else if (temperature>maxNormalTemp){
    println("You have a fever! Consider contacting a doctor")
  }
  */
//more correct way
val normalTemperature = 36.6
  val minNormalTemp =  35
  val maxNormalTemp = 37
  val name = readLine("What is your name?")
  val temperature = readLine("What is your temperature?").toDouble
  if (temperature<minNormalTemp){
    println("That is a bit too cold")
  }else if (minNormalTemp>=temperature && temperature<= maxNormalTemp){
    println("You are all right!")
  }else if (temperature>maxNormalTemp){
    println("You have a fever! Consider contacting a doctor")
  }
}
