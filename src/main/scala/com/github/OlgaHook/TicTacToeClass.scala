package com.github.OlgaHook


import java.sql.{DriverManager, PreparedStatement}


class TicTacToeClass (val dbPath: String){
  val url =  s"jdbc:sqlite:$dbPath"

  val conn = DriverManager.getConnection(url)

  def migrate():Unit = {
    //https://www.sqlitetutorial.net/sqlite-create-table/
    //so when we do insert we will reference the users table in our results table

    val statement = conn.createStatement() //we create a statement object that will handl sending SQL statements to the DB

    //this query should do nothing if table already exists
    val sql0 =
    """
      |CREATE TABLE IF NOT EXISTS results (
      |id INTEGER PRIMARY KEY,
      |human TEXT NOT NULL,
      |cpu TEXT NOT NULL,
      |draw TEXT NOT NULL,
      |created TEXT
      |);
      |""".stripMargin

    statement.addBatch(sql0)

    statement.executeBatch()

  }
//  def insertResult(winner:String,loser:String):Unit = {
//    //we want to avoid inserting unprepared values
//    //https://xkcd.com/327/
//
//    //https://alvinalexander.com/source-code/scala-jdbc-sql-select-insert-statement-resultset-preparedstatement-example/
//
//    val insertSql = """
//                      |INSERT INTO results (winner,loser,created)
//                      |values (?,?,CURRENT_TIMESTAMP)
//""".stripMargin
//    //CURRENT_TIMESTAMP is in SQL standard: https://stackoverflow.com/questions/15473325/inserting-current-date-and-time-in-sqlite-database
//
//    val player1 = playerWon
//    val player2 = cpuWon
//    val preparedStmt: PreparedStatement = conn.prepareStatement(insertSql)
//
//
//    preparedStmt.setInt (1, player1)
//    preparedStmt.setInt (2, player2)
//    preparedStmt.execute
//
//    preparedStmt.close()
//  }
//
//
//  def saveGameResult(dst:String, player1:String, player2:String) = {
//    if (!Files.exists(Paths.get(dst))) {
//      println("Saving header since no file exists")
//      val header = "winner, loser, date" //we do not add \n since append will add \n
//      MyUtil.saveText(dst, header)
//    } else {
//      println(s"Need to save winner $player1 and loser $player2")
//      //TODO save above and also with the date
//      //https://alvinalexander.com/scala/scala-get-current-date-time-hour-calendar-example/
//      val now = Calendar.getInstance().getTime()
//      println(s"Today is $now")
//      val utcNow = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT)
//      //      println(LocalDateTime.now().format( DateTimeFormatter.ISO_INSTANT ))
//      //TODO get local time in ISO 8601 format
//      val row = s"$player1, $player2, $utcNow"
//      MyUtil.saveText(dst, row, true) //crucial that we use append flag so we do not accidentally overwrite..
//      //TODO explore logging solutions such as infamous log4j which make saving similar date more structured
//    }
  //}
}
