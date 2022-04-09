package com.github.OlgaHook

object Day16Testing extends App {
  println("Testing importing from packages")

  val anotherLaptop = Laptop("liga's laptop", 2.8, "Dell")
  //if you need to use different Laptop definition from different packages
  //then you can use them explicitly with full path
 // val alsoLaptop = com.github.OlgaHook("friends", 3.3, "Asus") //if we did not import it we need full name
  println(anotherLaptop)
}
