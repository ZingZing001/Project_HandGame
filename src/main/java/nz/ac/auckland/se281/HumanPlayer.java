package nz.ac.auckland.se281;

public class HumanPlayer implements Player {
  private String name;
  private String userInput;
  private InputHandler input = new InputHandler();

  public HumanPlayer(String name) {
    this.name = name;
  }

  public void Greet() {
    MessageCli.WELCOME_PLAYER.printMessage(name);
  }

  @Override
  public String makeMove() {
    MessageCli.ASK_INPUT.printMessage();
    userInput = input.propmtForFirstCharacter();
    return userInput;
  }
}
