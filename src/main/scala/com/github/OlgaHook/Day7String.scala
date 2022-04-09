package com.github.OlgaHook

object Day7String extends App {
  println("Let's have some string fun! \uD83D\uDE01") //the smiley is encoded Unicode from https://unicode.org/emoji/charts/full-emoji-list.html

  //  val food = "kartupelis" // potato in Latvian
  val food = "potatoes" //

  //so string is a sequence of charactes

  println(food.charAt(0))
  println(food(0))
  val firstChar = food.charAt(0)
  val alsoFirstChar = food(0) //so shorter way of the above // this is what I use

  val alphabet = "abcdefghijklmnopqrstuvwxyz"

  println(food.substring(2))
  println(alphabet.substring(2)) //again indexing starts at 0, so 2 means 3rd character

  println(s"Length of $alphabet is ${alphabet.length}")

  println(alphabet(25))
  //if we do not know the last character's index
  //we could check by length
  println(alphabet(alphabet.length - 1)) //so would work for any string
  //in scal wa we have an easier way to get first and last
  println(alphabet.head)
  println(alphabet.tail) //everything but last
  println(alphabet.last) //just the last

  val firstCharAlso = alphabet.head //so same as alphabet(0) or even alphabet.charAt(0)
  val secondChar = alphabet(1)
  println(firstCharAlso, secondChar)

  println(s"$firstCharAlso has ASCII code ${firstCharAlso.toInt}")

  println(food.toUpperCase)

  val name = "Māra"
  println(s"Second char of $name is ${name(1)} with unicode of ${name(1).toInt}")

  val smiley = "😁" //remember even a single char in "" will be a string
  //  val alsoSmiley:Char = '😁' no space in char for extra
  val latvianLetter = "ā" //so this asks for an deeper investigation but looks char holds extra letters
  //but does not hold the full Emoji list
  println(smiley, smiley(0).toInt)
  println(smiley, smiley(1).toInt)
  println(smiley(0), smiley(1)) //actually does not print anything useful

  println(latvianLetter(0))
  //  println(latvianLetter(1)) //this should be an exception for normal characters because well our string only has one character

  val greeting = "welcome to Riga"
  println(greeting.toLowerCase)
  println(greeting.capitalize) //so Scala capitalize adds capital to letter to first char but keeps everything else the same
  //there is no title method but we can make our own
  println(s"$alphabet starts with abc", alphabet.startsWith("abc"))
  println(s"$alphabet ends with xyz", alphabet.endsWith("xyz"))

  val drink = "coffee with milk and cinnamon"
  println("is there milk in my coffee?", drink.contains("milk"))

  //there are more powerful ways to check for partial matches using regular expressions but that is for later

  //strings are immutable so if we need to change something we need to make a new string

  val newDrink = drink.replace("coffee", "tea")
  println(newDrink)
  println(newDrink.capitalize)
  val sillyDrink = drink.replace("i", "y") //so mass replace of ALL matches
  println(sillyDrink)

  val dirtyString = "  Riga is a port city   "
  println(dirtyString)
  println(dirtyString.trim) //will trim all whitespace from BOTH sides
  println(dirtyString.trim.toUpperCase.tail.tail.tail) //we can chain those methods which return another string
  //of course taking three tails might not be very efficient we could achieve something similar with substring methods
  println(dirtyString.trim.toUpperCase.substring(3))

  println(alphabet.substring(3, 8)) //so substring excludes the last index 8 (which would have been the 9th character
  val numbers = "0123456789"
  println(numbers.substring(3, 8))
  println(numbers.subSequence(3, 8)) //so by documentation it behaves exactly like substring(3,8)

  println(numbers == "0123456789") //checking for equivalence
  println(numbers.indexOf("456")) //it should return 4
  println(alphabet.indexOf("cdef")) //it should return 2 since c is at index 2(3rd element
  println(alphabet.indexOf("notsuchstring")) //so for non existant substrings we get -1 in return

  val myName = "Valdis"

  for (c <- myName) {
    println(s"Current char is $c")
  }

  for ((c, i) <- myName.zipWithIndex) { //instead of c and i I could have used any names
    println(s"Current char is $c at index $i")
  }

  //so for new strings I advice using our string interpolation with s"" syntax
  val domicile = s"$myName lives in ${dirtyString.trim.substring(0, 4)}, that's right"
  //of course we could have done the cleanup first with trim and substring and saved results in a new val
  println(domicile)

  //you can also use + to concatenate strings
  val newString = myName + " likes " + food
  println(newString)

  //to cover when we learn about sequence is how to split a string and join a string
}
