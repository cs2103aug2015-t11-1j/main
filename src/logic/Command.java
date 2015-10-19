package logic;

import storage.Output;

public interface Command {
	
	Output execute();
	void undo();
}
