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
  private PlayerFactory playerFactory;
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
    playerFactory = new PlayerFactory(game);
    ai = playerFactory.creatPlayer(difficulty);
    user.Greet();
  }

  public void play() {
    game.startNewGame();
    userInput = user.makeMove();
    aiInput = ai.makeMove();
    sum = Integer.parseInt(userInput) + Integer.parseInt(aiInput);
    result = game.PlayerWins(userInput, aiInput, choice);
    game.recordResult(userInput, aiInput, result);
    game.updateUserChoices(userInput);
    game.printOutcome(result, sum, choice);
    game.updateStrategyBasedOnDifficulty(game, difficulty, ai);
  }

  public void endGame() {}

  public void showStats() {}
}
