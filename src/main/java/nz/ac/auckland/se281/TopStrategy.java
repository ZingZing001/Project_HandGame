package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements GameStrategy {
  private int OddSum;
  private int EvenSum;
  private ArrayList<Choice> choices;
  private Choice gameChoice;
  private int getRan;

  public TopStrategy(ArrayList<Choice> userChoices, Choice gameChoice) {
    this.choices = userChoices;
    this.gameChoice = gameChoice;
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
    if (OddSum > EvenSum && gameChoice == Choice.ODD) {
      return Utils.getRandomOddNumber() + "";
    } else if (EvenSum > OddSum && gameChoice == Choice.EVEN) {
      return Utils.getRandomOddNumber() + "";
    } else if (OddSum > EvenSum && gameChoice == Choice.EVEN) {
      getRan = Utils.getRandomEvenNumber();
      while (getRan == 0) {
        getRan = Utils.getRandomEvenNumber();
      }
      return getRan + "";
    } else if (EvenSum > OddSum && gameChoice == Choice.ODD) {
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
