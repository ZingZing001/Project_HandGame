package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class PlayerFactory {
  private Game game;

  public PlayerFactory(Game game) {
    this.game = game;
  }

  public AiPlayer creatPlayer(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new AiPlayer(new RandomStrategy(), game);
      case MEDIUM:
        return new AiPlayer(new RandomStrategy(), game);
      case HARD:
        return new AiPlayer(new TopStrategy(game), game);
      default:
        return new AiPlayer(new RandomStrategy(), game);
    }
  }
}
