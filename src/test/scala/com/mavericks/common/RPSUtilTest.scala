package com.mavericks.common

import com.mavericks.RPSTestUtils
import com.mavericks.common.{InputChoiceWrapper, RPSUtil}
import org.scalatest.{Matchers, WordSpec}

class RPSUtilTest extends WordSpec with Matchers with RPSTestUtils {

  "RPSUtil#readIntChoice" should {
    "read valid integer with in the given range of values" in {
      mockReadIntChoice(4).once()
      val result = RPSUtil.readIntChoice[Int]("enter digit from 1 to 4", List(1,2,3,4))(mockGenerateRandomChoice.readIntChoice)
      result shouldBe 4
    }
    "read integer until valid number is provided" in {
      //given
      mockReadIntChoice(5).once()
      //verify
      mockReadIntChoice(3).once()
      //when
      val result = RPSUtil.readIntChoice[Int]("enter digit from 1 to 4", List(1,2,3,4))(mockGenerateRandomChoice.readIntChoice)
      //then
      result shouldBe 3
    }
  }
}
