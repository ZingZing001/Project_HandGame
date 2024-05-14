package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  protected String name;
  protected String userInput;
  protected String aiInput;
  protected int sum;
  protected List<RoundResult> gameHistory = new ArrayList<>();
  protected ArrayList<Choice> userChoices = new ArrayList<>();
  protected Choice choice;
  private final String aiName = "HAL-9000";
  private GameController game;
  private HumanPlayer user;
  private AiPlayer ai;
  private boolean result;
  private Difficulty difficulty;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    gameHistory = new ArrayList<>();
    userChoices = new ArrayList<>();
    this.choice = choice;
    this.difficulty = difficulty;
    game = new GameController();
    game.resetGame();
    name = options[0];
    user = new HumanPlayer(name);
    ai = PlayerFactory.creatPlayer(difficulty);
    user.Greet();
  }

  public void play() {
    if (this.game == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      game.startNewGame();
      userInput = user.makeMove();
      aiInput = ai.makeMove();
      sum = Integer.parseInt(userInput) + Integer.parseInt(aiInput);
      result = game.PlayerWins(userInput, aiInput, choice);
      game.recordResult(userInput, aiInput, result, gameHistory);
      if (Utils.isEven(Integer.parseInt(userInput))) {
        userChoices.add(Choice.EVEN);
      } else {
        userChoices.add(Choice.ODD);
      }

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

  public void endGame() {}

  public void showStats() {
    if (this.game == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
    }
  }
}
