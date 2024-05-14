package nz.ac.auckland.se281;

public class InputHandler {
  private String input;

  public String propmtForFirstCharacter() {
    input = Utils.scanner.nextLine();

    if (input.matches("[0-5]")) {
      return input;
    } else {
      MessageCli.INVALID_INPUT.printMessage();
      return propmtForFirstCharacter();
    }
  }
}
