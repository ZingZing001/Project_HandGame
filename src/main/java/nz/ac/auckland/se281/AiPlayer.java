package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class AiPlayer extends Game implements Player {
  private final String name;
  private GameStrategy strategy;
  private String aiInput;

  public AiPlayer(GameStrategy strategy) {
    name = "HAL-9000";
    this.strategy = strategy;
  }

  public void updateStrategy(GameStrategy strategy) {
    this.strategy = strategy;
  }

  public void swapStrategy(ArrayList<Choice> choices, Choice gameChoice) {
    if (strategy instanceof RandomStrategy) {
      updateStrategy(new TopStrategy(choices, gameChoice));
    } else {
      updateStrategy(new RandomStrategy());
    }
  }

  @Override
  public String makeMove() {
    aiInput = strategy.excuteStrategy();
    MessageCli.PRINT_INFO_HAND.printMessage(name, aiInput);
    return aiInput;
  }

  public GameStrategy getStrategy() {
    return strategy;
  }
}
