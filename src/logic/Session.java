package logic;

import java.util.Stack;

import parser.Parser;
import storage.Output;
import storage.Storage;

public class Session {
	
	public static Stack<State> undoStack = new Stack<State>();
	public static Stack<State> redoStack = new Stack<State>();
	public static Storage sto = new Storage();
	
	public Session() {
		this.initialSetup();
	}
	
	public void initialSetup() {
		undoStack.push(sto.extractState());
	}
	
	public Output executeCommand(String userInput) {
		Command userCommand = Parser.setCommand(userInput);
		userCommand.setCurrState(undoStack.peek());
		Output op = userCommand.execute();
		
		if(userCommand.isMutator(userCommand)) {
			undoStack.push(userCommand.getCurrState());
			sto.update(userCommand.getCurrState());
		}
		
		return op; 
	}
	
}
