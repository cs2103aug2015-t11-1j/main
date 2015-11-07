package logic;

import storage.Output;

public class UndoTask implements Command {
	
	private static final String MESSAGE_TASK_TYPE = "undo";
	private static final String MESSAGE_UNDO_DONE = "Undo done";
	private static final String MESSAGE_NOTHING_TO_UNDO = "Nothing to undo";
	
	private State currState;

	/***********CONSTRUCTOR**********/
	public UndoTask() {
		
	}
	
	@Override
	public Output execute() {
		if(Session.undoStack.size() == 1){
			return new Output(false, MESSAGE_NOTHING_TO_UNDO, MESSAGE_TASK_TYPE);
		}
		undo();
		return new Output(true, MESSAGE_UNDO_DONE, MESSAGE_TASK_TYPE);
	}

	private void undo() {
		State s = Session.undoStack.pop();
		Session.redoStack.push(s);
		this.setCurrState(Session.getUndoStack().pop());
		this.currState.sort();
	}

	@Override
	public boolean isMutator(Command task) {
		return true;
	}

	/**********  GETTER   **********/
	@Override
	public State getCurrState() {
		return this.currState;
	}
	
	/**********  SETTER   **********/
	@Override
	public void setCurrState(State state) {
		this.currState = new State(state);
	}


}
