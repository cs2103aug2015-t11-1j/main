package logic;

import java.util.ArrayList;

import storage.Output;

public class SetFilePathTask implements Command {
	private State currState = new State(new ArrayList<Task>());
	private String newFilePath;
	
	public SetFilePathTask() {
		
	}

	@Override
	public Output execute() {
		Session.sto.setFilePath(this.newFilePath);
		return new Output(true, newFilePath, "cfp");
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
		
	@Override
	public boolean isMutator(Command task) {
		return true;
	}

}
