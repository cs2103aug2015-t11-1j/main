//@@author: idawatibustan A0130383N

package logic;

import storage.Output;

public class MarkDoneTask implements Command {

	private static final String MESSAGE_TASK_TYPE = "done";
	private static final int INDEX_ONE = 1;

	private State currState;
	private int index;

	/*********** CONSTRUCTOR **********/
	public MarkDoneTask() {

	}

	@Override
	public Output execute() {
		Task task = this.currState.getTaskList().remove(this.index - INDEX_ONE);
		task.markDone();
		updateCurrState(task);
		return new Output(true, task.toString(), MESSAGE_TASK_TYPE);
	}

	private void updateCurrState(Task task) {
		this.currState.add(task);
		this.currState.sort();
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