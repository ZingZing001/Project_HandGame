package nz.ac.auckland.se281;

public class AiPlayer implements Player {
  private GameStrategy strategy;
  private int playerConsecutiveWins;

  public AiPlayer(GameStrategy strategy) {
    this.strategy = strategy;
  }

  public void updateStrategy(GameStrategy strategy) {
    this.strategy = strategy;
  }

  public void incrementWins() {
    playerConsecutiveWins++;
    if (playerConsecutiveWins >= 3 && this.strategy instanceof RandomStrategy) {
      updateStrategy(new TopStrategy());
    }
  }

  @Override
  public String makeMove() {
    return strategy.excuteStrategy();
  }
}
