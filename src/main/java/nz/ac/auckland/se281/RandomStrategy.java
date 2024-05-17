package nz.ac.auckland.se281;

/** A strategy that generates a random move for the AI player. */
public class RandomStrategy implements GameStrategy {

  private int random;

  /**
   * Executes the random strategy and returns the generated move.
   *
   * @return the generated move as a string.
   */
  @Override
  public String excuteStrategy() {
    random = Utils.getRandomNumberRange(0, 5);
    return random + "";
  }
}
