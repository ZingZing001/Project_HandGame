package nz.ac.auckland.se281;

public class RoundResult extends Game {
  private boolean humanWon;

  public RoundResult(boolean humanWon) {
    this.humanWon = humanWon;
  }

  public boolean isHumanWon() {
    return humanWon;
  }
}
