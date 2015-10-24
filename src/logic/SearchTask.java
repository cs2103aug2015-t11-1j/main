package logic;

import storage.Output;

public class SearchTask implements Command {
	private State currState;
	private String eventTask;
	
	/***********CONSTRUCTOR**********/
	public SearchTask() {
		
	}
	
	@Override
	public Output execute() {
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	public void redo() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isMutator(Command task) {
		// TODO Auto-generated method stub
		return false;
	}

	/**********  GETTER   **********/
	public String getEventTask() {
		return eventTask;
	}

	@Override
	public State getCurrState() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**********  SETTER   **********/
	public void setEventTask(String eventTask) {
		this.eventTask = eventTask;
	}

	@Override
	public void setCurrState(State state) {
		// TODO Auto-generated method stub
		
	}

}
