object Day8Sequences extends App{
  println("Need for sequences")
  //  val a1=3
  //  val a2=8
  //  val a3=13
  //the above would be silly way to store more than a couple related data items
  val mySeq = Seq(3,8,13) // by default we get an immutable sequence of integers(in this case)
  println(mySeq)
  //  val numbers = (1 to 20).toSeq //does not quite work because Range already is a Sequence
  val numbers = (1 to 20).toList //does not quite work because Range already is a Sequence
  println(numbers)
  println(numbers.getClass)
  println(numbers.head) //encouraged to use this instead of numbers(0)
  println(numbers.last)
  println(numbers(0)) //so Sequence indexing starts at 0, just like strings (which are a sequence after all
  println(numbers(1))
  println(numbers(19), numbers(numbers.length-1)) //easier to just write numbers.last wouldn't you agree?

  val numArray = numbers.toArray //just another type of Sequence
  println(numArray.getClass) //so an array of integers

  val againSequence = numArray.toSeq //we can go from Array to generic Sequence if we want
  println(againSequence)

  for (number <- numbers) {
    println(s"My lucky number is $number")
  }

  val evenNumbers = for (number <- numbers if number % 2 == 0) yield number //yield gets us a new sequence items one at a time
  println(evenNumbers)

  val oddNumbers = for (number <- numbers if number % 2 == 1) yield number
  println(oddNumbers)

  val manyNumbersThatDivideBy3 = for (num <- 0 to 100 if num % 3 == 0) yield num
  println(manyNumbersThatDivideBy3.slice(0,10)) //I do not want to print all of them

  //  val squares = for (number <- oddNumbers) yield Math.pow(number,2)
  val oddSquares = for (number <- oddNumbers) yield Math.pow(number,2).toInt //for squares I could have just used number*number
  println(oddSquares)

  //again we can keep reusing these local values such as number or whatever you want to call your loop iterators, i , n, num, number etc
  println(oddSquares(3))
  //  squares(3) = 9000 //immutable I cant change the value!
  //we can also have mutable versions of sequences - meaning we can replace the contents and change them.

  //  val mutableSquares = scala.collection.mutable.Seq(oddSquares) // will be a Seq of List of Integers not quite what we want
  val myMutableArray = scala.collection.mutable.ArraySeq(1,4,6,18,7,8)
  println(myMutableArray)
  myMutableArray(3) = 35 // i changed the contents of 4th item in my mutable Sequence
  println(myMutableArray) //we gain ability to change contents

  val myArrayBuffer = scala.collection.mutable.ArrayBuffer(5,2)
  println(myArrayBuffer)
  myArrayBuffer += 6
  println(myArrayBuffer)

  //here is an example how to create a blank mutable buffer for Integers
  val cleanSquareBuffer = scala.collection.mutable.ArrayBuffer[Int]() //this way Scala knows we will hold Integers here
  for (n <- 0 to 10) {
    val mySquare = n*n
    cleanSquareBuffer += mySquare
  }
  println(cleanSquareBuffer)
  //usually we will want to convert the buffer to something immutable at the end
  val immutableSquares = cleanSquareBuffer.toSeq
  println(immutableSquares)

  //our we can keep adding to our buffer
  for (n <- 100 to 310) {
    cleanSquareBuffer += n*n //so we are adding a new squareed value to our buffer
  }
  val newFixedSquares = cleanSquareBuffer.toSeq
  println(newFixedSquares)

  cleanSquareBuffer.clear() //this clears the buffer so we can reuse
  //again generelly we want to avoid using mutable structures unless it is hard to avoid them
  //so far these are immutable Sequences, just like our strings, we can not change them, we can make new ones
}
