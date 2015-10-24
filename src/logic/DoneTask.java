package logic;

import storage.Output;

public class DoneTask implements Command {
	private State currState;
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

	public void redo() {
		// TODO Auto-generated method stub
		
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
		currState = state;
		
	}
	
	@Override
	public boolean isMutator(Command task) {
		// TODO Auto-generated method stub
		return false;
	}


	

}
