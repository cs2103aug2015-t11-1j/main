package logic;

import java.util.ArrayList;

import storage.Output;

public class UpdateTask implements Command {
	
	
	private static final String MESSAGE_INDEX_OUT_OF_BOUNDS = "Index Out Of Bounds";
	private static final String MESSAGE_INDEX_UNAVAILABLE = "Index unavailable";
	private static final String MESSAGE_TASK_TYPE = "update";
	private static final String MESSAGE_SYMBOL_HYPHEN = "-";
	private static final String MESSAGE_SYMBOL_NOTHING = "";
	private static final int INT_ZERO = 0;
	private static final int INT_ONE = 1;
	private static final int INT_TWO = 2;

	private int index;
	private String eventTask;
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	private State currState;
	
	/***********CONSTRUCTOR**********/
	@Override
	public Output execute() {
		try {
			Task taskToUpdate = this.currState.getTaskList().get(index-INT_ONE);
			Task updatedTask = new Task(INT_ZERO, taskToUpdate.getStatus(), formatDate(), formatTime(), this.eventTask);
			updateCurrState(updatedTask);
			return new Output(true, updatedTask.toString(), MESSAGE_TASK_TYPE);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println(MESSAGE_INDEX_UNAVAILABLE);
			return new Output(false, MESSAGE_INDEX_OUT_OF_BOUNDS, MESSAGE_TASK_TYPE);
		}
	}

	private void updateCurrState(Task updatedTask) {
		this.currState.getTaskList().set(index-INT_ONE, updatedTask);
		this.currState.sort();
	}

	@Override
	public boolean isMutator(Command task) {
		return true;
	}
	
	public String formatDate() {
		if (date.size() == INT_TWO && date.get(INT_ONE).equals(MESSAGE_SYMBOL_NOTHING)) {
			return date.get(INT_ZERO);
		} else if (date.size() == INT_TWO && date.get(INT_ONE).equals(MESSAGE_SYMBOL_NOTHING)) {
			return date.get(INT_ZERO) + MESSAGE_SYMBOL_HYPHEN + date.get(INT_ONE);
		} else {
			return MESSAGE_SYMBOL_NOTHING;
		}
	}
	
	public String formatTime() {
		if (time.get(INT_ONE).equals(MESSAGE_SYMBOL_NOTHING)) {
			return time.get(INT_ZERO);
		} else if (time.size() == INT_TWO && !time.get(INT_ONE).equals(MESSAGE_SYMBOL_NOTHING)) {
			return time.get(INT_ZERO) + MESSAGE_SYMBOL_HYPHEN + time.get(INT_ONE);
		} else {
			return MESSAGE_SYMBOL_NOTHING;
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
		currState = new State(state);
	}
	
}
