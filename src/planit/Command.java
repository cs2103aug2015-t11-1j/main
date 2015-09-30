package planit;

public class Command {

	

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;

	private static final int RANGE_ARRAY_SIZE = 2;

	private static StringParser sp = new StringParser();

	private String userStringInput;

	private String userCommand = null;

	private String userEventTask = null;

	private String[] userDateRange = new String[RANGE_ARRAY_SIZE];

	private String[] userTimeRange = new String[RANGE_ARRAY_SIZE];

	
	public Command(String userStringInput) {
		this.userStringInput = userStringInput;
		executeParsing(userStringInput);
	}

	private static void executeParsing(String userStringInput) {
		
	}


	/*
	 * ACCESSORS
	 * 
	 * Used by :logic to determine what to do with the <event>, <date> and
	 * <time> inputs
	 * 
	 */
	
	public String getUserCommand() {
		return userCommand;
	}

	public String getUserEventTask() {
		return userEventTask;
	}

	public String[] getUserDateRange() {
		return userDateRange;
	}

	public String getUserDateStart() {
		return userDateRange[INDEX_FIRST];
	}

	public String getUserDateEnd() {
		return userDateRange[INDEX_SECOND];
	}

	public String[] getUserTimeRange() {
		return userTimeRange;
	}

	public String getUserTimeStart() {
		return userTimeRange[INDEX_FIRST];
	}

	public String getUserTimeEnd() {
		return userTimeRange[INDEX_SECOND];
	}

	/*
	 * MUTATORS
	 * 
	 * Sets the relevant data to the attributes using methods from StringParser
	 * class
	 * 
	 */
	public void setUserCommand() {
		userCommand = sp.extractUserCommand(userStringInput);
	}
	
	public void setUserEventTask() {
		userEventTask = sp.extractUserEventTask(userStringInput);
	}
	
	public void setUserDate() {
		userDateRange = sp.extractUserDate(userStringInput);
	}
	
	public void setUserTime() {
		userTimeRange = sp.extractUserTime(userStringInput);
	}
	
}
