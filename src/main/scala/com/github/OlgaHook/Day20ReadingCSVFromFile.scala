package com.github.OlgaHook

object Day20ReadingCSVFromFile extends App{
  val src = "src/resources/csv/fruitvegprices-19apr22.csv" //TODO list .csv files in folder

  val lines = MyUtil.getLinesFromFile(src)
  //println(lines.take(5).mkString("\n"))
  lines.take(5).foreach(println) //same as above

  //  val splitLines = lines.map(_.split(",")) //so each line is split by comma
  val splitLines = for (line <- lines) yield line.split(",") //same as above

  //  splitLines.take(5).foreach(println) //this will not look good
  splitLines.take(5).foreach(lineItems => println(lineItems.mkString(";"))) //so now we have a semiColon instead

  def arrayToVeggie(arr:Array[String]):Veggie = {
    //in real life scenarios we would want a library to handle bad cases
    //we would want to check if we have some bad data
    //    Veggie("","","","",0.0,"") //FIXME
    Veggie(arr(0), arr(1), arr(2), arr(3),arr(4).toDouble, arr(5))
  }

  val lastItem = arrayToVeggie(splitLines.last)
  println(lastItem)

  //we use tail (everything but first line) to skip header

  //  val veggies = splitLines.tail.map(line => arrayToVeggie(line))
  //  val veggies = splitLines.tail.map(arrayToVeggie(_))
  val veggies = splitLines.tail.map(arrayToVeggie) //so same as above two lines

  veggies.take(5).foreach(println)

  val prices = veggies.map(_.price)
  println(s"Max price is ${prices.max}")

  val maxPriceItems = veggies.filter(_.price == prices.max)
  maxPriceItems.take(5).foreach(println)

  val expensiveItems = veggies.filter(_.price >= prices.max - 1.60) //1.60 should really be a val constant
  expensiveItems.take(5).foreach(println) //questions now arise whether these expensive items were on the list before

  val sortedVeggies = veggies.sortBy(_.price)
  sortedVeggies.take(10).foreach(println) //so it was sorted ascending so we get the cheap flowers here

  sortedVeggies.reverse.take(10).foreach(println) //our top ten most expensive items

}
