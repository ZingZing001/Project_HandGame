package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class GameController extends Game {
  private String userInput;
  private String aiInput;
  private Boolean result;
  private int totalGamePlayed;
  private RoundResult roundHistory;

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
    } else if (choice == Choice.ODD && Utils.isEven(sum)) {
      return false;
    } else {
      return false;
    }
  }

  public void recordResult(
      String userInput, String aiInput, Boolean result, List<RoundResult> gameHistory) {
    this.userInput = userInput;
    this.aiInput = aiInput;
    this.result = result;
    roundHistory = new RoundResult(userInput, aiInput, result);
    gameHistory.add(roundHistory);
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

  public String getPlayerWins(List<RoundResult> gameHistory) {
    int humanWins = 0;
    if (gameHistory.isEmpty()) {
      return humanWins + "";
    } else {
      for (RoundResult history : gameHistory) {
        if (history.isHumanWon()) {
          humanWins++;
        }
      }
      return humanWins + "";
    }
  }

  public String getPlayerLoss(List<RoundResult> gameHistory) {
    int humanLoss = 0;
    if (gameHistory.isEmpty()) {
      return humanLoss + "";
    } else {
      for (RoundResult history : gameHistory) {
        if (!history.isHumanWon()) {
          humanLoss++;
        }
      }
      return humanLoss + "";
    }
  }
}
