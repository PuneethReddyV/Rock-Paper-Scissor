package com.mavericks.common

import scala.util.Random
import scala.io.StdIn.{readInt, readLine}

/*
  This class is wrpper for command line input
 */
class InputChoiceWrapper {
  def nextChoice(range: Int): Int = new Random().nextInt(range)

  def readIntChoice(): Int = readInt()

  def readStringChoice(): String = readLine()
}
