package nz.ac.auckland.se281;

/** Represents a player in the game, which can be either human or AI. */
public interface Player {

  /**
   * Makes a move in the game and returns the player's input.
   *
   * @return the player's input as a string.
   */
  String makeMove();
}
