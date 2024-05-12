package nz.ac.auckland.se281;

public class GameController {
  private int totalGamePlayed;

  public GameController(){
    this.totalGamePlayed = 0;
  }

  public void startNewGame(){
    totalGamePlayed++;
  }

  public int getTotalGamesPlayed(){
    return totalGamePlayed;
  }
  
}
