package logic;

import storage.Output;

public interface Command {
	
	State currState = null;
	Output execute();
	void undo();
	void redo();
	void setCurrState(State state);
	State getCurrState();
	boolean isMutator(Command task);
}
