package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  protected String name;
  protected String userInput;
  protected String aiInput;
  protected int sum;
  private final String aiName = "HAL-9000";
  private GameController game;
  private HumanPlayer user;
  private AiPlayer ai;
  private PlayerFactory playerFactory;
  private boolean result;
  private Choice choice;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.choice = choice;
    game = new GameController();
    game.resetGame();
    name = options[0];
    user = new HumanPlayer(name);
    playerFactory = new PlayerFactory();
    ai = playerFactory.creatPlayer(difficulty);
    user.Greet();
  }

  public void play() {
    game.startNewGame();
    userInput = user.makeMove();
    aiInput = ai.makeMove();
    sum = Integer.parseInt(userInput) + Integer.parseInt(aiInput);
    result = game.PlayerWins(userInput, aiInput, choice);
    if (!result && Utils.isEven(sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", aiName);
    } else if (!result && Utils.isOdd(sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", aiName);
    }
  }

  public void endGame() {}

  public void showStats() {}
}
