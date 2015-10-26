package logic;

import storage.Output;

public class ExitTask implements Command {

	public ExitTask() {
		
	}
	
	@Override
	public Output execute() {
		return new Output(false, "", "exit");
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isMutator(Command task) {
		return false;
	}

	@Override
	public void setCurrState(State state) {
		
	}

	@Override
	public State getCurrState() {
		return null;
	}



}
