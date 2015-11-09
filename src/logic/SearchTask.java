//@@author A0122558E

package logic;

import java.util.ArrayList;

import storage.Output;

public class SearchTask implements Command {

	private static final String MESSAGE_TASK_TYPE = "search";

	private State currState;
	private String eventTask;

	/*********** CONSTRUCTOR **********/
	public SearchTask() {

	}

	@Override
	public Output execute() {
		ArrayList<Task> list = currState.getTaskList();
		ArrayList<Task> eventTasks = searchTaskList(list);
		return new Output(true, eventTasks, MESSAGE_TASK_TYPE);
	}

	private ArrayList<Task> searchTaskList(ArrayList<Task> list) {
		ArrayList<Task> eventTasks = new ArrayList<Task>();
		for (Task t : list) {
			if (t.getDetail().toLowerCase().contains(this.eventTask.toLowerCase())) {
				eventTasks.add(t);
			}
		}
		return eventTasks;
	}

	@Override
	public boolean isMutator(Command task) {
		return false;
	}

	/********** GETTER **********/
	public String getEventTask() {
		return eventTask;
	}

	@Override
	public State getCurrState() {
		return currState;
	}

	/********** SETTER **********/
	public void setEventTask(String eventTask) {
		this.eventTask = eventTask;
	}

	@Override
	public void setCurrState(State state) {
		currState = new State(state);
	}

}
