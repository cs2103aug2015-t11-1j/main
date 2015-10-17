package planit;

import planit.ActionParser.ACTION_TYPE;

public class DefineCommand {

	public static ExecuteCommand exeCmd = ExecuteCommand.getInstance();
	public static ACTION_TYPE userAction;
	public static Output op = new Output();
	
	public static void executeUserCommand(String userInput) {
		userAction = ActionParser.setUserAction(userInput);
		exeCmd.executeCommand(userAction, userInput);
	}
	
	
	
}
