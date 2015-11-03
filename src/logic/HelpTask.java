package logic;

import storage.Output;

public class HelpTask implements Command {

	public HelpTask() {
		
	}
	
	@Override
	public Output execute() {
		return new Output(true, "Help", "help"); 
	}

	@Override
	public boolean isMutator(Command task) {
		if (task instanceof HelpTask) {
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

}
