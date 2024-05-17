package nz.ac.auckland.se281;

/** Represents a human player in the game. */
public class HumanPlayer implements Player {
  private String name;
  private String userInput;
  private InputHandler input = new InputHandler();

  /**
   * Constructs a HumanPlayer with the specified name.
   *
   * @param name the name of the human player.
   */
  public HumanPlayer(String name) {
    this.name = name;
  }

  /** Greets the human player with a welcome message. */
  public void Greet() {
    MessageCli.WELCOME_PLAYER.printMessage(name);
  }

  /**
   * Prompts the human player for their move and returns the input.
   *
   * @return the human player's input as a string.
   */
  @Override
  public String makeMove() {
    MessageCli.ASK_INPUT.printMessage();
    userInput = input.propmtForFirstCharacter();
    MessageCli.PRINT_INFO_HAND.printMessage(name, userInput);
    return userInput;
  }
}
