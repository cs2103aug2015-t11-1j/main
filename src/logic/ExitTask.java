//@@author A0122558E

package logic;

import storage.Output;

public class ExitTask implements Command {

	private static final String MESSAGE_TASK_TYPE = "exit";
	private static final String MESSAGE_EXIT_PROGRAM = "Exit Program";

	/*********** CONSTRUCTOR **********/
	public ExitTask() {

	}

	@Override
	public Output execute() {
		return new Output(false, MESSAGE_EXIT_PROGRAM, MESSAGE_TASK_TYPE);
	}

	@Override
	public boolean isMutator(Command task) {
		return false;
	}

	/********** GETTER **********/
	@Override
	public State getCurrState() {
		return null;
	}

	/********** SETTER **********/
	@Override
	public void setCurrState(State state) {

	}
}
