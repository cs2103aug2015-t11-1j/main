//@@author A0122558E

package logic;

import java.util.ArrayList;

import storage.Output;

public class ShowTask implements Command {

	private static final String MESSAGE_SYMBOL_NOTHING = "";
	private static final String MESSAGE_SYMBOL_DONE_TASK = "@ ";
	private static final String MESSAGE_TASK_TYPE_SHOW = "show";
	private static final String MESSAGE_TASK_TYPE_SHOW_DONE = "show done";

	private String date;
	private boolean showDone = false;
	private boolean showFloat = false;
	private State currState;

	/*********** CONSTRUCTOR **********/
	public ShowTask() {

	}

	@Override
	public Output execute() {
		ArrayList<Task> list = currState.getTaskList();
		ArrayList<Task> dateTasks = new ArrayList<Task>();
		if (showFloat || showDone) {
			if (showFloat) {
				checkTaskDate(list, dateTasks);
			}
			if (showDone) {
				checkTaskStatus(list, dateTasks);
				return new Output(true, dateTasks, MESSAGE_TASK_TYPE_SHOW_DONE);
			}
		} else {
			checkTaskDateStatus(list, dateTasks);
		}
		return new Output(true, dateTasks, MESSAGE_TASK_TYPE_SHOW);
	}

	private void checkTaskDateStatus(ArrayList<Task> list, ArrayList<Task> dateTasks) {
		for (Task t : list) {
			if (t.getDate().contains(this.date) && !t.getStatus().equals(MESSAGE_SYMBOL_DONE_TASK)) {
				dateTasks.add(t);
			}
		}
	}

	private void checkTaskStatus(ArrayList<Task> list, ArrayList<Task> dateTasks) {
		for (Task t : list) {
			if (t.getStatus().equals(MESSAGE_SYMBOL_DONE_TASK)) {
				dateTasks.add(t);
			}
		}
	}

	private void checkTaskDate(ArrayList<Task> list, ArrayList<Task> dateTasks) {
		for (Task t : list) {
			if (t.getDate().equals(MESSAGE_SYMBOL_NOTHING)) {
				dateTasks.add(t);
			}
		}
	}

	@Override
	public boolean isMutator(Command task) {
		return false;
	}

	/********** GETTER **********/
	public String getDate() {
		return date;
	}

	@Override
	public State getCurrState() {
		return currState;
	}

	public boolean getShowDone() {
		return showDone;
	}

	public boolean getShowFloat() {
		return showFloat;
	}

	/********** SETTER **********/
	public void setDate(String str) {
		this.date = str;
	}

	@Override
	public void setCurrState(State state) {
		currState = new State(state);
	}

	public void setShowDone() {
		showDone = true;
	}

	public void setShowFloat() {
		showFloat = true;
	}

}
