package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class GameController extends Game {
  private final String aiName = "HAL-9000";
  private String userInput;
  private String aiInput;
  private Boolean result;
  private int totalGamePlayed;

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

  public void recordResult(String userInput, String aiInput, Boolean result) {
    this.userInput = userInput;
    this.aiInput = aiInput;
    this.result = result;
    RoundResult roundHistory = new RoundResult(userInput, aiInput, result);
    gameHistory.add(roundHistory);
  }

  public void updateUserChoices(String userInput) {
    if (Utils.isEven(Integer.parseInt(userInput))) {
      userChoices.add(Choice.EVEN);
    } else {
      userChoices.add(Choice.ODD);
    }
  }

  public void printOutcome(boolean result, int sum, Choice choice) {
    if (!result) {
      String parity = Utils.isEven(sum) ? "EVEN" : "ODD";
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), parity, aiName);
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          String.valueOf(sum), String.valueOf(choice), name);
    }
  }

  public void updateStrategyBasedOnDifficulty(Game game, Difficulty difficulty, AiPlayer ai, ArrayList<Choice> userChoices, Choice gameChoice) {
    int gamesPlayed = Integer.parseInt(getTotalGamesPlayed());
    if (gamesPlayed >= 3) {
      if (difficulty == Difficulty.MEDIUM) {
        ai.updateStrategy(new TopStrategy(userChoices, choice));
      } else if (difficulty == Difficulty.HARD) {
        ai.swapStrategy(userChoices, choice);
      }
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
