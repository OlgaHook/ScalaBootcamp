import scala.io.StdIn.readLine

object SequencesCubesExcercise extends App {


    //  val startingNumber = readLine("Enter the starting number, please \n").toInt
    //  val endingNumber = readLine("Enter the ending number, please \n").toInt

    //  if (startingNumber > endingNumber) println("The starting number should be less than the ending number")
    //  else {
    //    val cubes = for (number <- startingNumber to endingNumber) yield Math.pow(number, 3).toInt
    //    println(s"The cubes are: $cubes")
    //    val oddCubes = for (number <- cubes if number % 2==1) yield number
    //    println(s"Odd cubes $oddCubes")
    //  }

    val startNumber = readLine("Enter starting number: ").toInt
    val endNumber = readLine("Enter ending number: ").toInt

    //  val cubeSequence = for (number <- startNumber to endNumber) yield Math.pow(number, 3).toInt
    ////  val cubeSequenceString = cubeSequence.mkString(", ")
    ////  println(s"The cubes of all numbers between $startNumber and $endNumber are: $cubeSequenceString")
    ////
    ////  val oddCubes = for (cube <- cubeSequence if cube % 2 != 0) yield cube
    ////  val oddCubesString = oddCubes.mkString(", ")
    ////  println(s"Among them, the odd cubes: $oddCubesString")

    //mutable buffer version
    val numbers = startNumber to endNumber
    val cubeSequence = scala.collection.mutable.ArrayBuffer[Int]()
    for (n <- startNumber to endNumber){
      val cube = n*n*n
      cubeSequence += cube //we append a cube value to the end of our buffer
    }
    println(cubeSequence)
    val oddCubes = for (cubeSequence <- cubeSequence if cubeSequence % 2 == 0) yield cubeSequence
    println(oddCubes)
  }

