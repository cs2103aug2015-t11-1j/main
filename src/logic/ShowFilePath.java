package logic;

import java.util.ArrayList;

import storage.Output;

public class ShowFilePath implements Command {
	private State currState = new State(new ArrayList<Task>());

	public ShowFilePath() {

	}

	@Override
	public Output execute() {
		String str = Session.sto.getFilePath();
		return new Output(true, str, "fp");
	}

	@Override
	public State getCurrState() {
		return currState;
	}

	@Override
	public void setCurrState(State state) {
		currState = state;
	}

	@Override
	public boolean isMutator(Command task) {
			return false;
	}

}
