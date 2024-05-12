package nz.ac.auckland.se281;

public class RandomStrategy implements GameStrategy {

  private int random;

  @Override
  public int excuteStrategy() {
    random = Utils.random.nextInt(5);
    return -1;
  }
}
