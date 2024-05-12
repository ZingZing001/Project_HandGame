package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private String name;
  private GameController game = new GameController();

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    name = options[0];
    HumanPlayer name = new HumanPlayer(this.name);
    name.Greet();
  }

  public void play() {
    game.startNewGame();
  }

  public void endGame() {}

  public void showStats() {}
}
