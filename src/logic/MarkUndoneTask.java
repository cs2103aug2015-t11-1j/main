package logic;

import storage.Output;

public class MarkUndoneTask implements Command {
	private State currState;
	private int index;

	/***********CONSTRUCTOR**********/
	public MarkUndoneTask() {
		
	}
	
	@Override
	public Output execute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrState(State state) {
		this.currState = state;

	}

	@Override
	public State getCurrState() {
		return currState;
	}

	@Override
	public boolean isMutator(Command task) {
		return true;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}

}
