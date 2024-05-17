package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private final String aiName = "HAL-9000";
  protected String name;
  protected String userInput;
  protected String aiInput;
  protected int sum;
  protected List<RoundResult> gameHistory = new ArrayList<>();
  protected ArrayList<Choice> userChoices = new ArrayList<>();
  protected Choice choice;
  protected boolean result;
  private GameController game;
  private HumanPlayer user;
  private AiPlayer ai;
  private Difficulty difficulty;

  /**
   * COMMAND to initialise and start a new game
   *
   * @param difficulty difficulty of the game chosen by the user
   * @param choice ODD or EVEN chosen by the user
   * @param options User's Name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.choice = choice;
    this.difficulty = difficulty;
    ai = PlayerFactory.creatPlayer(difficulty);
    gameHistory = new ArrayList<>();
    userChoices = new ArrayList<>();
    game = new GameController();
    game.resetGame();
    name = options[0];
    user = new HumanPlayer(name);
    user.Greet();
    game.setGameStarted(true);
  }

  /** COMMAND to play the game with the current user profile */
  public void play() {
    if (this.game == null || !game.isGameStarted()) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      game.startNewGame();
      userInput = user.makeMove();
      aiInput = ai.makeMove();
      sum = Integer.parseInt(userInput) + Integer.parseInt(aiInput);
      result = game.PlayerWins(userInput, aiInput, choice);
      game.recordResult(userInput, aiInput, result, gameHistory);
      updateUserChoices(userInput);
      printOutcome(result, sum, choice);
    }
  }

  /** COMMAND to end the gameand display the round stats and who won the game */
  public void endGame() {
    if (this.game == null || !game.isGameStarted()) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      int humanWins = Integer.parseInt(game.getPlayerWins(gameHistory));
      int aiWins = Integer.parseInt(game.getAiWins(gameHistory));
      showStats();
      game.resetGame();
      if (humanWins > aiWins) {
        MessageCli.PRINT_END_GAME.printMessage(name);
      } else if (aiWins > humanWins) {
        MessageCli.PRINT_END_GAME.printMessage(aiName);
      } else {
        MessageCli.PRINT_END_GAME_TIE.printMessage();
      }
    }
  }

  /** COMMAND to show the stats of the current game */
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
   * Records what did the user input and categories them as ODD or EVEN based on the integer value
   *
   * @param userInput Input from the user
   */
  private void updateUserChoices(String userInput) {
    if (Utils.isEven(Integer.parseInt(userInput))) {
      userChoices.add(Choice.EVEN);
    } else {
      userChoices.add(Choice.ODD);
    }
  }

  /**
   * Prints the stats of the current round, and update ai strategy accordinly
   *
   * @param result The result of the game, gives the output of who won the game
   * @param sum The sum of the Inputs from both user and the ai
   * @param choice The EVEN or ODD choice made by the user at the start of the game
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
