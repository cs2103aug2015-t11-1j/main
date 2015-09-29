/* 
 * @author: Ishvinder Singh
 * 
 */

package planit;

public class Logic {

	private static Command userCommand;
	
	public static void main(String[] args) {
		Welcome.welcomeMessage();
		String userInput = Welcome.requestInput();
		executeCommand(userInput);
	}

	private static String executeCommand(String userInput) {
		userCommand = new Command(userInput);
		return null;
	}

}
