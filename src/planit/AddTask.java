package planit;

import java.util.ArrayList;

public class AddTask implements Command {

	private String userInput;
	private String eventTask;
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	
	public AddTask(String str) {
		this.userInput = str;
	}
	
	@Override
	public void execute() {
		
	}

	@Override
	public void parse() {
		eventTask = EventTaskParser.getEventTask(str);
		date = DateParser.extractDate(str);
		time = TimeParser.extractTime(str);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
}
