package com.mavericks.entities

import com.mavericks.RPSTestUtils
import com.mavericks.common.{InputChoiceWrapper, RPSUtil}
import org.scalatest.{Matchers, WordSpec}

import scala.util.Random


class RpsChoiceTest extends WordSpec with Matchers with RPSTestUtils {

  "RpsChoice#getPhrase" should {
    List(
      (Rock(), "rock crushed scissor"),
      (Scissor(), "scissor cut paper"),
      (Paper(), "papper covered rock")
    ).foreach{
      case (choice, result) => s"returns '$result' when choice is $choice" in {
        RpsChoice.getPhrase(choice) shouldBe result
      }
    }
  }
  "RpsChoice#getRpsChoiceByIndex" should {
    List((1, Rock()), (2, Paper()), (3, Scissor())).foreach{
      case (index, value) => {
        s"$index returns $value" in {
          RpsChoice.getRpsChoiceByIndex(index) shouldBe value
        }
      }
    }
    "throw exception for invalid entry(other than 1,2,3)" in {
      val thrown = intercept[IllegalArgumentException](RpsChoice.getRpsChoiceByIndex(4))
      thrown.getMessage shouldBe "4 is invalid input"
    }
  }

  "RpsChoice#declareWinner" should {
    "return existing winner" in {
      (mockGenerateRandomChoice.nextChoice _).expects(*).never()
      RpsChoice.declareWinner(1, Some("winner"), mockGenerateRandomChoice) shouldBe("winner")
    }
    "return winner when it is tie in round one" in {
      mockNextChoice(3, 1).once()
      mockReadIntChoice(1).once()
      RpsChoice.declareWinner(1, None, mockGenerateRandomChoice) shouldBe("Player-2 wins as 'papper covered rock'")
    }
  }

  "RpsChoice#getPlayers" should {

    "'player vs computer' type game should take VALID input from user" in {
      mockNextChoice(3, 1).once()
      mockReadIntChoice(1).once()
      val (player1, player2) = RpsChoice.getPlayers(1, mockGenerateRandomChoice)
      player1 shouldBe Player(Rock())
      player2 shouldBe Player(Paper())
    }

    "'computer vs computer' type game should not take any input from user" in {
      //given
      mockNextChoice(3, 0).once()
      mockNextChoice(3, 1).once()
      //verify
      mockReadIntChoice(1).never()
      //when
      val (player1, player2) = RpsChoice.getPlayers(2, mockGenerateRandomChoice)
      ///then
      player1 shouldBe Player(Rock())
      player2 shouldBe Player(Paper())
    }
  }

}
