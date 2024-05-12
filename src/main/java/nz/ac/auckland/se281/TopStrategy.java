package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements GameStrategy {
  private int OddSum;
  private int EvenSum;
  ArrayList<Choice> choices;

  public TopStrategy(ArrayList<Choice> userChoices) {
    this.choices = userChoices;
  }

  @Override
  public String excuteStrategy() {
    for (Choice choice : choices) {
      if (choice == Choice.ODD) {
        OddSum++;
      } else {
        EvenSum++;
      }
    }
    if (OddSum > EvenSum) {
      return Utils.getRandomEvenNumber() + "";
    } else if (OddSum == EvenSum) {
      return Utils.getRandomNumberRange(0, 5) + "";
    } else {
      return Utils.getRandomOddNumber() + "";
    }
  }
}
