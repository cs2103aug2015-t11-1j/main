package logic;

import storage.Output;

public class ClearList implements Command{
	
	/*********** CONSTRUCTOR **********/
	public ClearList() {

	}

	@Override
	public Output execute() {
		// TODO Auto-generated method stub
		String message = "";
		return new Output(true, message, "clear");
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

	@Override
	public boolean isMutator(Command task) {
		// TODO Auto-generated method stub
		return false;
	}
}
