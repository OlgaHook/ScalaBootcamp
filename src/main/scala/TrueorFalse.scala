object TrueorFalse extends App {

  println("Hello Booleans 🤣!")

  val isLate = true
  val isSunny = false //these are the basic building blocks of a program logic
  println(isLate, isSunny)

  val isMathCorrect = 2*2 == 4 //here we encounter equality operator ==
  //important that it is not mixed with assignment =
  //so == will give us a boolean value true or false depending on equality
  println(s"Math 2*2==4 looks fine: $isMathCorrect")
  val myName = "Valdis"
  println("Is my name Valdis?", myName == "Valdis")

  //there are other comparison operators which give us booleans
  println("5 > 10", 5 > 10)
  println("5*5 < 20", 5*5 < 20)
  println("10 <= 2*5",10 <= 2*5) //less or equal, this should be true
  println("8 >= 14/2", 8 >= 14/2)

  val a = 2
  val b = 4
  println("a*a== b", a*a == b)
  //there is also inequality, which is true when some things are NOT equal
  println("a*a!= b", a*a != b)
  println("a*a*10!= b", a*a*10 != b) //this will be a true because sides are NOT equal

  println(0.1+0.2) //this is where our floats/doubles give us trouble
  //thus this equality might not work
  println(0.1+0.2-0.3 == 0) //well not quite equal...
  //easy solution is simply to round
  println(Math.round(0.1+0.2-0.3) == 0)
  println(0 == 0.0) //we can compare numerical values even if they are not the same data type
  val myChar = 'A'
  val anotherChar = 'a'
  println(myChar == anotherChar) // we can compare any two data values if they are the same data type

  val anotherName = "Voldemars"
  println(myName == anotherName) //naturally a false
  println(myName < anotherName) //what will be the result and why this result?
  //so "Valdis" < "Voldemars" but why? two hypothesis are possible
  //turns out that it is so called lexicographical comparison
  //meaning V are same for both
  // however a < o in ascii/unicode tables
  println("Valdis" < "Vol") //still true

  //for string comparison by length we have that ability as well
  println(myName.length < anotherName.length)

}