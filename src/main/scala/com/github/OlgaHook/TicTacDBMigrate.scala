package com.github.OlgaHook

import com.github.OlgaHook.Day28DatabaseMigrat.db

object TicTacDBMigrate extends App {
  val db = new TicTacToeClass("src/resources/tictac/tictactoe.db")

  db.migrate()
}
