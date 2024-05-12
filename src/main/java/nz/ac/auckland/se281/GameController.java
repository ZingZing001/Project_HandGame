package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class GameController {
  private int totalGamePlayed;
  private String userInput;
  private String aiInput;

  public GameController() {
    this.totalGamePlayed = 0;
  }

  public boolean whoWins(String userInput, String aiInput, Choice choice) {
    this.userInput = userInput;
    this.aiInput = aiInput;
    if (choice == Choice.ODD) {

    } else {

    }

    return true;
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
