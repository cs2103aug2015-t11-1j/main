//@@author A0122558E

package logic;

import storage.Output;

public class DeleteTask implements Command {

	private static final String MESSAGE_INDEX_OUT_OF_BOUNDS = "Index Out Of Bounds";
	private static final String MESSAGE_INDEX_UNAVAILABLE = "Index unavailable";
	private static final String MESSAGE_TASK_TYPE = "delete";
	private static final int INDEX_ONE = 1;

	private State currState;
	private int index;

	/*********** CONSTRUCTOR **********/
	public DeleteTask() {

	}

	@Override
	public Output execute() {
		try {
			Task task = this.currState.getTaskList().remove(this.index - INDEX_ONE);
			this.currState.sort();
			return new Output(true, task.toString(), MESSAGE_TASK_TYPE);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(MESSAGE_INDEX_UNAVAILABLE);
			return new Output(false, MESSAGE_INDEX_OUT_OF_BOUNDS, MESSAGE_TASK_TYPE);
		}
	}

	@Override
	public boolean isMutator(Command task) {
		return true;
	}

	/********** GETTER **********/
	public int getIndex() {
		return index;
	}

	@Override
	public State getCurrState() {
		return currState;
	}

	/********** SETTER **********/
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public void setCurrState(State state) {
		currState = new State(state);

	}

}
