package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/**
 * PlayerFactory class that generates AI bots with selected fifficulty by using the Factory design
 * pattern.
 */
public class PlayerFactory {
  /**
   * @param difficulty Difficulty selected by the user
   * @return A new AiPlayer equipped with default strategy and selected difficulty
   */
  public static AiPlayer creatPlayer(Difficulty difficulty) {
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
