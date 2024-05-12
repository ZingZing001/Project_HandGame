package nz.ac.auckland.se281;


import nz.ac.auckland.se281.Main.Choice;

public class GameController extends Game {
  private int totalGamePlayed;
  private int sum = 0;
  private Boolean result;
  private Boolean isEven;
  private Boolean isOdd;

  public GameController() {
    this.totalGamePlayed = 0;
  }

  public boolean PlayerWins(String userInput, String aiInput, Choice choice) {
    this.userInput = userInput;
    this.aiInput = aiInput;
    sum = Integer.parseInt(userInput) + Integer.parseInt(aiInput);

    if (choice == Choice.ODD && Utils.isOdd(sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", name);
      return true;
    } else if (choice == Choice.EVEN && Utils.isEven(sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", name);
      return true;
    } else if (choice == Choice.ODD && Utils.isEven(sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", "HAL-9000");
      return false;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", "HAL-9000");
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
