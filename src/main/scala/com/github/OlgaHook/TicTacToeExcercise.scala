package com.github.OlgaHook

//import com.github.OlgaHook.TicTacToeExcercise.allowedChars

import java.sql.DriverManager
import java.sql.PreparedStatement
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine
import scala.util.Random


class TicTacBoard() {
  // internal variables of the class
  var isGameActive: Boolean = true
  var myMultiArr = Array.ofDim[Char](3, 3)
  var columnChar: Char = _
  var lineChar: Char = _
  var columnCharString: String = ""
  var lineCharString: String = ""
  var allowedChars: String = " xo"

  // initialization / constructor of the class
  myMultiArr(0)(0) = allowedChars(0)
  myMultiArr(0)(1) = allowedChars(0)
  myMultiArr(0)(2) = allowedChars(0)
  myMultiArr(1)(0) = allowedChars(0)
  myMultiArr(1)(1) = allowedChars(0)
  myMultiArr(1)(2) = allowedChars(0)
  myMultiArr(2)(0) = allowedChars(0)
  myMultiArr(2)(1) = allowedChars(0)
  myMultiArr(2)(2) = allowedChars(0)

  // parse move in format "A1", "C2" etc into column/line integer position
  def getColumnFromMove(source: String): Int = {
    var columnDetermined: Int = 0
    columnChar = source.charAt(0)
    columnCharString = columnChar.toString
    columnCharString match {
      case "A" => columnDetermined = 0
      case "B" => columnDetermined = 1
      case "C" => columnDetermined = 2
      case _ => columnDetermined = 777 //this value means bad input
    }
    columnDetermined //  method returns the value
  }

  def getLineFromMove(source: String): Int = {
    var lineDetermined: Int = 0
    lineChar = source.charAt(1)
    lineCharString = lineChar.toString
    lineCharString match {
      case "1" => lineDetermined = 0
      case "2" => lineDetermined = 1
      case "3" => lineDetermined = 2
      case _ => lineDetermined = 777 //this value means bad input
    }
    lineDetermined //  method returns the value
  }

  def checkIfFull(noChar: Char): Boolean = {
    var detectedFull: Boolean = false
    if ( ( myMultiArr(0)(0) != noChar ) & ( myMultiArr(0)(1) != noChar ) & ( myMultiArr(0)(2) != noChar ) &
      ( myMultiArr(1)(0) != noChar ) & ( myMultiArr(1)(1) != noChar ) & ( myMultiArr(1)(2) != noChar ) &
      ( myMultiArr(2)(0) != noChar ) & ( myMultiArr(2)(1) != noChar ) & ( myMultiArr(2)(2) != noChar ) ) {
      isGameActive = false
      detectedFull = true
    }
    detectedFull //returns value
  }

  def checkWinner(myChar: Char): Boolean = {
    var detectedWin: Boolean = false

    if (((myMultiArr(0)(0) == myChar) & (myMultiArr(0)(1) == myChar) & (myMultiArr(0)(2) == myChar)) ||
      ((myMultiArr(1)(0) == myChar) & (myMultiArr(1)(1) == myChar) & (myMultiArr(1)(2) == myChar)) ||
      ((myMultiArr(2)(0) == myChar) & (myMultiArr(2)(1) == myChar) & (myMultiArr(2)(2) == myChar))) {
      isGameActive = false
      detectedWin = true
    }

    if (((myMultiArr(0)(0) == myChar) & (myMultiArr(1)(0) == myChar) & (myMultiArr(2)(0) == myChar)) ||
      ((myMultiArr(0)(1) == myChar) & (myMultiArr(1)(1) == myChar) & (myMultiArr(2)(1) == myChar)) ||
      ((myMultiArr(0)(2) == myChar) & (myMultiArr(1)(2) == myChar) & (myMultiArr(2)(2) == myChar))) {
      isGameActive = false
      detectedWin = true
    }

    if (((myMultiArr(0)(0) == myChar) & (myMultiArr(1)(1) == myChar) & (myMultiArr(2)(2) == myChar)) ||
      ((myMultiArr(0)(2) == myChar) & (myMultiArr(1)(1) == myChar) & (myMultiArr(2)(0) == myChar))) {
      isGameActive = false
      detectedWin = true
    }
    detectedWin //returns value
  }

}

class TicTacDB(val dbPath: String) {

  val url =  s"jdbc:sqlite:$dbPath"
  val conn = DriverManager.getConnection(url)

  def migrate():Unit = {

    val statement = conn.createStatement() //we create a statement object that will handl sending SQL statements to the DB

    //this query should do nothing if table already exists
    val sql0 =
    """
      |CREATE TABLE IF NOT EXISTS results (
      |id INTEGER PRIMARY KEY,
      |human INTEGER NOT NULL,
      |cpu INTEGER NOT NULL,
      |draw INTEGER NOT NULL,
      |created TEXT
      |);
      |""".stripMargin

    statement.addBatch(sql0)
    statement.executeBatch()
  }

  def insertResult(human:Boolean, cpu:Boolean, draw:Boolean):Unit = {
    //    //we want to avoid inserting unprepared values
    //    //https://xkcd.com/327/
    //
    //    //https://alvinalexander.com/source-code/scala-jdbc-sql-select-insert-statement-resultset-preparedstatement-example/
    //
    var humanInt:Int = 0
    var cpuInt:Int = 0
    var drawInt:Int = 0

    if ( human == true ) { humanInt = 1 }
    if ( cpu == true ) { cpuInt = 1 }
    if ( draw == true ) { drawInt = 1 }

    val insertSql = """
                      |INSERT INTO results (human,cpu,draw,created)
                      |values (?,?,?,CURRENT_TIMESTAMP)
                    """.stripMargin
//    //    //CURRENT_TIMESTAMP is in SQL standard: https://stackoverflow.com/questions/15473325/inserting-current-date-and-time-in-sqlite-database
//
    val preparedStmt: PreparedStatement = conn.prepareStatement(insertSql)

    preparedStmt.setInt (1, humanInt)
    preparedStmt.setInt (2, cpuInt)
    preparedStmt.setInt (3, drawInt)
    preparedStmt.execute

    preparedStmt.close()
  }

  def getStatistics():Array[Int] = {
    val sql =
      """
        |SELECT SUM(human) human, SUM(cpu) cpu, SUM(draw) draw FROM results
        |;
        |""".stripMargin

    val resultBuffer = ArrayBuffer[Int]() //so we start with an empty buffer to store our rows
    val statement = conn.createStatement()
    val rs = statement.executeQuery(sql)
    while (rs.next()) {
      val human = rs.getInt("human")
      resultBuffer += human
      val cpu = rs.getInt("cpu")
      resultBuffer += cpu
      val draw = rs.getInt("draw")
      resultBuffer += draw
    }
    resultBuffer.toArray //better to return immutable values
  }
}


object TicTacToeExcercise extends App {

  val game = new TicTacBoard()

  var randomWorked: Boolean = false
  var playerWorked: Boolean = false
  var column: Int = 0
  var line: Int = 0
  var cpuChar: Char =_ //allowedChars.charAt(2)
  var playerChar: Char =_ //allowedChars.charAt(1)
  var noChar: Char =_ //allowedChars.charAt(0)
  var cpuWon: Boolean = false
  var playerWon: Boolean = false
  var nobodyWon: Boolean = false

  cpuChar = game.allowedChars.charAt(2)
  playerChar = game.allowedChars.charAt(1)
  noChar = game.allowedChars.charAt(0)

  //  //main loop: while there are no win conditions detected - play on
  println("starting game")
  while (game.isGameActive) {

    //      clscr
    //      print("\u001b[2J")ww
    //      print("\u001b[2J\u001b[;H")
    // *******************************************
    //                  CPU part
    // *******************************************
    val random = new Random
    val possibleRepliesOfComputer = Seq("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3")

    // CPU move - it will try to randomly pick any tic tac board cell
    // if it is already occupied - it will repeat until the cell is found
    // so therefore we randomly pick inside a while loop
    randomWorked = false
    while (randomWorked == false) {

      val reply = possibleRepliesOfComputer(
        random.nextInt(possibleRepliesOfComputer.length)
      )

      column = game.getColumnFromMove(reply)
      line = game.getLineFromMove(reply)

      if (game.myMultiArr(line)(column) == noChar) {
        randomWorked = true
        game.myMultiArr(line)(column) = cpuChar
        println(s"Computer Move: $reply")
      }
    }

    // analysis of CPU move
    cpuWon = game.checkWinner(cpuChar)
    if (cpuWon == false) {
      game.checkIfFull(noChar)
    }

    // *******************************************
    //              visualisation
    // *******************************************

    println("  A B C")
    val firstLine = "1:" + game.myMultiArr(0)(0) + " " + game.myMultiArr(0)(1) + " " + game.myMultiArr(0)(2)
    val secndLine = "2:" + game.myMultiArr(1)(0) + " " + game.myMultiArr(1)(1) + " " + game.myMultiArr(1)(2)
    val thirdLine = "3:" + game.myMultiArr(2)(0) + " " + game.myMultiArr(2)(1) + " " + game.myMultiArr(2)(2)
    println(firstLine)
    println(secndLine)
    println(thirdLine)

    // *******************************************
    //            Human Player part
    // *******************************************
    // note: human part is executed only if the CPU has not yet won or the desk is not full!
    if ((cpuWon == false) & (nobodyWon == false)) {
      playerWorked = false
      while (playerWorked == false) {
        val currentMove = readLine("Your move (enter XX to quit): ")

        if (currentMove != "") {
          //
          if (currentMove != "XX") {
            column = game.getColumnFromMove(currentMove)
            line = game.getLineFromMove(currentMove)

            if ((column != 777) & (line != 777)) {
              if (game.myMultiArr(line)(column) != noChar) {
                println("The cell is already occupied!")
              }
              else {
                game.myMultiArr(line)(column) = playerChar
                playerWorked = true
              }
            }
            else {
              println("Illegal value!")
            }
          }
          else {
            println("Game session closed by Player")
            cpuWon = true
            game.isGameActive = false
            playerWorked = true
          }
        }
        else {
          println("Empty value entered!")
        }
      }

      // analysis of Player move
      playerWon = game.checkWinner(playerChar)
      if (playerWon == false) {
        nobodyWon = game.checkIfFull(noChar)
      }
    }
  }

  if (playerWon) {
    println("You won!")
  }
  if (cpuWon) {
    println("CPU won!")
  }
  if (nobodyWon) {
    println("A draw - desk is full!")
  }

  val gameDB = new TicTacDB("src/resources/tictac/tictactoe.db")

  gameDB.migrate()
  gameDB.insertResult(playerWon, cpuWon, nobodyWon)
  val statsArray = gameDB.getStatistics()
  val totalPlayerWins = statsArray(0)
  val totalCPUWins = statsArray(1)
  val totalNoWins = statsArray(2)

  println()
  println("Total statistics:")

  println(s"Player won: $totalPlayerWins")
  println(s"CPU won: $totalCPUWins")
  println(s"Draws: $totalNoWins")

}
