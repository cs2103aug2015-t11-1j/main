package ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import logic.Session;
import storage.Output;
import logic.State;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Welcome {


	private static DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Calendar cal = Calendar.getInstance();
	private static Scanner sc;
	Session session;

	public Welcome() {
		this.session = new Session();
	}
	public String printResults(Output op) {
		String message = "";

		if (op.getStatus() && op.getCmdType().toUpperCase().equals("ADD")) {
			message = Constants.MESSAGE_SUCCESS;
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("ADD")) {
			message = Constants.MESSAGE_FAIL;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("DELETE")) {
			message = Constants.MESSAGE_SUCCESS;
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("DELETE")) {
			message = Constants.MESSAGE_FAIL;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("DONE")) {
			message = Constants.MESSAGE_SUCCESS;
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("DONE")) {
			message = Constants.MESSAGE_FAIL;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("SEARCH")) {
			message = Constants.MESSAGE_SUCCESS;
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("SEARCH")) {
			message = Constants.MESSAGE_FAIL;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("SHOW")) {
			message = Constants.MESSAGE_SUCCESS;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("SHOW")) {
			message = Constants.MESSAGE_FAIL;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("UPDATE")) {
			message = Constants.MESSAGE_SUCCESS;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("UPDATE")) {
			message = Constants.MESSAGE_FAIL;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("CFP")) {
			message = Constants.MESSAGE_SUCCESS;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("CFP")) {
			message = Constants.MESSAGE_FAIL;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("FP")) {
			message = Constants.MESSAGE_SUCCESS;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("FP")) {
			message = Constants.MESSAGE_FAIL;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("UNDO")) {
			message = Constants.MESSAGE_SUCCESS;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("UNDO")) {
			message = Constants.MESSAGE_FAIL;
		}

		return message;
	}

	public String printToday(Output op) {
		String message = "";
		ArrayList<String> msgList = new ArrayList<String>();

		for (int i = 0; i < op.getResults().size(); i++) {
			msgList.add(op.getResults().get(i).toString());
		}

		for (String s : msgList) {
			message += s + "\n";
		}
		return message;

	}

	public static String printMessage(Output op) {
		String message = "";
		ArrayList<String> msgList = new ArrayList<String>();

		if (op.getStatus() && op.getCmdType().toUpperCase().equals("ADD")) {
			message = (op.getEntry() + Constants.MESSAGE_ADDED);
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("ADD")) {
			message = (Constants.MESSAGE_ADD_FAIL);
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("DELETE")) {
			message = (op.getEntry() + Constants.MESSAGE_DELETED);
		} // Not wokring if i type "delete name of event"
		else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("DELETE")) {
			message = (Constants.MESSAGE_DELETE_FAIL);
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("SEARCH")) {
			// printMsg(Constants.MESSAGE_SUCCESS);
			for (int i = 0; i < op.getResults().size(); i++) {
				msgList.add(op.getResults().get(i).toString());
			}
			for (String s : msgList) {
				message += s + "\n";
			}

			message += Constants.MESSAGE_SEARCHED;
		}
		// Not working yet.
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("SEARCH") && op.getResults().isEmpty()) {
			message = (Constants.MESSAGE_SEARCH_FAIL);
		}
		// Show is not working yet.
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("SHOW")) {
			// printMsg(Constants.MESSAGE_SHOW);
			for (int i = 0; i < op.getResults().size(); i++) {
				msgList.add(op.getResults().get(i).toString());
			}
			message = Constants.MESSAGE_SHOW + "\n";

			for (String s : msgList) {
				message += s + "\n";
			}

		} else if (op.getStatus() && op.getResults().isEmpty() && op.getCmdType().toUpperCase().equals("SHOW") ) {
			message = (Constants.MESSAGE_SHOW_NOTHING);
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("SHOW")) {
			message = (Constants.MESSAGE_SHOW_FAIL);
		}
		// Not yet
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("DONE")) {
			message = (Constants.MESSAGE_DONE);
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("HELP")) {
			message = Constants.MESSAGE_HELP + "\n";
			msgList.add(Constants.COMMAND_DELETE);
			msgList.add(Constants.COMMAND_ADD);
			msgList.add(Constants.COMMAND_DONE);
			msgList.add(Constants.COMMAND_EXIT);
			msgList.add(Constants.COMMAND_SEARCH);
			msgList.add(Constants.COMMAND_SHOW);
			msgList.add(Constants.COMMAND_UNDO);
			msgList.add(Constants.COMMAND_UPDATE);
			msgList.add(Constants.COMMAND_EXIT);
			msgList.add(Constants.COMMAND_HELP);

			for (String s : msgList) {
				message += s + "\n";
			}
		}
		// Not yet
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("UNDO")) {
			message = (Constants.MESSAGE_UNDO);
		}
		// Not yet
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("UPDATE")) {
			message = (op.getEntry() + Constants.MESSAGE_UPDATED);
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("UPDATE")) {
			message = Constants.MESSAGE_UPDATE_FAIL;
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("EXIT")) {
			// message = Constants.MESSAGE_EXIT;
			System.exit(0);
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("CFP")) {
			message = op.getEntry() + Constants.MESSAGE_CFP;
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("CFP")) {
			message = Constants.MESSAGE_CFP_FAIL;
		} else if (op.getStatus() && op.getCmdType().toUpperCase().equals("FP")) {
			message = op.getEntry() + Constants.MESSAGE_SHOW_FP;
		} else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("FP")) {
			message = Constants.MESSAGE_SHOW_FP_FAIL;
		} else {
			message = Constants.MESSAGE_ERROR;
		}
		return message;
	}

	public Output initiateProg(String userInput) throws IOException {
		Output op = null;

		op = session.executeCommand(userInput);
		
		//return message;
		return op;

	}

	public String getResults(String userInput) throws IOException {
		Session session = new Session();
		Output op = null;
		String message = "";

		op = session.executeCommand(userInput);
		message = printResults(op);
		// printMsg(Constants.MESSAGE_PROMPT);

		return message;

	}

	public String showToday(String userInput) throws IOException {
		Output op = null;
		String message = "";

		op = session.executeCommand(userInput);
		message = printToday(op);
		// printMsg(Constants.MESSAGE_PROMPT);

		return message;
	}

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
		// printMsg(message);
		// printMsg(Constants.MESSAGE_PROMPT);
	}

	public String requestInput() {
		sc = new Scanner(System.in);
		String userInput = null;
		try {
			userInput = sc.nextLine();
		} catch (IllegalArgumentException e) {
			System.out.println("Wrong user input!" + e);
		}
		return userInput;

	}

	private static int getMornNight() {
		int i = cal.get(Calendar.HOUR_OF_DAY);
		return i;

	}

	public String printToday() {
		String message = Constants.MESSAGE_TODAY;
		return message;
	}
	/**
	 * private static int getMornNight() { int i =
	 * cal.get(Calendar.HOUR_OF_DAY); return i;
	 * 
	 * }
	 * 
	 * private static void printMsg(String message) {
	 * System.out.println(message); }
	 * 
	 * public static void printAddedEvent(String addedTask) {
	 * printMsg(Constants.MESSAGE_SUCCESS + addedTask +
	 * Constants.MESSAGE_ADDED);
	 * 
	 * }
	 * 
	 * public static void printShowEvent(ArrayList<String> eventToShow) {
	 * ArrayList<String> message = new ArrayList<String>();
	 * 
	 * for (int i = 0; i < eventToShow.size(); i++) {
	 * message.add(eventToShow.get(i)); }
	 * 
	 * 
	 * }
	 * 
	 * public static void printSearchEvent(ArrayList<String> searchedEvent) { if
	 * (searchedEvent.isEmpty()) { printMsg(Constants.MESSAGE_SEARCH_FAIL); }
	 * else { printMsg(Constants.MESSAGE_SUCCESS); for (int i = 0; i <
	 * searchedEvent.size(); i++) { printMsg(searchedEvent.get(i)); }
	 * printMsg(Constants.MESSAGE_SEARCHED);
	 * 
	 * } }
	 * 
	 * public static void printDeletedTask(ArrayList<String> deletedTask) { if
	 * (deletedTask.isEmpty()) { printMsg(Constants.MESSAGE_DELETE_FAIL); } else
	 * { printMsg(Constants.MESSAGE_SUCCESS); for (int i = 0; i <
	 * deletedTask.size(); i++) { printMsg(deletedTask.get(i)); }
	 * printMsg(Constants.MESSAGE_DELETED); } }
	 * 
	 * public static void printUpdatedEvent(ArrayList<String> updatedEvent) { if
	 * (updatedEvent.isEmpty()) { printMsg(Constants.MESSAGE_UPDATE_FAIL); }
	 * else { printMsg(Constants.MESSAGE_SUCCESS); for (int i = 0; i <
	 * updatedEvent.size(); i++) { printMsg(updatedEvent.get(i)); } }
	 * printMsg(Constants.MESSAGE_UPDATED); }
	 * 
	 * public static void printCompletedTask(ArrayList<String> completedTask) {
	 * 
	 * printMsg(Constants.MESSAGE_SUCCESS); for (int i = 0; i <
	 * completedTask.size(); i++) { printMsg(completedTask.get(i)); }
	 * printMsg(Constants.MESSAGE_COMPLETED); }
	 * 
	 * public static void printHelp() { printMsg(Constants.MESSAGE_HELP);
	 * printMsg(Constants.COMMAND_ADD); printMsg(Constants.COMMAND_DELETE);
	 * printMsg(Constants.COMMAND_SHOW); printMsg(Constants.COMMAND_UPDATE);
	 * printMsg(Constants.COMMAND_UNDO); printMsg(Constants.COMMAND_SEARCH);
	 * printMsg(Constants.COMMAND_DONE); printMsg(Constants.COMMAND_HELP);
	 * printMsg(Constants.COMMAND_EXIT); }
	 **/
}
