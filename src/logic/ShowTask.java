package logic;

import java.util.ArrayList;

import storage.Output;
import storage.Storage;

public class ShowTask implements Command {
	private String date;
	private boolean showDone = false;
	private boolean showFloat = false;
	private State currState;
	
	/***********CONSTRUCTOR**********/
	public ShowTask() {
		
	}
	
	@Override
	public Output execute() {
		ArrayList<Task> list = currState.getTaskList();
		ArrayList<Task> dateTasks = new ArrayList<Task>();
		if(showFloat){
			
		}
		if(showDone){
			
		}
		else {
			for(Task t : list){
				if(t.getDate().contains(this.date)){
					dateTasks.add(t);
				}
			}	
		}
		return new Output(true, dateTasks, "show");
	}

	@Override
	public boolean isMutator(Command task) {
		if (task instanceof ShowTask) {
			return false;
		} else {
			return true;
		}
	}
	
	/**********  GETTER   **********/
	public String getDate() {
		return date;
	}

	@Override
	public State getCurrState() {
		return currState;
	}

	/**********  SETTER   **********/
	public void setDate(String str) {
		this.date = str;
	}
	
	@Override
	public void setCurrState(State state) {
		currState = state;
	}

	public boolean getShowDone() {
		return showDone;
	}
	
	public boolean getShowFloat() {
		return showFloat;
	}

	public void setShowDone() {
		showDone = true;
	}

	public void setShowFloat() {
		showFloat = true;
	}
	
}
