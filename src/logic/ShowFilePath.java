//@@author A0130383N

package logic;

import java.util.ArrayList;

import storage.Output;

public class ShowFilePath implements Command {

	private static final String MESSAGE_TASK_TYPE = "fp";

	private State currState = new State(new ArrayList<Task>());

	/*********** CONSTRUCTOR **********/
	public ShowFilePath() {

	}

	@Override
	public Output execute() {
		String str = Session.sto.getFilePath();
		return new Output(true, str, MESSAGE_TASK_TYPE);
	}

	@Override
	public boolean isMutator(Command task) {
		return false;
	}

	/********** GETTER **********/
	@Override
	public State getCurrState() {
		return currState;
	}

	/********** SETTER **********/
	@Override
	public void setCurrState(State state) {
		currState = state;
	}

}
