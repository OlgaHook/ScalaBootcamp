package com.github.OlgaHook

object MyScalaBasic extends App {
  val x = 1 + 1
  //val x: Int = 1 + 1 //also OK
  //Using VAL Reassigment like x=3 is Not possible
  println(x) // 2
  println(x * x)

  var x1 = 1 + 1
  //var x1: Int = 1 + 1 //also OK
  x1 = 5
  println(x1)
  println(x1 * x1)


  //BLOCKS {}
  println({
    val x = 1 + 1
    x + 1
    x + 2
  }) // in the end 4

  //FUNCTIONS
  // NoName function or anonymous has no arguments
  (x: Int) => x + 1

  val addOne = (x: Int) => x + 1 //with name
  println(addOne(1)) // 2

  val add1 = (x: Int, y: Int) => x + y // multiple parameters x y
  println(add1(1, 2)) // 3

  val getTheAnswer = () => 42
  println(getTheAnswer()) // 42 // no parameters at all

  //Methods
  //Are very similar to functions
  //defined with the def
  //def is followed by a name, parameter list(s), a return type, and a body
  def add(x: Int, y: Int): Int = x + y

  println(add(1, 2)) // 3

  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier

  println(addThenMultiply(1, 2)(3)) // 9


}
