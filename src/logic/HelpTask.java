//@@author A0122558E

package logic;

import storage.Output;

public class HelpTask implements Command {

	private static final String MESSAGE_TASK_TYPE = "help";
	private static final String MESSAGE_HELP = "Help";

	/*********** CONSTRUCTOR **********/
	public HelpTask() {

	}

	@Override
	public Output execute() {
		return new Output(true, MESSAGE_HELP, MESSAGE_TASK_TYPE);
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
