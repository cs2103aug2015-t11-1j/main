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
		switch(userAction) {
		case ADD:
			AddTask addTask = new AddTask(userInput);
			addTask.parse();
			addTask.execute();
			undoStack.push(addTask);
			break;
		case SHOW:
			ShowTask showTask = new ShowTask(userInput);
			showTask.parse();
			showTask.execute();
			break;
		case SEARCH:
			SearchTask searchTask = new SearchTask(userInput);
			searchTask.parse();
			searchTask.execute();
			break;
		case UPDATE:
			UpdateTask updateTask = new UpdateTask(userInput);
			updateTask.parse();
			updateTask.execute();
			undoStack.push(updateTask);
			break;
		case DONE:
			DoneTask doneTask = new DoneTask(userInput);
			doneTask.parse();
			doneTask.execute();
			undoStack.push(doneTask);
			break;
		case DELETE:
			DeleteTask deleteTask = new DeleteTask(userInput);
			deleteTask.parse();
			deleteTask.execute();
			undoStack.push(deleteTask);
			break;
		case HELP:
			Welcome.printHelp();
			break;
		case UNDO:
		//	Command taskToUndo = undoStack.pop();
			break;
		default:
			break;
		}
	}
}
