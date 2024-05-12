package nz.ac.auckland.se281;

public class GameController {
  private int totalGamePlayed;

  public GameController() {
    this.totalGamePlayed = 0;
  }

  public void startNewGame() {
    totalGamePlayed++;
    MessageCli.START_ROUND.printMessage(totalGamePlayed + "");
  }

  public void resetGame() {
    totalGamePlayed = 0;
  }

  public String getTotalGamesPlayed() {
    return "" + totalGamePlayed;
  }
}
