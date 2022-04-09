package com.github.OlgaHook

case class Laptop(name:String, speed:Double, manufacturer:String)

object Day16UsingPackages extends App {

    println("Testing running my code from package")
    val myLaptop = Laptop("val-wd", 4.5, "Lenovo")
    println(myLaptop)

}
