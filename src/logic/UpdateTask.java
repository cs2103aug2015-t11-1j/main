package logic;

import java.util.ArrayList;

import storage.Output;

public class UpdateTask implements Command {
	
	private int index;
	private String eventTask;
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	
	/***********CONSTRUCTOR**********/
	@Override
	public Output execute() {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

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
}
