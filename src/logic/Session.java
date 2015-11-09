//@@ author A0122558E

package logic;

import java.util.Stack;

import parser.Parser;
import storage.Output;
import storage.Storage;

public class Session {

	private static final String MESSAGE_SHOW_TODAY = "show today";

	static Stack<State> undoStack = new Stack<State>();
	static Stack<State> redoStack = new Stack<State>();
	static Storage sto = new Storage();
	private static Output todayTask;

	/*********** CONSTRUCTOR **********/
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
		taskIsMutator(userCommand);
		return op;
	}

	private void taskIsMutator(Command userCommand) {
		if (userCommand.isMutator(userCommand)) {
			undoStack.push(userCommand.getCurrState());
			sto.update(userCommand.getCurrState());
			this.updateToday();
		}
	}

	private void updateToday() {
		todayTask = executeCommand(MESSAGE_SHOW_TODAY);
	}

	/********** GETTER **********/
	public static Stack<State> getUndoStack() {
		return undoStack;
	}

	public static Stack<State> getRedoStack() {
		return redoStack;
	}

	public Output getToday() {
		return todayTask;
	}

}
