package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

/** A strategy that generates a move for the AI player based on the player's previous choices. */
public class TopStrategy implements GameStrategy {
  private int oddSum;
  private int evenSum;
  private ArrayList<Choice> choices;
  private Choice gameChoice;
  private int getRan;

  /**
   * Constructs a TopStrategy with the specified player choices and game choice.
   *
   * @param userChoices the list of player's previous choices.
   * @param gameChoice the current game choice.
   */
  public TopStrategy(ArrayList<Choice> userChoices, Choice gameChoice) {
    this.choices = userChoices;
    this.gameChoice = gameChoice;
  }

  /**
   * Executes the top strategy and returns the generated move.
   *
   * @return the generated move as a string.
   */
  @Override
  public String excuteStrategy() {
    for (Choice choice : choices) {
      if (choice == Choice.ODD) {
        oddSum++;
      } else {
        evenSum++;
      }
    }
    if (oddSum > evenSum && gameChoice == Choice.ODD) {
      return Utils.getRandomOddNumber() + "";
    } else if (evenSum > oddSum && gameChoice == Choice.EVEN) {
      return Utils.getRandomOddNumber() + "";
    } else if (oddSum > evenSum && gameChoice == Choice.EVEN) {
      getRan = Utils.getRandomEvenNumber();
      while (getRan == 0) {
        getRan = Utils.getRandomEvenNumber();
      }
      return getRan + "";
    } else if (evenSum > oddSum && gameChoice == Choice.ODD) {
      getRan = Utils.getRandomEvenNumber();
      while (getRan == 0) {
        getRan = Utils.getRandomEvenNumber();
      }
      return getRan + "";
    } else {
      return Utils.getRandomNumberRange(0, 5) + "";
    }
  }
}
