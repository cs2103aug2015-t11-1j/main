package logic;

import parser.ActionParser;
import parser.ActionParser.ACTION_TYPE;
import storage.Output;

public class DefineCommand {

	public static ExecuteCommand exeCmd = ExecuteCommand.getInstance();
	public static ACTION_TYPE userAction;
	public static Output op;
	
	public static void executeUserCommand(String userInput) {
		userAction = ActionParser.setUserAction(userInput);
		op = exeCmd.executeCommand(userAction, userInput);
		
		
	}
	
	
	
}
