package nz.ac.auckland.se281;

public class GameController {
  private int totalGamePlayed;
  private String userInput;
  private InputHandler input = new InputHandler();

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

  public String userFinger() {
    MessageCli.ASK_INPUT.printMessage();
    userInput = input.propmtForFirstCharacter();
    return userInput;
  }

  public String getTotalGamesPlayed() {
    return "" + totalGamePlayed;
  }
}
