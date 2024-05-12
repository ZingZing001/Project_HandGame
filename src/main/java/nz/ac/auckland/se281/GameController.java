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

  public void giveFinger() {
    MessageCli.ASK_INPUT.printMessage();
    userInput = input.propmtForFirstCharacter();
    
  }

  public String getTotalGamesPlayed() {
    return "" + totalGamePlayed;
  }
}
