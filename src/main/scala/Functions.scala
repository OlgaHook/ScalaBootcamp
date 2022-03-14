import MyUtil.myRound

object Functions extends App {
  object Day6Functions extends App {
    println("Let's go eat something!")

    //  println("Let's eat potatoes!")
    //  println("Let's eat potatoes!")
    //  println("Let's eat potatoes!")
    //
    //  for (_ <- 0 until 3) println("Eating tons of potatoes")
    //
    //  for (_ <- 1 to 3) {
    //    println("Let's sit down at a table")
    //    println("Pick up our utensils")
    //    println("Let's eat potatoes")
    //  }

    //so function encapsulates our work - it hides the comlexity of this unit of work inside the function
    //technically function defined inside an object is a method - so often the concepts of methods and functions is interchangable
    def sitDown(): Unit = {
      println("Checking chairs")
      println("Sitting down at a table")
    }

    def eat(): Unit = {
      //    println("Let's sit down at a table")
      sitDown()
      println("Pick up our utensils")
      println("Let's eat potatoes")
      println("Ask for a drink")
    }
    //
    //  eat() //this actually calls the function
    //  println("I do lots of other things")
    //  println("Then I remember that I need to eat again")
    //  eat //in Scala if function does not take any parameters we can skip parenthesis
    //
    //  for (_ <- 0 until 4) eat
    //Good Scala style is often describe as objects(and classes) outside - functional style inside

    //Platonic idea is that our function do one coherent thing
    //as soon as we need to do more than 1 unrelated item, we break it down into a different function

    //a good function name also servers as a form of documentation

    //we can pass arguments/parameters to our functions
    //in Scala we need to define what data type of parameters we can pass
    def orderFood(dish: String, waiterName: String): Unit = {
      println(s"$waiterName, I would like to order $dish")
      println(s"${dish.capitalize} is one of my favorites")
      println(s"Thank You $waiterName")
    }

    orderFood("ice cream", "Woldemars") //IntelliJ tells me what parameter my argument is going to be assigned to
    orderFood(dish = "beet soup", "Alice") //this is the full syntax but for a single argument not needed
    orderFood("mashed potatoes", waiterName = "Arnolds")

    //explicitly writing out our parameters will be important when we want to mix the order, or skip some of them(via defaults)

    //we can make a function in a one line if it is simple enough
    def printAdd(a: Int, b: Int): Unit = println(s"Result of $a+$b=${a + b}")

    printAdd(3, 5)
    printAdd(13, -25)

    val a = 500 //this is global to my object and does not conflict with the function parameters a and b

    //how about actually getting something useful out of a function for later use
    def add(a: Int, b: Int) = {
      //these a and b are local to the function and do not interefere with the other a and b from printAdd(which also has local versions)
      //i could println something here but It is not required
      a + b //in Scala I do not need to type unlike most languages // the last which provides a value gives return automatically
    }

    //so now we gain ability to use this add function's results
    val c = add(10, 50)
    println(s"result is $c")

    def multi(a: Int, b: Int) = a * b //very short way of defining a function again

    val result = multi(add(2, 3), add(5, 10)) //so left add will be called first, then right add then results given to multi
    //this works because we have return values in these functions
    println(s"so (2+3)*(5*10) = $result")

    // so again using val makes things constant , easier to reason about the code
    //again if you really need to use var, but if you can use val then that is preferred
    println(multi(add(2, 3), add(5, 10)))
    //we could give result of println to val/var but it would be unit
    val printResult: Unit = println(multi(add(2, 3), add(5, 10)))
    println(printResult)

    //default Values for functions can shorten code
    //idea is to have SANE defaults but allow modifications
    def greetWaiter(name: String = "Joe", isYelling: Boolean = false): Unit = {
      val greeting = s"Hello there $name" //local value for the greetWaiter function
      if (isYelling) {
        println(greeting.toUpperCase)
      } else {
        println(greeting)
      }
      //this greeting will be destroyed once our function is done for that time
    }

    greetWaiter() //so if I write nothing then Joe will be used
    greetWaiter("Bob")
    greetWaiter("Carol")
    greetWaiter("Dave", isYelling = true) //when using boolean arguments it is suggested to use full syntax
    //otherwise with many booleans it can be hard to figure out which one is which


    //full syntax would work
    println(MyUtil.myRound(3.1415926)) //technically this is what we wanted because default is 0 precision after comma
    //more convenient to import this functionality from the other object (just like we did with readLine etc)

    println(myRound(3.1415926, 2))
    println(myRound(3.1415926, 4))
    println(myRound(3.1415926, 5))

  }
}


