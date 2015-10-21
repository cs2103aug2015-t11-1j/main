package logic;

import java.util.Stack;

import storage.Output;
import storage.Storage;

public class Session {
	
	private static Stack<State> undoStack = new Stack<State>();
	private static Stack<State> redoStack = new Stack<State>();
	
	public Session() {
		
	}
	
	public static State initialSetup() {
		undoStack.push(Storage.extractState());
	}
	
	public static Output executeCommand(String userInput) {
		return null; 
	}
	
	
}
