import scala.util.Random

object Day8StringSplitting extends App {

  println("Let's split some strings!")
  val greeting = "Welcome to Riga which is a port city. Klaipeda is also a port city."
  val food = "potatoes"
  val foodSeq = food.toCharArray
  println(foodSeq.mkString(","))
  println(food(3), foodSeq(3)) //4th letter in both cases

  val words = greeting.split(" ")  //so we we say split our string by space
  println(words.mkString(","))
  val newGreeting = words.mkString(",")
  //we create a new sequence of word lengths
  val wordLengths = for (word <- words) yield word.length
  wordLengths.foreach(println) //so we say for each item in my sequence print it
  for ((word, wordLength) <- words zip wordLengths) { //with zip we can go through 2 sequences at once
    println(s"Word $word is $wordLength characters long") //of course here I could have calculated the length onthe spot with word.length
  }

  val totalCharacters = wordLengths.sum //so sum will work on numeric sequences
  val wordCount = words.length //pretty much any sequence
  val averageCharacters = MyUtil.myRound(totalCharacters.toDouble / wordCount, precision = 4)
  println(s"My sentence of $wordCount words has $totalCharacters for average character count of $averageCharacters")

  println(words.count(item => item.equals("port"))) //so we check each item in our sequence for or predicate
  //predicate comes from logic and is a statement returning Boolean true or false
  println(words.contains("Riga"))
  println(words.indexOf("Klaipeda"))
  val kIndex = words.indexOf("Klaipeda")
  println(s"Indeed we have ${words(kIndex)} as our other city")
  println(words.indexOf("Tallinn"))
  //so we would need to use an if statment to check for -1 before we acess this index
  //since -1 will throw index error

  println(words.mkString(" "))
  val uniqueWords = words.distinct // no dublicates, so port and city. should be dropped
  println(uniqueWords.mkString(" "))

  //  val numberOfThrows = 100_000 //by law of large numbers the more throws we use the closer to theoretical average we will get
  val numberOfThrows = 100 //by law of large numbers the more throws we use the closer to theoretical average we will get
  //so _ indicates we do not care about our loop iteratore variable, we simply want some number of Throws
  val diceThrows = for (_ <- 1 to numberOfThrows) yield Random.nextInt(6)+1 //+1 because we start at 0 and 6 is not included
  println(diceThrows.take(10).mkString(","))
  val averageThrow = diceThrows.sum / diceThrows.length.toDouble
  println(s"Average dice throw is $averageThrow")
  println(diceThrows.distinct.mkString(",")) //so we only have 6 distinct values in our diceThrows
  println(s"Max throw is ${diceThrows.max}, and min throw is ${diceThrows.min}")

  val sortedThrows = diceThrows.sorted //again we are sorting and returning a new sequence
  println(sortedThrows.mkString(",")) //not shockingly we will start with 1 and end with 6
  val reversedSort = diceThrows.sorted.reverse //there is also way to sort in reverse
  println(reversedSort.mkString(","))

}
