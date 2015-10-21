package logic;

import storage.Output;

public class SearchTask implements Command {
	
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
	
	/**********  GETTER   **********/
	public String getEventTask() {
		return eventTask;
	}

	/**********  SETTER   **********/
	public void setEventTask(String eventTask) {
		this.eventTask = eventTask;
	}

	@Override
	public void setCurrState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isMutator(Command task) {
		// TODO Auto-generated method stub
		return false;
	}
}
