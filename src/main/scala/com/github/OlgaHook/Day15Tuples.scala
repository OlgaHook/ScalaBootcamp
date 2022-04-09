package com.github.OlgaHook

object Day15Tuples extends App {
  println("Let's make some tuples!")
  //Tuples in programming are used to pass along heterogeneous values (different types)
  //Sequence types are used for homogeneous values (same data type)

  //https://docs.scala-lang.org/tour/tuples.html

  //so we use regular parenthesis to pack items into a tuple
  val myTuple = ("Valdis", 180, 3.14, "RTU")

  println(myTuple)
  //so individual values have a funky index
  println(myTuple._1) //so special values for accessing individual members inside
  println(myTuple._3)

  //Tuples go up to size 22, if you need to store more than 22 items well then you need a different (Map, Set, Seq or some time)

  //unpacking tuples
  val (name, height, pi, university) = myTuple
  println(name)
  println(height)
  println(pi)
  println(university)

  //how about looping ?
  // for (it <- myTuple) {
  //   println(it)
  // }
  //  val myArray = List(myTuple)
  //
  //https://stackoverflow.com/questions/54701769/convert-tuple-to-array-in-scala

  val myArray = myTuple.productIterator.toArray
  //so Array of Any is pretty useless we can print it but that's about it
  for (it <- myArray) println(it)

  //we could cast each member to string
  val stringArray = myArray.map(_.toString)
  for (it <- stringArray) println(it)

  //Users may sometimes find it hard to choose between tuples and case classes. Case classes have named elements. The names can improve the readability of some kinds of code

}
