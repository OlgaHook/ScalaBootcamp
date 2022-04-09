package com.github.OlgaHook

import com.github.OlgaHook.MyUtil.printDeltaMs

import java.lang.System.nanoTime
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object Day9SeqSpeedTest extends App {

  println("Testing various sequences and looping constructions")
  val t0 = System.nanoTime() //so I get current time in nanoseconds (I believe it counts from January 1st 1970)
  val bigNumbers = (0 to 1_000_000).toArray
  val t1 = System.nanoTime()
  val delta = t1 - t0
  println(s"It took $delta nanoseconds to create 1 million and 1 number in increasing order")


  printDeltaMs(t0, t1)


  val t2 = System.nanoTime()
  val biggerNumbers = bigNumbers.map(_ + 100)
  val t3 = System.nanoTime()
  printDeltaMs(t2, t3, taskName = "add 100")

  //second task will be faster because it is already cached
  val t4 = System.nanoTime()
  val biggerNumbersYield = for (n <- bigNumbers) yield n + 100
  val t5 = System.nanoTime()
  printDeltaMs(t4, t5, "yield +100")

  val numberBuffer = ArrayBuffer[Int]()
  val t6 = System.nanoTime()
  for (n <- bigNumbers) numberBuffer += n + 100
  val t7 = System.nanoTime()
  printDeltaMs(t6, t7, "buffer add 100")
  //we still need to convert to regular sequence from buffer
  val t8 = System.nanoTime()
  val fromBuffer = numberBuffer.toSeq
  val t9 = System.nanoTime()
  printDeltaMs(t8, t9, "converting from buffer to seq")

  //conclusion from these tests is that caching in your CPU can make a difference
  //also CPU can make predictions on what the next operation will be

  //by now we probably wish we stored the timing values in a sequence or we could have
  //used var t0 and var t1 and keep using them over and over
  val numberCount = 1_000_000
  val maxNumber = numberCount * 10
  val t10 = nanoTime() // i got lazy and imported nanoTime()
  val random_numbers = for (_ <- 1 to numberCount) yield Random.nextInt(maxNumber)
  val t11 = nanoTime()
  printDeltaMs(t10, t11, "create random numbers")
  //so creating random numbers is about 8 times slower

  val randomAdd = Random.nextInt(100) //we will vary our adder a little bit
  val t12 = nanoTime()
  val randomAdditions = random_numbers.map(_ + randomAdd)
  val t13 = nanoTime()
  printDeltaMs(t12, t13, s"adding $randomAdd to random numbers")

  //TODO test yield and ArrayBuffer examples with random numbers

  //in real life our data is not completely random but also it not coming in nice ordered sequences either(not all the time)

}
