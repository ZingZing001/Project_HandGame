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

  public String getHumanMove() {
    return humanMove;
  }

  public void setHumanMove(String humanMove) {
    this.humanMove = humanMove;
  }

  public String getAiMove() {
    return aiMove;
  }

  public void setAiMove(String aiMove) {
    this.aiMove = aiMove;
  }

  public boolean isHumanWon() {
    return humanWon;
  }

  public void setHumanWon(boolean humanWon) {
    this.humanWon = humanWon;
  }
}
