package logic;

import java.util.Stack;

import parser.Parser;
import storage.Output;
import storage.Storage;

public class Session {
	
	public static Stack<State> undoStack = new Stack<State>();
	public static Stack<State> redoStack = new Stack<State>();
	
	public Session() {
		
	}
	
	public static State initialSetup() {
		undoStack.push(Storage.extractState());
	}
	
	public static Output executeCommand(String userInput) {
		Command userCommand = Parser.setCommand(userInput);
		userCommand.setCurrState();
		Output op = userCommand.execute();
		
		if(userCommand.isMutator(userCommand)) {
			undoStack.push(userCommand.getCurrState());
		}
		
		return op; 
	}
	
}
