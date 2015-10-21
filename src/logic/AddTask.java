package logic;

import java.util.ArrayList;

import storage.Output;

public class AddTask implements Command {

	private String eventTask;
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	private State currState;
	
	
	/***********CONSTRUCTOR**********/
	public AddTask() {
	
	}
	
	@Override
	public Output execute() {
		Task addTask = createTask();
		this.currState.add(addTask);
		Output addOutput = new Output(true, this.eventTask);
		return addOutput;
	}

	private Task createTask() {
		return new Task(this.date.get(0), this.time.get(0), this.eventTask);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	/**********  GETTER   **********/
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
	
	/**********  SETTER   **********/
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
	public void setCurrState() {
		currState = Session.undoStack.peek();
	}

	
	@Override
	public boolean isMutator(Command task) {
		
		if (task instanceof AddTask){
			return true;
		} else {
			return false;
		}
	}

}
