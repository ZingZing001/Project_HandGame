package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class PlayerFactory {
  public Player creatPlayer(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new AiPlayer(new RandomStrategy());
      case MEDIUM:
        return new AiPlayer(new RandomStrategy());
      case HARD:
        return new AiPlayer(new RandomStrategy());
      default:
        return new AiPlayer(new RandomStrategy());
    }
  }
}
