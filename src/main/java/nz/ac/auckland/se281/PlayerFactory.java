package nz.ac.auckland.se281;

public class PlayerFactory {
  public Player creatPlayer(String difficulty) {
    switch (difficulty) {
      case "easy":
        return new AiPlayer(new RandomStrategy());
      default:
        return new AiPlayer(new RandomStrategy());
    }
  }
}
