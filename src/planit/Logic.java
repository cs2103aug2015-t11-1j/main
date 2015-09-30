/* 
 * @author: Ishvinder Singh
 * 
 */

package planit;

public class Logic {

	public enum ACTION_TYPE {
		ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO, INVALID;
	}
	
	private static Command userCommand;
	
	private static ACTION_TYPE type;
	
	public Logic() {
		
	}
	
	public static void main(String[] args) {
		Welcome.welcomeMessage();
		String userInput = Welcome.requestInput();
		executeCommand(userInput);
	}

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
	
	
	
	private static void executeCommand(String userInput) {
		userCommand = new Command(userInput);
		type = getActionType(userInput);
		switch (type) {
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

}
