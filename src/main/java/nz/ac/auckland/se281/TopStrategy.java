package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy extends Game implements GameStrategy {
  private int OddSum;
  private int EvenSum;

  @Override
  public String excuteStrategy() {
    for (Choice choice : userChoices) {
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
