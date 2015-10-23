package logic;

import java.util.ArrayList;

import storage.Output;
import storage.Storage;

public class ShowTask implements Command {
	
	private String date;
	
	/***********CONSTRUCTOR**********/
	public ShowTask() {
		
	}
	
	@Override
	public Output execute() {
		// TODO Auto-generated method stub
		ArrayList<Task> dateTasks = Storage.showToday(this.getDate());
		return new Output(true, dateTasks, "show");
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
	
	/**********  GETTER   **********/
	public String getDate() {
		return date;
	}
	
	/**********  SETTER   **********/
	public void setDate(String str) {
		this.date = str;
	}

	@Override
	public boolean isMutator(Command task) {
		if (task instanceof ShowTask) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setCurrState(State state) {
	//	currState = state;
	}

	@Override
	public State getCurrState() {
		return null;
	}
	
}
