package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

/**
 * A strategy that generates a move for the AI player based on the player's previous choices. This
 * strategy utilizes historical data to predict and counter the player's likely future moves.
 */
public class TopStrategy implements GameStrategy {
  private int oddSum; // Tracks the total number of times the player has chosen ODD
  private int evenSum; // Tracks the total number of times the player has chosen EVEN
  private ArrayList<Choice> choices; // Stores the historical choices of the player
  private Choice
      gameChoice; // The current game choice (ODD or EVEN) which affects the AI's strategy
  private int getRan; // Temporary variable used for storing randomly generated numbers

  /**
   * Constructs a TopStrategy with the specified player choices and game choice.
   *
   * @param userChoices the list of player's previous choices.
   * @param gameChoice the current game choice (ODD or EVEN).
   */
  public TopStrategy(ArrayList<Choice> userChoices, Choice gameChoice) {
    this.choices = userChoices;
    this.gameChoice = gameChoice;
  }

  /**
   * Executes the top strategy and returns the generated move. The strategy calculates the frequency
   * of ODD and EVEN choices made by the player, and decides the AI's move based on maximizing the
   * chances of winning against the player's likely choice.
   *
   * @return the generated move as a string, representing the number of fingers the AI will play.
   */
  @Override
  public String excuteStrategy() {
    for (Choice choice : choices) {
      if (choice == Choice.ODD) {
        oddSum++; // Increment the odd choice count
      } else {
        evenSum++; // Increment the even choice count
      }
    }
    if (oddSum > evenSum && gameChoice == Choice.ODD) {
      return Utils.getRandomOddNumber() + ""; // If more ODDs, and AI needs EVEN, choose ODD
    } else if (evenSum > oddSum && gameChoice == Choice.EVEN) {
      return Utils.getRandomOddNumber() + ""; // If more EVENs, and AI needs ODD, choose ODD
    } else if (oddSum > evenSum && gameChoice == Choice.EVEN) {
      getRan = Utils.getRandomEvenNumber();
      while (getRan == 0) {
        getRan = Utils.getRandomEvenNumber(); // Ensure non-zero EVEN number
      }
      return getRan + "";
    } else if (evenSum > oddSum && gameChoice == Choice.ODD) {
      getRan = Utils.getRandomEvenNumber();
      while (getRan == 0) {
        getRan = Utils.getRandomEvenNumber(); // Ensure non-zero EVEN number for ODD game choice
      }
      return getRan + "";
    } else {
      return Utils.getRandomNumberRange(0, 5)
          + ""; // No clear pattern, choose randomly between 0 and 5
    }
  }
}
