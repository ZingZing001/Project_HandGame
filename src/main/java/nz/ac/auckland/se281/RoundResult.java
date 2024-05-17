package nz.ac.auckland.se281;

/** Represents the result of a single round in the game. */
public class RoundResult extends Game {
  private boolean humanWon;

  /**
   * Constructs a RoundResult with the specified outcome.
   *
   * @param humanWon true if the human player won the round, false otherwise.
   */
  public RoundResult(boolean humanWon) {
    this.humanWon = humanWon;
  }

  /**
   * Checks if the human player won the round.
   *
   * @return true if the human player won, false otherwise.
   */
  public boolean isHumanWon() {
    return humanWon;
  }
}
