package nz.ac.auckland.se281;

public class AiPlayer implements Player {
  private final String name;
  private GameStrategy strategy;
  private int playerConsecutiveWins;
  private String aiInput;

  public AiPlayer(GameStrategy strategy) {
    name = "HAL-9000";
    this.strategy = strategy;
  }

  public void updateStrategy(GameStrategy strategy) {
    this.strategy = strategy;
  }

  public void incrementPlayerWins() {
    playerConsecutiveWins++;
    if (playerConsecutiveWins >= 3 && this.strategy instanceof RandomStrategy) {
      updateStrategy(new TopStrategy());
    }
  }

  @Override
  public String makeMove() {
    aiInput = strategy.excuteStrategy();
    MessageCli.PRINT_INFO_HAND.printMessage(name, aiInput);
    return aiInput;
  }
}
