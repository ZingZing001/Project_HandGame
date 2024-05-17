package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** Controller class for managing the game logic and keeping track of game states and results. */
public class GameController extends Game {
  private int totalGamePlayed;
  private RoundResult roundHistory;
  private Boolean gameStarted;

  /** Initializes a new instance of the GameController class. */
  public GameController() {
    this.totalGamePlayed = 0;
    this.gameStarted = false;
  }

  /**
   * Determines if the player wins the round based on the user's input, AI's input, and the player's
   * choice.
   *
   * @param userInput the user's input as a string.
   * @param aiInput the AI's input as a string.
   * @param choice the player's choice (ODD or EVEN).
   * @return true if the player wins, false otherwise.
   */
  public boolean PlayerWins(String userInput, String aiInput, Choice choice) {
    this.userInput = userInput;
    this.aiInput = aiInput;
    int sum = Integer.parseInt(userInput) + Integer.parseInt(aiInput);

    if (choice == Choice.ODD && Utils.isOdd(sum)) {
      return true;
    } else if (choice == Choice.EVEN && Utils.isEven(sum)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Records the result of the current round and adds it to the game history.
   *
   * @param userInput the user's input as a string.
   * @param aiInput the AI's input as a string.
   * @param result the result of the round (true if the player won, false otherwise).
   * @param gameHistory the list of all round results.
   */
  public void recordResult(
      String userInput, String aiInput, Boolean result, List<RoundResult> gameHistory) {
    this.userInput = userInput;
    this.aiInput = aiInput;
    this.result = result;
    roundHistory = new RoundResult(result);
    gameHistory.add(roundHistory);
  }

  /**
   * Starts a new game, setting the game state to active and incrementing the total games played
   * counter.
   */
  public void startNewGame() {
    gameStarted = true;
    totalGamePlayed++;
    MessageCli.START_ROUND.printMessage(totalGamePlayed + "");
  }

  /**
   * Resets the game, setting the game state to inactive and resetting the total games played
   * counter.
   */
  public void resetGame() {
    gameStarted = false;
    totalGamePlayed = 0;
  }

  /**
   * Returns the total number of games played.
   *
   * @return the total number of games played as a string.
   */
  public String getTotalGamesPlayed() {
    return "" + totalGamePlayed;
  }

  /**
   * Returns the number of rounds the player has won.
   *
   * @param gameHistory the list of all round results.
   * @return the number of player wins as a string.
   */
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

  /**
   * Returns the number of rounds the player has lost.
   *
   * @param gameHistory the list of all round results.
   * @return the number of player losses as a string.
   */
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

  /**
   * Returns the number of rounds the AI has lost.
   *
   * @param gameHistory the list of all round results.
   * @return the number of AI losses as a string.
   */
  public String getAiLoss(List<RoundResult> gameHistory) {
    int aiLoss = 0;
    if (gameHistory.isEmpty()) {
      return aiLoss + "";
    } else {
      for (RoundResult history : gameHistory) {
        if (history.isHumanWon()) {
          aiLoss++;
        }
      }
      return aiLoss + "";
    }
  }

  /**
   * Returns the number of rounds the AI has won.
   *
   * @param gameHistory the list of all round results.
   * @return the number of AI wins as a string.
   */
  public String getAiWins(List<RoundResult> gameHistory) {
    int aiWins = 0;
    if (gameHistory.isEmpty()) {
      return aiWins + "";
    } else {
      for (RoundResult history : gameHistory) {
        if (!history.isHumanWon()) {
          aiWins++;
        }
      }
      return aiWins + "";
    }
  }

  /**
   * Returns whether the game has started.
   *
   * @return true if the game has started, false otherwise.
   */
  public Boolean isGameStarted() {
    return gameStarted;
  }

  /**
   * Sets the game state to started or not started.
   *
   * @param gameStarted the game state to set.
   */
  public void setGameStarted(Boolean gameStarted) {
    this.gameStarted = gameStarted;
  }
}
