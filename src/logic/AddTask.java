package logic;

import java.util.ArrayList;

import parser.DateParser;
import parser.EventTaskParser;
import storage.Output;

public class AddTask implements Command {

	private String userInput;
	private String eventTask;
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	
	
	/***********CONSTRUCTOR**********/
	public AddTask(String str) {
		this.setUserInput(str);
	}
	
	@Override
	public Output execute() {
		// TODO
//		Output outputObject = Storage.storeNewEvent(StorageFormatter.formatAdd());
		return null;
	}

	@Override
	public void parse() {
		setEventTask(EventTaskParser.getEventTask(str));
		setDate(DateParser.extractDate(strArr));
		setTime(TimeParser.extractTime(strArr));
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
