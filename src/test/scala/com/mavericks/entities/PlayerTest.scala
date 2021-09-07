package com.mavericks.entities

import org.scalatest.{Matchers, WordSpec}

class PlayerTest extends WordSpec with Matchers {
  "Players#printWinner" should {
    List(
      (Scissor(), Scissor(), None, "game is tie"),
      (Scissor(), Rock(), Some("Player-2 wins as 'rock crushed scissor'"), "player-2 wins"),
      (Scissor(), Paper(), Some("Player-1 wins as 'scissor cut paper'"), "player-1 wins"),
      (Rock(), Scissor(), Some("Player-1 wins as 'rock crushed scissor'"), "player-1 wins"),
      (Rock(), Paper(), Some("Player-2 wins as 'papper covered rock'"), "player-2 wins"),
      (Rock(), Rock(), None, "game is tie"),
      (Paper(), Rock(), Some("Player-1 wins as 'papper covered rock'"), "player-1 wins"),
      (Paper(), Scissor(), Some("Player-2 wins as 'scissor cut paper'"), "player-2 wins"),
      (Paper(), Paper(), None, "game is tie")
    ).foreach{ case (choice1, choice2, result, message) =>
      s"$message as player-1 picks $choice1, player-2 picks $choice2" in {
        val p1 = Player(choice1)
        val p2 = Player(choice2)
        p1.printWinner(p2) shouldBe result
      }
    }
  }
}
