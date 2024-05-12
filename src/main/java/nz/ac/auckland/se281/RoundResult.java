package nz.ac.auckland.se281;

public class RoundResult {
  private int humanMove;
  private int aiMove;
  private boolean humanWon;

  public RoundResult(int humanMove, int aiMove, boolean humanWon) {
    this.humanMove = humanMove;
    this.aiMove = aiMove;
    this.humanWon = humanWon;
  }

  public int getHumanMove() {
    return humanMove;
  }

  public void setHumanMove(int humanMove) {
    this.humanMove = humanMove;
  }

  public int getAiMove() {
    return aiMove;
  }

  public void setAiMove(int aiMove) {
    this.aiMove = aiMove;
  }

  public boolean isHumanWon() {
    return humanWon;
  }

  public void setHumanWon(boolean humanWon) {
    this.humanWon = humanWon;
  }
}
