package com.mavericks

import com.mavericks.common.InputChoiceWrapper
import common.RPSUtil._
import com.mavericks.entities.RpsChoice._

import scala.io.StdIn.{readInt, readLine}
import scala.util.Random

object RockPaperScissorApp extends App {
  startGame()
  println("Thank you, let us continue later.")

  def startGame(generateRandomChoice: InputChoiceWrapper = new InputChoiceWrapper()): Unit = {
    println("Choose your game by entering \n"+GAME_TYPES_MESSAGE)
    var gameType = readIntChoice[Int](GAME_TYPES_MESSAGE, List(1, 2))(generateRandomChoice.readIntChoice())
    val (player1, player2) = getPlayers(gameType, generateRandomChoice)
    println(declareWinner(gameType, player1.printWinner(player2), generateRandomChoice))
    println("\n*----------------------------------------------------------------*")
    println("|Type 'quit' to close this game -OR- press any key to continue...|")
    println("*----------------------------------------------------------------*")
    if(generateRandomChoice.readStringChoice().equalsIgnoreCase("quit")) {
      return
    }
    startGame(generateRandomChoice)
  }
}
