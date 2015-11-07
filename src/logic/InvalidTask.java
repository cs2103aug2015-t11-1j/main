package logic;

import storage.Output;

public class InvalidTask implements Command {

	private static final String MESSAGE_TASK_TYPE = "invalid";
	private static final String MESSAGE_INVALID_TASK = "Invalid Task";

	/***********CONSTRUCTOR**********/
	public InvalidTask() {
		
	}
	
	@Override
	public Output execute() {
		return new Output(false, MESSAGE_INVALID_TASK, MESSAGE_TASK_TYPE);
	}

	@Override
	public boolean isMutator(Command task) {
		return false;
	}

	/**********  GETTER   **********/
	@Override
	public State getCurrState() {
		return null;
	}
	
	/**********  SETTER   **********/
	@Override
	public void setCurrState(State state) {
		
	}
}