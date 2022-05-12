package com.github.OlgaHook

import java.sql.DriverManager
import scala.collection.mutable.ArrayBuffer


case class Album(AlbumId: Int, Title: String, ArtistId: Int)

case class Track(TrackId: Int, Name: String, AlbumId: Int,
                 MediaTypeId: Int, GenreId: Int, Composer: String,
                 Milliseconds: Int, Bytes: Int, UnitPrice: Double) {
  def toCSV():String = {
    val buf = TrackId.toString + "," +
      "\"" + Name + "\"" + "," +
      AlbumId.toString + "," +
      MediaTypeId.toString + "," +
      GenreId.toString + "," +
      "\"" + Composer + "\"" + "," +
      Milliseconds.toString + "," +
      Bytes.toString + "," +
      UnitPrice.toString

    buf
  }


}
object Day25TrackSavingExercise extends App{

  val dbPath = "src/resources/db/chinook.db"
  val url = s"jdbc:sqlite:$dbPath"
  val conn = DriverManager.getConnection(url)
  val statement = conn.createStatement()

  // ALBUMS

  val sql =
    """
      |SELECT * FROM albums
      |""".stripMargin

  val resultSet = statement.executeQuery(sql)
  val metaData = resultSet.getMetaData

  for (c <- 1 to metaData.getColumnCount) {
    println(metaData.getColumnName(c))
  }

  val albumBuffer = ArrayBuffer[Album]()

  while (resultSet.next()) {
    val album = Album(resultSet.getInt("AlbumId"), resultSet.getString("Title"),
      resultSet.getInt("ArtistId"))
    albumBuffer += album
  }

  val albumCollection = albumBuffer.toArray
  albumCollection.take(5).foreach(println)

  // TRACKS

  val sql2 =
    """
      |SELECT * FROM tracks
      |""".stripMargin

  val resultSet2 = statement.executeQuery(sql2)
  val metaData2 = resultSet2.getMetaData

  for (c <- 1 to metaData2.getColumnCount) {
    println(metaData2.getColumnName(c))
  }

  val trackBuffer = ArrayBuffer[Track]()

  while (resultSet2.next()) {
    val track = Track(resultSet2.getInt("TrackId"), resultSet2.getString("Name"),
      resultSet2.getInt("AlbumId"), resultSet2.getInt("MediaTypeId"),
      resultSet2.getInt("GenreId"), resultSet2.getString("Composer"),
      resultSet2.getInt("Milliseconds"), resultSet2.getInt("Bytes"),
      resultSet2.getDouble("UnitPrice"))

    trackBuffer += track
  }

  conn.close()

  val trackCollection = trackBuffer.toArray
  trackCollection.take(5).foreach(println)

  //  val trackCollectionStrings = trackCollection.mkString("\n")
  //  trackCollectionStrings.take(25).foreach(println)

  // SAVE AS CSV
  val dst = "src/resources/csv/tracks.csv"

  val trackLines1 = for (tr <- trackCollection) yield {
    tr.toCSV()
    //    tr.TrackId.toString + "," +
    //      tr.Name + "," +
    //      tr.AlbumId.toString + "," +
    //      tr.MediaTypeId.toString + "," +
    //      tr.GenreId.toString + "," +
    //      tr.Composer + "," +
    //      tr.Milliseconds.toString + "," +
    //      tr.Bytes.toString + "," +
    //      tr.UnitPrice.toString
  }
  trackLines1.take(5).foreach(println)
  //so header is a Array holding one string which we will append to the big array of strings
  val header: Array[String] = Array("TrackId,Name,AlbumId,MediaTypeId,GenreId,Composer,Milliseconds,Bytes,UnitPrice")
  val csvContent = header ++ trackLines1

  MyUtil.saveLines(dst, csvContent)


}
