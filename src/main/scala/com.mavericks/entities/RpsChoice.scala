package com.mavericks.entities

import com.mavericks.common.InputChoiceWrapper
import com.mavericks.common.RPSUtil._

import scala.io.StdIn.readInt
import scala.util.Random

sealed trait RpsChoice {}

case class Rock() extends RpsChoice
case class Paper() extends RpsChoice
case class Scissor() extends RpsChoice

object RpsChoice {

  /**
   *
   * @param choice choice picked by user
   * @return string phrase for the winner
   */
  def getPhrase(choice: RpsChoice):String = choice match {
    case _: Rock    => "rock crushed scissor"
    case _: Paper   => "papper covered rock"
    case _: Scissor => "scissor cut paper"
  }

  /**
   *
   * @param index int value picked by user
   * @return RpsChoice type
   */
  def getRpsChoiceByIndex(index: Int): RpsChoice = index match {
    case 1 => Rock()
    case 2 => Paper()
    case 3 => Scissor()
    case _ => throw new IllegalArgumentException(s"$index is invalid input")
  }

  /**
   *
   * @param gameType type of game selected by user
   * @param result winner of the game is present or not
   * @param generateRandomChoice wrapper to take input from user
   * @return result of the game in string format
   */
  def declareWinner(gameType: Int, result: Option[String], generateRandomChoice: InputChoiceWrapper): String = {
    result match {
      case Some(winner) => winner
      case None =>
        val (player1, player2) = getPlayers(gameType, generateRandomChoice)
        declareWinner(gameType, player1.printWinner(player2), generateRandomChoice)
    }
  }

  /**
   *
   * @param input type of the game
   * @param generateRandomChoice  wrapper to take input from user
   * @return Players tupple
   */
  def getPlayers(input: Int, generateRandomChoice: InputChoiceWrapper): (Player, Player) = {
    if(input == 1) {
      println("Enter Player 1 choice:\n"+GAME_ELEMENTS_MESSAGE)
      (
        Player(getRpsChoiceByIndex(readIntChoice[Int](GAME_ELEMENTS_MESSAGE, List(1, 2, 3))(generateRandomChoice.readIntChoice()))),
        Player(getRpsChoiceByIndex(1 + generateRandomChoice.nextChoice(3)))
      )
    } else {
      (
        Player(getRpsChoiceByIndex(1 + generateRandomChoice.nextChoice(3))),
        Player(getRpsChoiceByIndex(1 + generateRandomChoice.nextChoice(3)))
      )
    }
  }

}