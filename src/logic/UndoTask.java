package logic;

import storage.Output;

public class UndoTask implements Command {
	
	private State currState;

	public UndoTask() {
		
	}
	
	@Override
	public Output execute() {
		if(Session.undoStack.size() == 1){
			return new Output(false, "Nothing to undo", "undo");
		}
		State s = Session.undoStack.pop();
		Session.redoStack.push(s);
		this.setCurrState(Session.getUndoStack().pop());
		this.currState.sort();
		return new Output(true,"Undo done", "undo");
	}

	@Override
	public boolean isMutator(Command task) {
		return true;
	}

	@Override
	public void setCurrState(State state) {
		this.currState = new State(state);
	}

	@Override
	public State getCurrState() {
		return this.currState;
	}

}
