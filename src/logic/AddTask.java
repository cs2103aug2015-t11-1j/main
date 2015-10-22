package logic;

import java.util.ArrayList;

import storage.Output;

public class AddTask implements Command {

	private String eventTask;
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	private State currState = new State(new ArrayList<Task>());

	/*********** CONSTRUCTOR **********/
	public AddTask() {

	}

	@Override
	public Output execute() {
		Task task = createTask();
		this.currState.add(task);
		return new Output(true, task.toString(), "add");
	}

	private Task createTask() {
		// formatDate(date);
		// formatTime(time);
		
		try { 
			Task newTask = new Task(this.date.get(0), this.time.get(0), this.eventTask); 
			return newTask;
		} catch (NullPointerException e) {
			System.err.println(e.getMessage()); 
			return new Task(this.date.get(0), "", this.eventTask);
		}
		
	//	return new Task(this.date.get(0), this.time.get(0), this.eventTask);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	/********** GETTER **********/
	public String getEventTask() {
		return eventTask;
	}

	public ArrayList<String> getDate() {
		return date;
	}

	public ArrayList<String> getTime() {
		return time;
	}

	public State getCurrState() {
		return currState;
	}

	/********** SETTER **********/
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

	@Override
	public boolean isMutator(Command task) {
		if (task instanceof AddTask) {
			return true;
		} else {
			return false;
		}
	}

}
