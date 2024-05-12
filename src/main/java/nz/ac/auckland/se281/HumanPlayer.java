package nz.ac.auckland.se281;

public class HumanPlayer implements Player {
  private String name;

  public HumanPlayer(String name) {
    this.name = name;
  }

  public void Greet() {
    MessageCli.WELCOME_PLAYER.printMessage(name);
  }

  @Override
  public int makeMove() {
    return -1;
  }
}
