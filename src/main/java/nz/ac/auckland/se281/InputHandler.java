package nz.ac.auckland.se281;

/** Class for validify inputs from the user */
public class InputHandler {
  private String input;

  /**
   * This method checks whether if the userInput's validity and whether it matches with the
   * condition. It will keeps checking until the user gives out the correct form of input
   *
   * @return returns the input character
   */
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
