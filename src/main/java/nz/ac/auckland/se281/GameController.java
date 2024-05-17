package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * Controller class for managing the game logic and keeping track of game states and results. This
 * class is responsible for implementing the game rules and managing round results.
 */
public class GameController extends Game {
  private int totalGamePlayed; // Counter for the number of games played.
  private RoundResult roundHistory; // Object to store the result of the current round.
  private Boolean gameStarted; // Flag to indicate if the game has been started.

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
    int sum = Integer.parseInt(userInput) + Integer.parseInt(aiInput);
    // Determine the result based on the sum of inputs and the player's choice.
    return (choice == Choice.ODD && Utils.isOdd(sum))
        || (choice == Choice.EVEN && Utils.isEven(sum));
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
    MessageCli.START_ROUND.printMessage(Integer.toString(totalGamePlayed));
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
    return Integer.toString(totalGamePlayed);
  }

  /**
   * Returns the number of rounds the player has won.
   *
   * @param gameHistory the list of all round results.
   * @return the number of player wins as a string.
   */
  public String getPlayerWins(List<RoundResult> gameHistory) {
    return countWins(gameHistory, true);
  }

  /**
   * Returns the number of rounds the player has lost.
   *
   * @param gameHistory the list of all round results.
   * @return the number of player losses as a string.
   */
  public String getPlayerLoss(List<RoundResult> gameHistory) {
    return countWins(gameHistory, false);
  }

  /**
   * Returns the number of rounds the AI has won.
   *
   * @param gameHistory the list of all round results.
   * @return the number of AI wins as a string.
   */
  public String getAiWins(List<RoundResult> gameHistory) {
    return countWins(gameHistory, false);
  }

  /**
   * Returns the number of rounds the AI has lost.
   *
   * @param gameHistory the list of all round results.
   * @return the number of AI losses as a string.
   */
  public String getAiLoss(List<RoundResult> gameHistory) {
    return countWins(gameHistory, true);
  }

  /**
   * Helper method to count wins or losses from the game history.
   *
   * @param gameHistory the list of all round results.
   * @param countWins true to count wins, false to count losses.
   * @return the count of wins or losses as a string.
   */
  private String countWins(List<RoundResult> gameHistory, boolean countWins) {
    int count = 0;
    for (RoundResult history : gameHistory) {
      if (history.isHumanWon() == countWins) {
        count++;
      }
    }
    return Integer.toString(count);
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
