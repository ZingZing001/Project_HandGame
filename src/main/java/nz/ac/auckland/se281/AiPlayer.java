package nz.ac.auckland.se281;

public class AiPlayer implements Player {
  private final String name;
  private GameStrategy strategy;
  private int playerConsecutiveWins;
  private String aiInput;
  private Game game;

  public AiPlayer(GameStrategy strategy, Game game) {
    this.game = game;
    name = "HAL-9000";
    playerConsecutiveWins = 0;
    this.strategy = strategy;
  }

  public void updateStrategy(GameStrategy strategy) {
    this.strategy = strategy;
  }

  public void incrementPlayerWins() {
    playerConsecutiveWins++;
    if (playerConsecutiveWins >= 3 && this.strategy instanceof RandomStrategy) {
      updateStrategy(new TopStrategy(game));
    }
  }

  @Override
  public String makeMove() {
    aiInput = strategy.excuteStrategy();
    MessageCli.PRINT_INFO_HAND.printMessage(name, aiInput);
    return aiInput;
  }
}
