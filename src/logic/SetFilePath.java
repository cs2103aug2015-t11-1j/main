//@@author: idawatibustan A0130383N

package logic;

import java.util.ArrayList;

import storage.Output;

public class SetFilePath implements Command {

	private static final String MESSAGE_TASK_TYPE = "cfp";

	private State currState = new State(new ArrayList<Task>());
	private String newFilePath;

	/*********** CONSTRUCTOR **********/
	public SetFilePath() {

	}

	@Override
	public Output execute() {
		String str = Session.sto.setFilePath(this.newFilePath);
		boolean stats = str.equals(this.newFilePath);
		return new Output(stats, str, MESSAGE_TASK_TYPE);
	}

	@Override
	public boolean isMutator(Command task) {
		return true;
	}

	/********** GETTER **********/
	public String getFilePath() {
		return this.newFilePath;
	}

	@Override
	public State getCurrState() {
		return currState;
	}

	/********** SETTER **********/
	public void setFilePath(String filePath) {
		this.newFilePath = filePath;
	}

	@Override
	public void setCurrState(State state) {
		this.currState = state;
	}

}
