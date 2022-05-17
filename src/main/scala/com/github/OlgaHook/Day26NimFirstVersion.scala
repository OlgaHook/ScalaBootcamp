package com.github.OlgaHook

import scala.io.StdIn.readLine

object Day26NimFirstVersion extends App{

  val startingCount = 21
  val gameEndCondition = 0
  val minMove = 1
  val maxMove = 3
  val playerA = readLine("Player A what is your name?")
  var playerB = readLine("Player B what is your name?")

  println(s"Player A -  $playerA and Player B - $playerB let us play NIM!")

  var currentState = startingCount
  var isPlayerATurn = true //so A goes first

  while (currentState > gameEndCondition){
    val currentPlayer = if (isPlayerATurn) playerA else playerB

    println (s"Currently there are $currentState matches on the table")
    val move = readLine(s"How many matched do you want to take $currentPlayer? (1-3)").toInt

    currentState -= move
    isPlayerATurn = !isPlayerATurn //to change a boolean to reverse version of present

    val winner = if(isPlayerATurn) playerA else playerB
    val loser = if(!isPlayerATurn) playerA else playerB
    println(s"Game ended. Congratulations $winner! Better luck next time $loser" )
  }
}
