package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/**
 * PlayerFactory class that generates AI bots with selected difficulty by using the Factory design
 * pattern. This class abstracts the creation of AI players, allowing for easy adjustment of AI
 * behavior based on the game difficulty.
 */
public class PlayerFactory {
  /**
   * Generates an AiPlayer profile with a strategy based on the selected difficulty. This method
   * acts as a factory for creating AiPlayer instances equipped with strategies that are appropriate
   * for the chosen difficulty level of the game.
   *
   * @param difficulty Difficulty selected by the user.
   * @return A new AiPlayer equipped with a strategy suitable for the selected difficulty.
   */
  public static AiPlayer creatPlayer(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        // For EASY difficulty, the AI uses a random strategy which does not adapt to the player's
        // moves.
        return new AiPlayer(new RandomStrategy());
      case MEDIUM:
        // For MEDIUM difficulty, currently configured to use the same random strategy, intended for
        // future enhancements.
        return new AiPlayer(new RandomStrategy());
      case HARD:
        // For HARD difficulty, also using a random strategy, but can be updated to a more complex
        // strategy.
        return new AiPlayer(new RandomStrategy());
      default:
        // Default case to handle any undefined difficulties, ensuring that an AI player is always
        // created.
        return new AiPlayer(new RandomStrategy());
    }
  }
}
