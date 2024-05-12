package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private String name;
  private String userInput;
  private GameController game;
  private HumanPlayer user;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    game = new GameController();
    name = options[0];
    user = new HumanPlayer(name);
    user.Greet();
    game.resetGame();
  }

  public void play() {
    game.startNewGame();
    userInput = user.makeMove();
  }

  public void endGame() {}

  public void showStats() {}
}
