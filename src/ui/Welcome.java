package ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import logic.Session;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Welcome {
	
	// test comment

		private static DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Calendar cal = Calendar.getInstance();
	private static Scanner sc;

	public static void main(String[] args) throws IOException {
		initiateProg();

	}

	public static String initiateProg() throws IOException {
		String userInput = requestInput();
		Session session = new Session();
		
		while (!userInput.equals(Constants.COMMAND_EXIT)) {
			session.executeCommand(userInput);
			printMsg(Constants.MESSAGE_PROMPT);
			userInput = requestInput();
		}
		System.exit(0);
		return userInput; 
	}

	public static String welcomeMessage() {
		String message = "";
		
		if (getMornNight() >= 4 && getMornNight() < 12) {
			message = Constants.MESSAGE_MORNING;
		} else if (getMornNight() >= 12 && getMornNight() < 18) {
			message = Constants.MESSAGE_AFTERNOON;
		} else {
			message = Constants.MESSAGE_EVENING;
		}
		printMsg(Constants.MESSAGE_PROMPT);
		
		return message;
	}

	private static void printMsg(String message) {
		System.out.println(message);
	}

	public static String printToday() {
		String message = Constants.MESSAGE_TODAY;
		return message;
	}

	private static int getMornNight() {
		int i = cal.get(Calendar.HOUR_OF_DAY);
		return i;

	}

	public static String requestInput() {
		sc = new Scanner(System.in);
		String userInput = null;
		try {
			userInput = sc.nextLine();
		} catch (IllegalArgumentException e) {
			System.out.println("Wrong user input!" + e);
		}
		return userInput;

	}

	public static void printAddedEvent(String addedTask) {
		printMsg(Constants.MESSAGE_SUCCESS + addedTask + Constants.MESSAGE_ADDED);
		

	}

	public static void printShowEvent(ArrayList<String> eventToShow) {
		
		
		for (int i = 0; i < eventToShow.size(); i++) {
			printMsg(eventToShow.get(i));
		}
		
	
	}

	public static void printSearchEvent(ArrayList<String> searchedEvent) {
		if (searchedEvent.isEmpty()) {
			printMsg(Constants.MESSAGE_SEARCH_FAIL);
		} else {
			printMsg(Constants.MESSAGE_SUCCESS);
			for (int i = 0; i < searchedEvent.size(); i++) {
				printMsg(searchedEvent.get(i));
			}
			printMsg(Constants.MESSAGE_SEARCHED);

		}
	}

	public static void printDeletedTask(ArrayList<String> deletedTask) {
		if (deletedTask.isEmpty()){
			printMsg(Constants.MESSAGE_DELETE_FAIL);
		} else {
			printMsg(Constants.MESSAGE_SUCCESS);
			for (int i = 0; i < deletedTask.size(); i++) {
				printMsg(deletedTask.get(i));
			}
			printMsg(Constants.MESSAGE_DELETED);
		}
	}

	public static void printUpdatedEvent(ArrayList<String> updatedEvent) {
		if (updatedEvent.isEmpty()) {
			printMsg(Constants.MESSAGE_UPDATE_FAIL);
		} else {
			printMsg(Constants.MESSAGE_SUCCESS);
			for (int i = 0; i < updatedEvent.size(); i++) {
				printMsg(updatedEvent.get(i));
			}
		}
		printMsg(Constants.MESSAGE_UPDATED);
	}

	public static void printCompletedTask(ArrayList<String> completedTask) {

		printMsg(Constants.MESSAGE_SUCCESS);
		for (int i = 0; i < completedTask.size(); i++) {
			printMsg(completedTask.get(i));
		}
		printMsg(Constants.MESSAGE_COMPLETED);
	}

	public static void printHelp() {
		printMsg(Constants.MESSAGE_HELP);
		printMsg(Constants.COMMAND_ADD);
		printMsg(Constants.COMMAND_DELETE);
		printMsg(Constants.COMMAND_SHOW);
		printMsg(Constants.COMMAND_UPDATE);
		printMsg(Constants.COMMAND_UNDO);
		printMsg(Constants.COMMAND_SEARCH);
		printMsg(Constants.COMMAND_DONE);
		printMsg(Constants.COMMAND_HELP);
		printMsg(Constants.COMMAND_EXIT);
	}

}
