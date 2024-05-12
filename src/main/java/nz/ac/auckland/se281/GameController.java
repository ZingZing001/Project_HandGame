package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class GameController {
  private int totalGamePlayed;
  private String userInput;
  private String aiInput;
  private int sum = 0;

  public GameController() {
    this.totalGamePlayed = 0;
  }

  public boolean PlayerWins(String userInput, String aiInput, Choice choice) {
    this.userInput = userInput;
    this.aiInput = aiInput;
    sum = Integer.parseInt(userInput) + Integer.parseInt(aiInput);
    if (choice == Choice.ODD && Utils.isOdd(sum)) {
      return true;
    } else if (choice == Choice.EVEN && Utils.isEven(sum)) {
      return true;
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

  public String getTotalGamesPlayed() {
    return "" + totalGamePlayed;
  }
}
