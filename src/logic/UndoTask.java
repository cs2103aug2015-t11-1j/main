package logic;

import storage.Output;

public class UndoTask implements Command {
	
	private State currState;

	public UndoTask() {
		
	}
	
	@Override
	public Output execute() {
		State s = Session.undoStack.pop();
		Session.redoStack.push(s);
		this.setCurrState(Session.getUndoStack().peek());
		return new Output(true,"undo done", "undo");
	}

	@Override
	public boolean isMutator(Command task) {
		return false;
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
