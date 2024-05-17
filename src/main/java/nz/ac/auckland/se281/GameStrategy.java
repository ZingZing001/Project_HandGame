package nz.ac.auckland.se281;

/** Represents a strategy that can be used by a player in the game. */
public interface GameStrategy {

  /**
   * Executes the strategy and returns the player's move as a string.
   *
   * @return the player's move as a string.
   */
  String excuteStrategy();
}
