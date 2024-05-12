package nz.ac.auckland.se281;

public class RandomStrategy implements GameStrategy {

  private int random;

  @Override
  public int excuteStrategy() {
    random = Utils.getRandomNumberRange(0, 5);
    return random;
  }
}
