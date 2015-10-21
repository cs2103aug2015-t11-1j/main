package logic;

import storage.Output;

public interface Command {
	
	State currState = null;
	Output execute();
	void undo();
	void setCurrState();
	boolean isMutator(Command task);
}
