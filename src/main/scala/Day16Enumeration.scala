import Fingers.Finger

//more examples here
//https://www.baeldung.com/scala/enumerations
//https://alvinalexander.com/scala/how-to-create-use-enumerations-scala-cookbook-examples/
//https://www.scala-lang.org/api/current/scala/Enumeration.html

//Scala 3 has a different syntax
// https://dotty.epfl.ch/docs/reference/enums/enums.html

//notice object so singleton meaning we only have one Color object
object Color extends Enumeration {
  val Red: Color.Value = Value("(255,0,0)") //maybe I would want to store a tuple of 3 values here here
  val Green: Color.Value = Value("(0,255,0)")
  val Blue: Color.Value = Value("(0,0,255)")
}

object Fingers extends Enumeration {
  type Finger = Value //so all Fingers have same type of Value

  val Thumb, Index, Middle, Ring, Little = Value
}



object Day16Enumeration extends App {
  println("Let's have some fun with Finger enumerations!")

  println(Color.Green)
  println(Color.Blue.id) //this will print a numeric value which we generally do not care too much when using Enum
  println(Color.Red.id) //this will print a numeric value which we generally do not care too much when using Enum
  println(Color(0))
  val myGreen = Color.Green.toString //if I need a string
  println(myGreen)

  //looping
  println("Printing ALL the colors")
  for (color <- Color.values) println(color.id, color)

  println("How about the Fingers?")
  for (finger <- Fingers.values) println(s"My finger No. ${finger.id} is $finger")

  def isRude(someFinger: Finger):Boolean = {
    someFinger == Fingers.Middle
  }

  println(isRude(Fingers.Ring))
  println(isRude(Fingers.Middle)) //this is rude indeed

  //TODO Your Task is to create an enumeration of days of the week
  //create an method (outside Days enumeration)to check if it is weekend - so similar logic to what we did in the last lecture pattern matching
  //here the difference that we are using specific enums
}
