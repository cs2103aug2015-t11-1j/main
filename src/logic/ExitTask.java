package logic;

import storage.Output;

public class ExitTask implements Command {

	public ExitTask() {
		
	}
	
	@Override
	public Output execute() {
		return new Output(false, "Exit Program", "exit");
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
