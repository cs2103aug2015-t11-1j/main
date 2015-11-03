package logic;

import java.util.Stack;

import parser.Parser;
import storage.Output;
import storage.Storage;

public class Session {
	
	private static Stack<State> undoStack = new Stack<State>();
	private static Stack<State> redoStack = new Stack<State>();
	static Storage sto = new Storage();
	private static Output todayTask;
	
	public Session() {
		this.initialSetup();
	}
	
	public void initialSetup() {
		State s = sto.extractState();
		s.sort();
		undoStack.push(s);
		this.updateToday();
	}
	
	public Output executeCommand(String userInput) {
		Command userCommand = Parser.setCommand(userInput);
		userCommand.setCurrState(undoStack.peek());
		Output op = userCommand.execute();
		
		if(userCommand.isMutator(userCommand)) {
			undoStack.push(userCommand.getCurrState());
			sto.update(userCommand.getCurrState());
			this.updateToday();
		}
		
		return op; 
	}
	
	public static Stack<State> getUndoStack() {
		return undoStack;
	}
	
	public static Stack<State> getRedoStack() {
		return redoStack;
	}

	public static Output getToday(){
		return todayTask;
	}
	
	private void updateToday(){
		todayTask = executeCommand("show today");
	}

}
