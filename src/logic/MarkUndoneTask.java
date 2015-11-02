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
		Task task = this.currState.getTaskList().remove(this.index-1);
		task.markUndone();
		this.currState.add(task);
		this.currState.sort();
		return new Output(true, task.toString(), "done");
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
