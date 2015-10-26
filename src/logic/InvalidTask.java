package logic;

import storage.Output;

public class InvalidTask implements Command {

	public InvalidTask() {
		
	}
	
	@Override
	public Output execute() {
		return new Output(false, "", "invalid");
	}

	@Override
	public boolean isMutator(Command task) {
		if (task instanceof InvalidTask) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void setCurrState(State state) {
		
	}

	@Override
	public State getCurrState() {
		return null;
	}
	
	@Override
	public void undo() {
	
	}
	
	public void redo() {

	}

}