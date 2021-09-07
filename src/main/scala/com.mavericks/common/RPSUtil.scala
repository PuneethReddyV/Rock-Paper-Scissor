package com.mavericks.common

import scala.io.StdIn._
import scala.util.{Success, Try}
import com.mavericks.entities.RpsChoice

object RPSUtil {

  val GAME_TYPES_MESSAGE = "(1) - Player vs Computer.\n(2) - Computer vs Computer."
  val GAME_ELEMENTS_MESSAGE = "(1) - Rock\n(2) - Paper\n(3) - Scissor"

  /**
   * read input from user until read element is present in `validChoices`.
   * @param inputMessge message to show on command line when a invalid input is send
   * @param validChoices list of choices which are valid
   * @param f function that takes input
   * @tparam T Generic type
   * @return returns T type.
   */
  def readIntChoice[T](inputMessge: String = "", validChoices: List[T])(f: => T): T = {
    Try(f) match {
      case Success(value) if validChoices.contains(value) => value
      case _ =>
        println(s"Invalid entry, valid choices are ${validChoices.mkString("[", ", ", "]")}. \n$inputMessge")
        readIntChoice(inputMessge,validChoices)(f)
    }
  }
}


