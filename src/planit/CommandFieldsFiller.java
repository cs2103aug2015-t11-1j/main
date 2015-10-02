package planit;

public class CommandFieldsFiller {
	
	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;
	
	private String userCommand;
	private String userEventTask;
	private String[] userDateRange;
	private String[] userTimeRange;
	/*
	 * CONSTRUCTOR
	 */
	public CommandFieldsFiller(Command command) {
		this.userCommand = command.getUserCommand();
		this.userEventTask = command.getUserEventTask();
		this.userDateRange = command.getUserDateRange();
		this.userTimeRange = command.getUserTimeRange();
	}
	
	public void checkDateRange() {
		if (userDateRange[INDEX_FIRST].equals(null) && !userTimeRange[INDEX_FIRST].equals(null)) {
			// TODO Insert today's date into the first index of userDateRange
		}
	}
}
