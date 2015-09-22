package planit;

public class Command {
	
	public enum actionType{
		ADD, SHOW, SEARCH, UPDATE, DONE, UNDO;
	}
	
	private actionType type;
	private String userCommand = null;
	
	private String userEventTask = null;
	
	private String userDate = null;
	private String[] userDateRange = new String[2];
	
	private String userTime = null;
	private String[] userTimeRange = new String[2];
	
	public Command() {
		
	}
}
