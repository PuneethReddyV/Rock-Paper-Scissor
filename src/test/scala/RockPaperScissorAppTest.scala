import com.mavericks.{RPSTestUtils, RockPaperScissorApp}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{Matchers, WordSpec}

class RockPaperScissorAppTest extends WordSpec with Matchers with RPSTestUtils {

  "RockPaperScissorApp#startGame" should {

    "allow user to send input for 'player vs computer' game" in {
      //given
      mockReadIntChoice(1).twice() //send 1 input from user for 'player vs computer' AND to select 'Rock' choice
      mockNextChoice(3, 1).once() //computer picks paper(index start from 0)
      mockReadLineChoice("quit").once()  // to end game
      //verify
      mockReadIntChoice(1).never()
      //when
      RockPaperScissorApp.startGame(mockGenerateRandomChoice) //player 2 wins
    }

    "skip user input for 'computer vs computer' game" in {
      //given
      mockReadIntChoice(2).once() //send 2 input from user for 'computer vs computer'
      mockNextChoice(3, 0).once() //computer picks paper for player-1 (index start from 0)
      mockNextChoice(3, 1).once() //computer picks rock for player-2 (index start from 0)
      mockReadLineChoice("quit").once()
      //verify
      mockReadIntChoice(1).never()
      //when
      RockPaperScissorApp.startGame(mockGenerateRandomChoice)
    }

    "get further inputs from user when then game is tie" in {
      //given
      mockReadIntChoice(2).once() //send 2 input from user for 'computer vs computer'
      mockNextChoice(3, 0).twice() //computer picks same choice for both players (index start from 0)
      //verify
      mockNextChoice(3, 0).once() //computer picks rock for player-2 (index start from 0)
      mockNextChoice(3, 1).once() //computer picks paper for player-2 (index start from 0)
      mockReadLineChoice("quit").once()
      //when
      RockPaperScissorApp.startGame(mockGenerateRandomChoice)
    }

    "press any key should allow for other new game" in {
      //GAME-1
      mockReadIntChoice(2).once() //send 2 input from user for 'computer vs computer'
      mockNextChoice(3, 0).once() //computer picks paper for player-1 (index start from 0)
      mockNextChoice(3, 1).once() //computer picks rock for player-2 (index start from 0)
      mockReadLineChoice("continue...").once()
      //GAME-2
      mockReadIntChoice(2).once() //send 2 input from user for 'computer vs computer'
      mockNextChoice(3, 1).once() //computer picks paper for player-1 (index start from 0)
      mockNextChoice(3, 2).once() //computer picks rock for player-2 (index start from 0)
      mockReadLineChoice("quit").once()
      //when
      RockPaperScissorApp.startGame(mockGenerateRandomChoice)
    }

    "typing 'quit' should not allow for any further inputs from user" in {
      mockReadIntChoice(2).once() //send 2 input from user for 'computer vs computer'
      mockNextChoice(3, 0).once() //computer picks paper for player-1 (index start from 0)
      mockNextChoice(3, 1).once() //computer picks rock for player-2 (index start from 0)
      mockReadLineChoice("quit").once()
      //verify
      mockNextChoice(3,2).never()
      mockReadIntChoice(2).never()
      mockReadLineChoice("").never()
      //when
      RockPaperScissorApp.startGame(mockGenerateRandomChoice)
    }

  }

}
