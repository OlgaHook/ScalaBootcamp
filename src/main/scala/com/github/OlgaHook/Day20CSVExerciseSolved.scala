package com.github.OlgaHook

object Day20CSVExerciseSolved extends App{
  val src = "src/resources/csv/fruitvegprices-19apr22.csv"
  val lines = MyUtil.getLinesFromFile(src)

  val splitLines = for (line <- lines) yield line.split(",")

  def arrayToVeggie(arr:Array[String]):Veggie = {
    Veggie(arr(0), arr(1), arr(2), arr(3),arr(4).toDouble, arr(5))
  }

  val veggies = splitLines.tail.map(arrayToVeggie)

  val expensiveApples = veggies.filter(_.item == "apples").sortBy(_.price).reverse
  println(s"Top 5 the most expensive apple entries: \n")
  expensiveApples.take(5).foreach(println)

  val cheapApples = veggies.filter(_.item == "apples").sortBy(_.price)
  println(s"Top 5 the least expensive apple entries: \n")
  cheapApples.take(5).foreach(println)

  val lettuce = veggies.filter(_.item == "lettuce")
  val averagePriceOfLettuce = ((lettuce.map(_.price).sum) / lettuce.length)
  val lettucePriceRounded = MyUtil.myRound(averagePriceOfLettuce, 2)
  println(s"Average price for lettuce $lettucePriceRounded")

  println("\n")

  //TODO get average price for lettuce
  val lettuceEntries = veggies.filter(_.item == "lettuce")
  val lettuceUnits = lettuceEntries.map(_.unit)
  lettuceUnits.distinct.foreach(println)

  val lettuceHead = lettuceEntries.filter(_.unit == "head")
  val lettuceHeadPrices = lettuceHead.map(_.price)
  println(lettuceHeadPrices.mkString(" "))

  val lettuceHeadAveragePrice = lettuceHeadPrices.sum/lettuceHead.length
  val roundedAverageHead = MyUtil.myRound(lettuceHeadAveragePrice, 2)
  println(roundedAverageHead)

  val lettuceTwin = lettuceEntries.filter(_.unit == "twin")
  val lettuceTwinPrices = lettuceTwin.map(_.price)
  println(lettuceTwinPrices.mkString(" "))

  val lettuceTwinAveragePrice = lettuceTwinPrices.sum/lettuceTwin.length
  val roundedAverageTwin = MyUtil.myRound(lettuceTwinAveragePrice,2)
  println(roundedAverageTwin)

  val cherrytomatoes2021 = veggies.filter(_.variety == "cherry").filter(_.date.contains("2021"))
  val cherrytomatoes2021prices = cherrytomatoes2021.map(_.price)
  //cherrytomatoes2022.take(10).foreach(println)
  println(s"Max cherry tomatoes price in 2021 is ${cherrytomatoes2021.map(_.price).max} ")
  println(s"Min cherry tomatoes price in 2021 is ${cherrytomatoes2021.map(_.price).min}")
  val cherrytomatoes2022mean = MyUtil.myRound(cherrytomatoes2021.map(_.price).sum/cherrytomatoes2021.map(_.price).length,2)
  println(s"Average(mean) cherry tomatoes price in 2021 is $cherrytomatoes2022mean")

  def getAverage(veggies: Array[Veggie], item: String="", year: Int=0, precision:Int=2):Double = {
    //    val filteredItems = veggies.filter(_.variety == item).filter(_.date.contains(year.toString)) //before we had year value
    val filteredItems = if (item != "" && year != 0) veggies.filter(_.item == item).filter(_.year == year) else veggies
    MyUtil.myRound(filteredItems.map(_.price).sum/filteredItems.length,precision)
  }

  val minDate = veggies.map(_.date).min
  val maxDate = veggies.map(_.date).max

  println(s"Data coverage starts at $minDate and ends in $maxDate")

  val minYear = veggies.map(_.year).min
  val maxYear = veggies.map(_.year).max

  println(s"Data coverage starts at $minYear and ends in $maxYear")

  val lettuceAverages = (for (year <- minYear to maxYear) yield {
    val avg = getAverage(veggies, "lettuce", year)
    println(s"Average for year: $year is $avg") //a side effect while we are making an array, generally we avoid sideeffects
    avg
  }
    ).toArray


  val strawberries22 = getAverage(veggies, "strawberries", 2022)
  println(strawberries22)

  println(getAverage(veggies, "lettuce", 2021))
  println(getAverage(veggies, "cucumbers", 2021))


  val lettuceGroupedByYear = veggies.filter(_.item == "lettuce").groupBy(_.year)

  for ((key,value) <- lettuceGroupedByYear) {
    println(s"For year $key the lettuce average is ${getAverage(value)}")
  }



}
