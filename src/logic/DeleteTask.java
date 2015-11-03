package logic;

import storage.Output;

public class DeleteTask implements Command {
	private State currState;
	private int index;
	
	/***********CONSTRUCTOR**********/
	public DeleteTask() {
		
	}
	
	@Override
	public Output execute() {
		try {
			Task task = this.currState.getTaskList().remove(this.index-1);
			this.currState.sort();
			return new Output(true, task.toString(), "delete");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index unavailable");
			return new Output(false, "Index Out Of Bounds", "delete");
		}
	}
	
	/**********  GETTER   **********/
	public int getIndex() {
		return index;
	}
	
	@Override
	public State getCurrState() {
		return currState;
	}

	/**********  SETTER   **********/
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public void setCurrState(State state) {
		currState = new State(state);
		
	}
	
	@Override
	public boolean isMutator(Command task) {
		return true;
	}

}
