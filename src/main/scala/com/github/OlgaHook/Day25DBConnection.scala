package com.github.OlgaHook

case class Genre(genreID: Int, Name:String)

import java.sql.DriverManager
import scala.collection.mutable.ArrayBuffer

object Day25DBConnection extends App{
  println("Testing Database connection")

  val dbPath = "src/resources/db/chinook.db"
  val url =  s"jdbc:sqlite:$dbPath"

  println(s"Will connect SQlite database at the following url:  $url")

  val conn = DriverManager.getConnection(url) //TODO handle exceptions at connection time

  //https://docs.scala-lang.org/overviews/scala-book/try-catch-finally.html
  //Alvin has a nice example on how to connect to MySQL - different database but very similar
  //https://alvinalexander.com/scala/scala-jdbc-connection-mysql-sql-select-example/

  println(conn.getClientInfo())

  val statement = conn.createStatement() //we create a statement object that will handl sending SQL statements to the DB

  val sql =
    """
      |SELECT * FROM genres;
      |""".stripMargin

  //  val sql =
  //    """
  //      |SELECT * FROM tracks
  //      |LIMIT 20;
  //      |""".stripMargin

  //  val sql =
  //    """
  //      |SELECT * FROM artists
  //      |JOIN albums
  //      |ON artists.ArtistId = albums.ArtistId;
  //      |""".stripMargin

  val resultSet = statement.executeQuery(sql)
  val metaData = resultSet.getMetaData
  println(s"We have received ${metaData.getColumnCount} columns")
  //so column indexes start at 1 not the usual 0
  for (i <- 1 to metaData.getColumnCount) {
    println(s"Column $i is named: ${metaData.getColumnName(i)}")
    println(s"Column $i comes from table: ${metaData.getTableName(i)}") //this would be important if we are using joins
  }

  val genreBuffer = ArrayBuffer[Genre]() //so we start with an empty buffer to store our rows

  while (resultSet.next()) {
    //so we loop over all rows until results are exhausted
    println(resultSet.getInt(1), resultSet.getString(2)) //first col is generally Primary Key
    //    println(resultSet.getInt("GenreId"), resultSet.getString("Name")) //if we know column names
    //we could loop over all columns as well for that row
    for (i <- 1 to metaData.getColumnCount) {
      print(resultSet.getString(i) + " ") //so getString works even on Integers
    }
    val genre = Genre(resultSet.getInt("genreId"), resultSet.getString("Name"))
    genreBuffer += genre
    // genreBuffer.append(genre) //same as previous line
    println()
  }
  //here our result set is exhausted //there might be  a command to reset
  //you would make a new query

  conn.close()

  val genreCollection = genreBuffer.toArray
  genreCollection.take(5).foreach(println)
  //generally you do want to close the database connection
  //it would close here anyways but still safer to explicitly close it when you do not need the connection anymore


  //TODO Create Album Case Class with appropriate data types for each field
  //TODO connect to chinook and extract into Array of Album (using ArrayBuffer to build it up)

  //TODO Create Track Case Class
  //TODO connect to database and extract into Array of Tracks -

  //Extra Challenge
  //TODO save all Tracks into CSV - in src/resources/csv/tracks.csv -
  // results should be very similar or identical to what you get in DBeaver export CSV - tracks_exported.csv
  //Check Day 20 examples on how we did this
}
