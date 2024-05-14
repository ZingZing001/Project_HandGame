package nz.ac.auckland.se281;

public class RoundResult extends Game {
  private String humanMove;
  private String aiMove;
  private boolean humanWon;

  public RoundResult(String humanMove, String aiMove, boolean humanWon) {
    this.humanMove = humanMove;
    this.aiMove = aiMove;
    this.humanWon = humanWon;
  }

  public boolean isHumanWon() {
    return humanWon;
  }
}
