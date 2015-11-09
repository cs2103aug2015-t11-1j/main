// @@author A0125273L

package ui;

import java.util.ArrayList;
import java.util.Calendar;

import logic.Session;
import storage.Output;

import java.io.IOException;

public class Welcome {

	private static Calendar cal = Calendar.getInstance();
	Session session;

	/*********** CONSTRUCTOR **********/
	public Welcome() {
		this.session = new Session();
	}

	// This method takes Output from logic
	// and prints the list of tasks for today.
	public static String printMessageToday(Output op) {
		String message = "";
		ArrayList<String> msgList = new ArrayList<String>();
		
		if (op.getStatus() && op.getCmdType().toUpperCase().equals("SHOW") && !op.getResults().isEmpty()) {
			for (int i = 0; i < op.getResults().size(); i++) {
				String str = op.getResults().get(i).toString();
				msgList.add(str.substring(0, 3) + str.substring(12));
			}

			for (String s : msgList) {
				message += s + "\n";
			}

		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("SHOW")) {
			message = (Constants.MESSAGE_SHOW_NOTHING);
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("SHOW")) {
			message = (Constants.MESSAGE_SHOW_FAIL);
		}
		return message;
	}

	// This method takes Output from logic
	// and prints all the messages for different command inputs.
	public static String printMessage(Output op) {
		String message = "";
		ArrayList<String> msgList = new ArrayList<String>();

		switch (op.getCmdType().toUpperCase()) {
		case "ADD":
			if (op.getStatus()) {
				message = (op.getEntry() + Constants.MESSAGE_ADDED + "\n");
			} else {
				message = (Constants.MESSAGE_ADD_FAIL + "\n");
			}
			break;
		case "CFP":
			if (op.getStatus()) {
				message = op.getEntry() + Constants.MESSAGE_CFP + "\n";
			} else {
				message = Constants.MESSAGE_CFP_FAIL + "\n";
			}
			break;
		case "DELETE":
			if (op.getStatus()) {
				message = (op.getEntry() + Constants.MESSAGE_DELETED + "\n");
			} else {
				message = "Error! " + op.getEntry() + Constants.MESSAGE_DELETE_FAIL + "\n";
			}
			break;
		case "DONE":
			message = (Constants.MESSAGE_DONE + "\n");
			break;
		case "EXIT":
			System.exit(0);
			break;
		case "FP":
			if (op.getStatus()) {
				message = op.getEntry() + Constants.MESSAGE_SHOW_FP + "\n";
			} else {
				message = Constants.MESSAGE_SHOW_FP_FAIL + "\n";
			}
			break;
		case "HELP":
			if (op.getStatus()) {
				message = Constants.MESSAGE_HELP + "\n";
				msgList.add(Constants.COMMAND_ADD);
				msgList.add(Constants.COMMAND_CFP);
				msgList.add(Constants.COMMAND_CLEAR);
				msgList.add(Constants.COMMAND_DELETE);
				msgList.add(Constants.COMMAND_DONE);
				msgList.add(Constants.COMMAND_EXIT);
				msgList.add(Constants.COMMAND_FP);
				msgList.add(Constants.COMMAND_HELP);
				msgList.add(Constants.COMMAND_SEARCH);
				msgList.add(Constants.COMMAND_SHOW);
				msgList.add(Constants.COMMAND_UNDO);
				msgList.add(Constants.COMMAND_UPDATE);
				msgList.add(Constants.COMMAND_UNDONE);
				for (String s : msgList) {
					message += s + "\n";
				}
			}
			break;
		case "SEARCH":
			if (op.getStatus() && !op.getResults().isEmpty()) {
				for (int i = 0; i < op.getResults().size(); i++) {
					msgList.add(op.getResults().get(i).toString());
				}
				for (String s : msgList) {
					message += s + "\n";
				}

				message += Constants.MESSAGE_SEARCHED + "\n";

			} else if (op.getStatus()) {
				message = (Constants.MESSAGE_SEARCH_FAIL + "\n");
			}
			break;
		case "SHOW":
			if (op.getStatus() && !op.getResults().isEmpty()) {
				for (int i = 0; i < op.getResults().size(); i++) {
					msgList.add(op.getResults().get(i).toString());
				}

				for (String s : msgList) {
					message += s + "\n";
				}
			} else if (op.getStatus()) {
				message = (Constants.MESSAGE_SHOW_NOTHING + "\n");
			} else if (!op.getStatus()) {
				message = (Constants.MESSAGE_SHOW_FAIL + "\n");
			}
			break;
		case "SHOW DONE":
			if (op.getStatus() && !op.getResults().isEmpty()) {
				for (int i = 0; i < op.getResults().size(); i++) {
					msgList.add(op.getResults().get(i).toString());
				}
				for (String s : msgList) {
					message += s + "\n";
				}
			} else if (op.getStatus()) {
				message = Constants.MESSAGE_SHOW_NOTHING + "\n";
			}
			break;
		case "UNDO":
			if (op.getStatus()) {
				message = (Constants.MESSAGE_UNDO + "\n");
			}
			break;
		case "UPDATE":
			if (op.getStatus()) {
				message = (op.getEntry() + Constants.MESSAGE_UPDATED + "\n");
			} else {
				message = Constants.MESSAGE_UPDATE_FAIL + "\n";
			}
			break;
		case "UNDONE":
			if (op.getStatus()) {
				message = Constants.MESSAGE_UNDONE + "\n";
			}
			break;
		default:
			message = Constants.MESSAGE_ERROR + "\n";
			break;

		}

		return message + "\n";
	}

	// This method takes the user input and passes it to logic.
	public Output initiateProg(String userInput) throws IOException {
		Output op = null;

		op = session.executeCommand(userInput);

		return op;

	}

	// This method obtains the hour of the day and greets the user
	// accordingly.
	public String welcomeMessage() {
		String message = "";
		if (getMornNight() >= 4 && getMornNight() < 12) {
			message = Constants.MESSAGE_MORNING + "\n" + Constants.MESSAGE_PROMPT;
		} else if (getMornNight() >= 12 && getMornNight() < 18) {
			message = Constants.MESSAGE_AFTERNOON + "\n" + Constants.MESSAGE_PROMPT;
		} else {
			message = Constants.MESSAGE_EVENING + "\n" + Constants.MESSAGE_PROMPT;
		}
		return message;
	}

	// This method obtains the hour of the day.
	private static int getMornNight() {
		int i = cal.get(Calendar.HOUR_OF_DAY);
		return i;

	}

	// Prints a message for today's tasks.
	public String printToday() {
		String message = Constants.MESSAGE_TODAY;
		return message;
	}

}
