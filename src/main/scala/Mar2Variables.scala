object Mar2Variables extends App{
  println("Explore variables")
//test - comments pushing on Git

val myName = "Olga" // val as a constatn value (cant be changed in furure)
  // val is more prefferible than var
  // myName = "Marta" -not allowed
  println(myName)

  //var - allows to change
  var myJob = "bookeeper"
  println(myJob)
  myJob = "manager"
  println(myJob)

  val myCar:String = "WV"
  val myNumber = 42 //Integer - Whole number no fraction
  val myPi = 3.1415926 //Double which is Double precision Float

  val bigNum = 2_000_000_000
  println(bigNum)
  val reallyBigNum = bigNum * 3

  println(reallyBigNum)
  println(Math.pow(2,31))
// For bigger number we use Long data type which is a 64 bit Integer

  //val myLongVal = 8_000_000_000
//println(myLongVal)
  //println(Math.pow(2,63))//that is the limit for LONG integers /positive side, same for negative
  //otherwise well get a warning "integer number too large"

  val isLate = true
  val isTired = false
  //those are booleans
  println(isLate, isTired) // to print multiple values with one println
  //we can use .getClass to see the data type of the object
  println(myName.getClass, myNumber.getClass, myPi.getClass, isLate.getClass)



}
