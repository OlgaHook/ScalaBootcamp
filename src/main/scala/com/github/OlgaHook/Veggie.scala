package com.github.OlgaHook

//remember in case class category:String is same as writing val category: String in a regular class
case class Veggie(category: String,item:String ,variety: String,date:String,price:Double,unit:String){
  val year = date.split("-").head.toInt //of course we could add some error checking as well
}
