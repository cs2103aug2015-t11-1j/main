package planit;

import java.util.ArrayList;

public class Command {

	public enum ACTION_TYPE {
		ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO, INVALID;
	}

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;

	private static final int RANGE_ARRAY_SIZE = 2;

	private ACTION_TYPE type;
	private static StringParser sp;

	private String userStringInput;

	private String userCommand = null;

	private String userEventTask = null;

	private String userDate = null;
	private String[] userDateRange = new String[RANGE_ARRAY_SIZE];

	private String userTime = null;
	private String[] userTimeRange = new String[RANGE_ARRAY_SIZE];

	private static ACTION_TYPE getActionType(String userAction) {
		if (userAction.equalsIgnoreCase("add")) {
			return ACTION_TYPE.ADD;
		} else if (userAction.equalsIgnoreCase("show")) {
			return ACTION_TYPE.SHOW;
		} else if (userAction.equalsIgnoreCase("search")) {
			return ACTION_TYPE.SEARCH;
		} else if (userAction.equalsIgnoreCase("update")) {
			return ACTION_TYPE.UPDATE;
		} else if (userAction.equalsIgnoreCase("done")) {
			return ACTION_TYPE.DONE;
		} else if (userAction.equalsIgnoreCase("delete")) {
			return ACTION_TYPE.DELETE;
		} else if (userAction.equalsIgnoreCase("undo")) {
			return ACTION_TYPE.UNDO;
		} else {
			return ACTION_TYPE.INVALID;
		}
	}

	public Command(String userStringInput) {
		this.userStringInput = userStringInput;
		executeAction(userStringInput);
	}

	private static void executeAction(String userStringInput) {
		sp = new StringParser();
		ACTION_TYPE actionType = getActionType(sp.extractUserCommand(userStringInput));

		switch (actionType) {
		case ADD:
			break;
		case SHOW:
			break;
		case SEARCH:
			break;
		case UPDATE:
			break;
		case DONE:
			break;
		case DELETE:
			break;
		case UNDO:
			break;
		default:
			break;
		}
	}

	/*
	 * ACCESSORS
	 * 
	 * Used by :logic to determine what to do with the <event>, <date> and
	 * <time> inputs
	 * 
	 */
	public ACTION_TYPE getActionType() {
		return type;
	}

	public String getUserCommand() {
		return userCommand;
	}

	public String getUserEventTask() {
		return userEventTask;
	}

	public String getUserDate() {
		return userDate;
	}

	public String getUserDateStart() {
		return userDateRange[INDEX_FIRST];
	}

	public String getUserDateEnd() {
		return userDateRange[INDEX_SECOND];
	}

	public String getUserTime() {
		return userTime;
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
	// TODO: all methods listen below needs fixing
	public void setUserEventTask() {
		userEventTask = sp.extractUserEventTask(userStringInput);
	}

	public void setUserDate() {
		ArrayList<String> stringArray = sp.splitStringIntoArrayDelimColon(userStringInput);
		userDate = sp.extractUserDate(sp.splitStringIntoArrayDelimSpace(stringArray.get(INDEX_SECOND)));
	}

	public void setUserTime() {
		ArrayList<String> stringArray = sp.splitStringIntoArrayDelimColon(userStringInput);
		userDate = sp.extractUserTime(sp.splitStringIntoArrayDelimSpace(stringArray.get(INDEX_SECOND)));
	}

	public void setUserDateRange() {

	}

	public void setUserTimeRange() {

	}
}
