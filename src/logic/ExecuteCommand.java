package logic;

import java.util.Stack;

import parser.ActionParser;
import parser.ActionParser.ACTION_TYPE;
import storage.Output;
import ui.Welcome;

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

	public Output executeCommand(ACTION_TYPE userAction, String userInput) {
		Output op = null;
		switch(userAction) {
		case ADD:
			AddTask addTask = new AddTask(userInput);
			addTask.parse();
			op = addTask.execute();
			undoStack.push(addTask);
			return op;
		case SHOW:
			ShowTask showTask = new ShowTask(userInput);
			showTask.parse();
			op = showTask.execute();
			return op;
		case SEARCH:
			SearchTask searchTask = new SearchTask(userInput);
			searchTask.parse();
			op = searchTask.execute();
			return op;
		case UPDATE:
			UpdateTask updateTask = new UpdateTask(userInput);
			updateTask.parse();
			op = updateTask.execute();
			undoStack.push(updateTask);
			return op;
		case DONE:
			DoneTask doneTask = new DoneTask(userInput);
			doneTask.parse();
			op = doneTask.execute();
			undoStack.push(doneTask);
			return op;
		case DELETE:
			DeleteTask deleteTask = new DeleteTask(userInput);
			deleteTask.parse();
			op = deleteTask.execute();
			undoStack.push(deleteTask);
			return op;
		case HELP:
			Welcome.printHelp();
			break;
		case UNDO:
		//	Command taskToUndo = undoStack.pop();
			break;
		default:
			break;
		}
		return op;
	}
}
