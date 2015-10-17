package planit;

import java.util.Stack;

import planit.ActionParser.ACTION_TYPE;

public class ExecuteCommand {
	
	private static ExecuteCommand ec;
	private static Stack<Command> redoStack = new Stack<Command>();
	private static Stack<Command> undoStack = new Stack<Command>();
	
	private ExecuteCommand() {
		
	}

	public static synchronized void initExecuteCommand() {
		if (ec.equals(null)) {
			ec = new ExecuteCommand();
		}
	}

	public static synchronized ExecuteCommand getInstance() {
		
		if (ec.equals(null)) {
			ec = new ExecuteCommand();
		}
		return ec;
		
	}
	
	public static Stack<Command> getUndoStack() {
		return undoStack;
	}

	public static Stack<Command> getRedoStack() {
		return redoStack;
	}

	public static void setUndoStack(Stack<Command> undoStack) {
		ExecuteCommand.undoStack = undoStack;
	}
	
	public static void setRedoStack(Stack<Command> redoStack) {
		ExecuteCommand.redoStack = redoStack;
	}

	public void executeCommand(ACTION_TYPE userAction, String userInput) {
		// TODO Auto-generated method stub
		
	}
}
