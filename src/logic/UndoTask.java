package logic;

import storage.Output;

public class UndoTask implements Command {
	
	private State currState;

	public UndoTask() {
		
	}
	
	@Override
	public Output execute() {
		State s = Session.getUndoStack().pop();
		Session.getRedoStack().push(s);
		this.setCurrState(s);
		return new Output(true,"undo done", "undo");
	}

	@Override
	public boolean isMutator(Command task) {
		return true;
	}

	@Override
	public void setCurrState(State state) {
		this.currState = state;
	}

	@Override
	public State getCurrState() {
		return this.currState;
	}

}
