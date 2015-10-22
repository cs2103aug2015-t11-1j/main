package logic;

import storage.Output;

public class DoneTask implements Command {
	
	private int index;
	
	/***********CONSTRUCTOR**********/
	public DoneTask() {

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
	public int getIndex() {
		return index;
	}
	
	/**********  SETTER   **********/
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public boolean isMutator(Command task) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCurrState(State state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public State getCurrState() {
		// TODO Auto-generated method stub
		return null;
	}
}
