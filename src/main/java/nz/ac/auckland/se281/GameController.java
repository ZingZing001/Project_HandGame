package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class GameController extends Game {
  private int totalGamePlayed;
  private Boolean result;
  private Boolean isEven;
  private Boolean isOdd;

  public GameController() {
    this.totalGamePlayed = 0;
  }

  public boolean PlayerWins(String userInput, String aiInput, Choice choice) {
    this.userInput = userInput;
    this.aiInput = aiInput;

    if (choice == Choice.ODD && Utils.isOdd(sum)) {
      return true;
    } else if (choice == Choice.EVEN && Utils.isEven(sum)) {
      return true;
    } else if (choice == Choice.ODD && Utils.isEven(sum)) {
      return false;
    } else {
      return false;
    }
  }

  public void startNewGame() {
    totalGamePlayed++;
    MessageCli.START_ROUND.printMessage(totalGamePlayed + "");
  }

  public void resetGame() {
    totalGamePlayed = 0;
  }

  public void endGame(Boolean result) {
    this.result = result;
    if (result) {

    } else {

    }
  }

  public String getTotalGamesPlayed() {
    return "" + totalGamePlayed;
  }
}
