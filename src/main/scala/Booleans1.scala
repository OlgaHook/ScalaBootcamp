object Booleans1 extends App {

  val isMathCorrect = 2*2 == 4
  println(s"Maths looks fine: $isMathCorrect")

  println(5>10)
  println(25<5)
  println("10<=2*5",10<=2*5)

  val a = 2
  val b = 4
  println("a*a = b", a*a == b)
  println("a*a !=b", a*a!=b)

  println(01+0.2) //Floats and Doubles gives some troubles
  //thus this equality might not work
  println(01+0.2-0.3 == 0)
  //easy solution is simply to round
  println(Math.round(0.1+0.2-0.3) == 0)
  //we can compare numerical values even if they are not the same data type
  println(0 == 0.0)

  var myCgar = 'A'
  val anotherChar = 'a'
  println(myCgar == anotherChar)

  val anotherName = "Voldemars"
  val myName = "Valdis"
  println(anotherName == myName) // result is FALSE
  println( myName < anotherName)
  //lexicographical comparison , meaning V is the same for both,
  // but a < o in ascii/unicode tables

  //for string comparison by length we have that ability
  println(myName.length < anotherName.length)


}
