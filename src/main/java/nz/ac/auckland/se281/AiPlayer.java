package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

/** Represents an AI player in the game, using different strategies to make moves. */
public class AiPlayer extends Game implements Player {
  private final String name;
  private GameStrategy strategy;
  private String aiInput;

  /**
   * Constructs an AI player with the specified initial strategy.
   *
   * @param strategy the initial strategy for the AI player.
   */
  public AiPlayer(GameStrategy strategy) {
    name = "HAL-9000";
    this.strategy = strategy;
  }

  /**
   * Updates the AI player's strategy.
   *
   * @param strategy the new strategy for the AI player.
   */
  public void updateStrategy(GameStrategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Swaps the AI player's strategy between RandomStrategy and TopStrategy based on the current
   * strategy.
   *
   * @param choices the list of choices available.
   * @param gameChoice the current game choice.
   */
  public void swapStrategy(ArrayList<Choice> choices, Choice gameChoice) {
    if (strategy instanceof RandomStrategy) {
      updateStrategy(new TopStrategy(choices, gameChoice));
    } else {
      updateStrategy(new RandomStrategy());
    }
  }

  /**
   * Makes a move using the current strategy and returns the AI player's input.
   *
   * @return the AI player's input as a string.
   */
  @Override
  public String makeMove() {
    aiInput = strategy.excuteStrategy();
    MessageCli.PRINT_INFO_HAND.printMessage(name, aiInput);
    return aiInput;
  }
}
