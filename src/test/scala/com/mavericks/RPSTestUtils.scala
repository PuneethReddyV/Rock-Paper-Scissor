package com.mavericks

import com.mavericks.common.InputChoiceWrapper
import org.scalamock.scalatest.MockFactory

trait RPSTestUtils extends MockFactory {

  val mockGenerateRandomChoice = mock[InputChoiceWrapper]

  def mockNextChoice(input:Int, returnValue:  Int) = (mockGenerateRandomChoice.nextChoice _).expects(input).returning(returnValue)
  def mockReadIntChoice(returnValue:  Int) =  (() => mockGenerateRandomChoice.readIntChoice()).expects().returning(returnValue)
  def mockReadLineChoice(returnValue:  String) =  (() => mockGenerateRandomChoice.readStringChoice()).expects().returning(returnValue)

}
