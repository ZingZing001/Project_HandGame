package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  protected String name;
  protected String userInput;
  protected String aiInput;
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
    result = game.PlayerWins(userInput, aiInput, choice);
  }

  public void endGame() {}

  public void showStats() {}
}
