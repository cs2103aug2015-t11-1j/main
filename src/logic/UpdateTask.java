package logic;

import java.util.ArrayList;

import storage.Output;

public class UpdateTask implements Command {
	
	private int index;
	private String eventTask;
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	private State currState;
	
	/***********CONSTRUCTOR**********/
	@Override
	public Output execute() {
		try {
			Task taskToUpdate = this.currState.getTaskList().get(index-1);
			Task updatedTask = new Task(0, taskToUpdate.getStatus(), formatDate(), formatTime(), this.eventTask);
			this.currState.getTaskList().set(index-1, updatedTask);
			this.currState.sort();
			return new Output(true, updatedTask.toString(), "update");
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index unavailable");
			return new Output(false, "Index Out Of Bounds", "update");
		}
	}

	@Override
	public boolean isMutator(Command task) {
		if (task instanceof UpdateTask) {
			return true;
		} else {
			return false;
		}
	}
	
	/**********  GETTER   **********/
	public int getIndex() {
		return index;
	}
	
	public String getEventTask() {
		return eventTask;
	}
	
	public ArrayList<String> getDate() {
		return date;
	}

	public ArrayList<String> getTime() {
		return time;
	}

	@Override
	public State getCurrState() {
		return this.currState;
	}

	/**********  SETTER   **********/
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setEventTask(String eventTask) {
		this.eventTask = eventTask;
	}

	public void setDate(ArrayList<String> date) {
		this.date = date;
	}

	public void setTime(ArrayList<String> time) {
		this.time = time;
	}
	
	@Override
	public void setCurrState(State state) {
		currState = state;
	}
	
	public String formatDate() {
		if (date.size() == 2 && date.get(1).equals("")) {
			return date.get(0);
		} else if (date.size() == 2 && date.get(1).equals("")) {
			return date.get(0) + "-" + date.get(1);
		} else {
			return "";
		}
	}
	
	public String formatTime() {
		if (time.get(1).equals("")) {
			return time.get(0);
		} else if (time.size() == 2 && !time.get(1).equals("")) {
			return time.get(0) + "-" + time.get(1);
		} else {
			return "";
		}
	}
}
