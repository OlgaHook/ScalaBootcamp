object TypeCasting03mar extends App{
val a = 200
  val b = a.toByte //byte is not assigned and can hold only 256 different values
  println(a,b)
 // println(b.toInt) //by pressing dot(.) we can get a list what we can do with object
  //b.toItn - we had a loose of information

  val c = 127
  val d = 128
  val e = 129
  println(c,d,e)
  //bytes only goes up to 127 and then goes to -128 all around and around

  val face: Char = '☺' // in Scala ('')single quotes are for characters
  //to convert character to integer we can use different ways (below)
  val number: Int = face  // 9786
  //or
  val alsoNumber = face.toInt
  println(face, number, alsoNumber)
  //also we can convert back - number to character
  val faceAgain = number.toChar
  println(face, faceAgain)

  //https://docs.scala-lang.org/tour/unified-types.html

  // Basic data hierarchy in Scala = byte->short->Int->Long->Float->Double

  val bigNum: Long = 10_000_000_000L //neet to add L to say that a number is Long(64 bit Integer)
  val result = bigNum + number //Long + Int -> no problem
  println(result)

  val myPi = Math.PI // this is built in
  val ancientPi = myPi.toInt
  println(myPi, ancientPi)

  val myStringy = "34343434"
  val myNumber = myStringy.toInt
  println(myStringy, myNumber) //after printing those values looks the same, but difference is
  //that we can do Math with Int an String operations with String



}
