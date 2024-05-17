package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/**
 * Represents the game's main entry point. This class handles the game lifecycle including starting,
 * playing, and ending the game, as well as managing game state and player interactions.
 */
public class Game {
  private final String aiName = "HAL-9000";
  protected String name; // Player's name
  protected String userInput; // Last input from the human player
  protected String aiInput; // Last input from the AI player
  protected int sum; // Sum of fingers played in the current round
  protected List<RoundResult> gameHistory = new ArrayList<>(); // History of all rounds played
  protected ArrayList<Choice> userChoices =
      new ArrayList<>(); // Historical list of choices made by the user
  protected Choice choice; // Current choice of the user, either ODD or EVEN
  protected boolean result; // Result of the current round, true if user wins
  private GameController game; // Game controller managing game logic and state
  private HumanPlayer user; // Human player instance
  private AiPlayer ai; // AI player instance
  private Difficulty difficulty; // Difficulty level of the game

  /**
   * Initializes and starts a new game session. Sets up players, game state, and initial conditions
   * based on user input.
   *
   * @param difficulty The difficulty level of the game, affecting AI behavior.
   * @param choice The initial choice (ODD or EVEN) that determines winning conditions.
   * @param options Contains player-specific options such as player names.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.choice = choice;
    this.difficulty = difficulty;
    gameHistory = new ArrayList<>();
    userChoices = new ArrayList<>();
    game = new GameController();
    game.resetGame(); // Ensure the game is in a clean state
    name = options[0];
    user = new HumanPlayer(name);
    ai =
        PlayerFactory.creatPlayer(difficulty); // Create an AI player based on the chosen difficulty
    user.Greet(); // Display a greeting to the user
    game.setGameStarted(true);
  }

  /** Processes a single round of play, including making moves and determining the round outcome. */
  public void play() {
    if (this.game == null || !game.isGameStarted()) {
      MessageCli.GAME_NOT_STARTED.printMessage(); // Ensure the game has been properly started
    } else {
      game.startNewGame(); // Prepare the game for a new round
      userInput = user.makeMove();
      aiInput = ai.makeMove();
      sum = Integer.parseInt(userInput) + Integer.parseInt(aiInput);
      result = game.PlayerWins(userInput, aiInput, choice);
      game.recordResult(userInput, aiInput, result, gameHistory);
      updateUserChoices(userInput);
      printOutcome(result, sum, choice);
    }
  }

  /**
   * Ends the current game, displays the final outcome, and resets the game for a possible new
   * session.
   */
  public void endGame() {
    if (this.game == null || !game.isGameStarted()) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      int humanWins = Integer.parseInt(game.getPlayerWins(gameHistory));
      int aiWins = Integer.parseInt(game.getAiWins(gameHistory));
      showStats(); // Display game statistics
      game.resetGame(); // Reset game state
      if (humanWins > aiWins) {
        MessageCli.PRINT_END_GAME.printMessage(name); // User wins
      } else if (aiWins > humanWins) {
        MessageCli.PRINT_END_GAME.printMessage(aiName); // AI wins
      } else {
        MessageCli.PRINT_END_GAME_TIE.printMessage(); // Tie game
      }
    }
  }

  /** Displays statistics of the current game session including the number of wins and losses. */
  public void showStats() {
    if (this.game == null || !game.isGameStarted()) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          name, game.getPlayerWins(gameHistory), game.getPlayerLoss(gameHistory));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          aiName, game.getAiWins(gameHistory), game.getAiLoss(gameHistory));
    }
  }

  /**
   * Records the user's choice (ODD or EVEN) based on the integer value of the input and adds it to
   * the history.
   *
   * @param userInput The last move made by the user, expected to be a string that can be parsed as
   *     an integer.
   */
  private void updateUserChoices(String userInput) {
    if (Utils.isEven(Integer.parseInt(userInput))) {
      userChoices.add(Choice.EVEN);
    } else {
      userChoices.add(Choice.ODD);
    }
  }

  /**
   * Prints the outcome of the current round and updates AI strategy if necessary based on the
   * game's progress.
   *
   * @param result The result of the current round, true if the user wins.
   * @param sum The sum of fingers played by the user and AI in the current round.
   * @param choice The user's initial choice of ODD or EVEN, which determines the winning condition.
   */
  private void printOutcome(boolean result, int sum, Choice choice) {
    if (!result && Utils.isEven(sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", aiName);
      if (difficulty == Difficulty.MEDIUM && Integer.parseInt(game.getTotalGamesPlayed()) >= 3) {
        ai.updateStrategy(new TopStrategy(userChoices, choice));
      }
    } else if (!result && Utils.isOdd(sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", aiName);
      if (difficulty == Difficulty.MEDIUM && Integer.parseInt(game.getTotalGamesPlayed()) >= 3) {
        ai.updateStrategy(new TopStrategy(userChoices, choice));
      }
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          String.valueOf(sum), String.valueOf(choice), name);
      if (difficulty == Difficulty.MEDIUM && Integer.parseInt(game.getTotalGamesPlayed()) >= 3) {
        ai.updateStrategy(new TopStrategy(userChoices, choice));
      } else if (difficulty == Difficulty.HARD
          && Integer.parseInt(game.getTotalGamesPlayed()) >= 3) {
        ai.swapStrategy(userChoices, choice);
      }
    }
  }
}
