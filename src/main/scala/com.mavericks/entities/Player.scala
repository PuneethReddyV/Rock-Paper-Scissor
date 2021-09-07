package com.mavericks.entities

import com.mavericks.entities.RpsChoice.getPhrase

case class Player(choice: RpsChoice) {

  /**
   *
   * @param that other player type used for comparision
   * @return some winner when a valid winner present else none
   */
  def printWinner(that: Player): Option[String] = {
    (this.choice, that.choice) match {
      case (Rock(), Scissor()) | (Paper(), Rock()) | (Scissor(), Paper()) =>
        Some(s"Player-1 wins as '${getPhrase(this.choice)}'")
      case ( Scissor(), Rock()) | (Rock(), Paper()) | (Paper(), Scissor()) =>
        Some(s"Player-2 wins as '${getPhrase(that.choice)}'")
      case _ =>
        println(s"game is tied let us re-play to break the tie")
        None
    }
  }

}