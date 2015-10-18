package planit;

import java.util.ArrayList;

public class UpdateTask implements Command {

	private String userInput;
	private String eventTask;
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	
	/***********CONSTRUCTOR**********/
	public UpdateTask(String str) {
		this.userInput = str;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void parse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	/**********  GETTER   **********/
	public String getUserInput() {
		return userInput;
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
	public void setUserInput(String userInput) {
		this.userInput = userInput;
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
