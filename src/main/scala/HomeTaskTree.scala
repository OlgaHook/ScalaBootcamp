import Day7String.food

import scala.io.StdIn.readLine

object HomeTaskTree extends App{

  //TODO ask person's name
  val name = readLine("Hi! What is your name?\n")
println(s"Nice to meet you $name!")
  //TODO ask for tree height
  val treeHight = readLine("Please, enter any tree height: \n").toInt

  //TODO print a xmas tree (or another tree) by calling printTree function with the correct parameters
  printTree1(name, treeHight)

  def printTree1(name:String, height:Int):Unit = {
    var emptySpace = 1
    var starSymbol = 1
for (n <- 1 to treeHight){
  emptySpace = treeHight - n
  starSymbol = n*2 - 1
  for (o <-1 to emptySpace){
    print(" ")
  }
  for (p <-1 to starSymbol){
    print("*")
  }
  println()
  //println(("*")*n)
  //println(("*")*(n*2-1))
}


  }

  //tree height should be the one assigned
  //simple version for height 3 would be
  //  *
  // ***
  //*****

 def printTree(name:String, height:Int, symbol:Char='*', maximumHeight:Int=40):Unit = {
    //for this exercise we are not going to adjust maximumHeight
    //TODO print the tree HINT: check the last entry in Day7Strings
  }
  //for full points I would like to see the following
  //if user enters name Valdis  and height 9
  //then we should print
  //        *
  //       VVV
  //      AAAAA
  //     LLLLLLL
  //    DDDDDDDDD
  //   IIIIIIIIIII
  //  SSSSSSSSSSSSS
  // VVVVVVVVVVVVVVV
  //AAAAAAAAAAAAAAAAA

  //let's consider maximum height 40 (so person's name letters could repeat many times)

  /*def printTree(name:String, height:Int, symbol:Char='*', maximumHeight:Int=40):Unit = {
    //for this exercise we are not going to adjust maximumHeight
    //TODO print the tree HINT: check the last entry in Day7Strings
  }

   */
}
