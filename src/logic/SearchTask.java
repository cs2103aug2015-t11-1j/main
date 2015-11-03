package logic;

import java.util.ArrayList;

import storage.Output;

public class SearchTask implements Command {
	private State currState;
	private String eventTask;

	/*********** CONSTRUCTOR **********/
	public SearchTask() {

	}

	@Override
	public Output execute() {
		ArrayList<Task> list = currState.getTaskList();
		ArrayList<Task> eventTasks = new ArrayList<Task>();
		for (Task t : list) {
			if (t.getDetail().toLowerCase().contains(this.eventTask.toLowerCase())) {
				eventTasks.add(t);
			}
		}
		return new Output(true, eventTasks, "search");
	}

	@Override
	public boolean isMutator(Command task) {
		if (task instanceof SearchTask) {
			return false;
		} else {
			return true;
		}
	}

	/********** GETTER **********/
	public String getEventTask() {
		return eventTask;
	}

	@Override
	public State getCurrState() {
		// TODO Auto-generated method stub
		return null;
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
