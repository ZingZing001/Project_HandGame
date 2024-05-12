package nz.ac.auckland.se281;

public class AiPlayer implements Player {
  private GameStrategy strategy;

  public AiPlayer(GameStrategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public String makeMove() {
    return strategy.excuteStrategy();
  }
}
