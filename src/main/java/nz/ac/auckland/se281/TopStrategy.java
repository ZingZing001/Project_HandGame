package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy extends Game implements GameStrategy {
  private int OddSum;
  private int EvenSum;

  public TopStrategy() {
    OddSum = 0;
    EvenSum = 0;
  }

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
    } else {
      return Utils.getRandomOddNumber() + "";
    }
  }
}
