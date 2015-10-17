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
		// TODO
//		Storage.storeNewEvent(StorageFormatter.formatAdd());
	}

	@Override
	public void parse() {
		eventTask = EventTaskParser.extractEventTask(str);
		date = DateParser.extractDate(strArr);
		time = TimeParser.extractTime(strArr);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
}
