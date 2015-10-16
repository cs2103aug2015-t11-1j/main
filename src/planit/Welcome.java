package planit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Welcome {
	
	// test comment

	private static final String MESSAGE_MORNING = "Good morning, Jim!";
	private static final String MESSAGE_AFTERNOON = "Good afternoon, Jim!";
	private static final String MESSAGE_EVENING = "Good evening, Jim!";
	private static final String MESSAGE_TODAY = "Your tasks for today are as follows: ";
	private static final String MESSAGE_PROMPT = "What would you like to do today?";
	private static final String MESSAGE_SUCCESS = "Success! ";
	private static final String MESSAGE_ADDED = " is added to your schedule:)";
	private static final String MESSAGE_DELETED = " is deleted from your schedule! ";
	private static final String MESSAGE_DELETE_FAIL = "Sadly there is no such event to delete";
	private static final String MESSAGE_SEARCHED = "is found in your schedule! ";
	private static final String MESSAGE_UPDATED = "Your event has been successfully updated!";
	private static final String MESSAGE_COMPLETED = " is complete :)";
	private static final String MESSAGE_SEARCH_FAIL = "Sadly your event is not found:(";
	private static final String MESSAGE_UPDATE_FAIL = "Update failed!";
	private static final String MESSAGE_HELP = "The commands that can be used are: ";

	private static final String COMMAND_EXIT = "exit";
	private static final String COMMAND_ADD = "add";
	private static final String COMMAND_DELETE = "delete";
	private static final String COMMAND_SHOW = "show";
	private static final String COMMAND_UPDATE = "update";
	private static final String COMMAND_SEARCH = "search";
	private static final String COMMAND_UNDO = "undo";
	private static final String COMMAND_HELP = "help";
	private static final String COMMAND_DONE = "done";

	private static DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Calendar cal = Calendar.getInstance();
	private static Scanner sc;

	public static void main(String[] args) throws IOException {
		welcomeMessage();
		initiateProg();

	}

	private static void initiateProg() throws IOException {
		String userInput = requestInput();

		while (!userInput.equals(COMMAND_EXIT)) {
			Logic.executeCommand(userInput);
			printMsg(MESSAGE_PROMPT);
			userInput = requestInput();
		}
		System.exit(0);
	}

	public static void welcomeMessage() {
		if (getMornNight() >= 4 && getMornNight() < 12) {
			printMsg(MESSAGE_MORNING);
		} else if (getMornNight() >= 12 && getMornNight() < 18) {
			printMsg(MESSAGE_AFTERNOON);
		} else {
			printMsg(MESSAGE_EVENING);
		}
		getDate();
		printToday();
		printMsg(MESSAGE_PROMPT);
	}

	private static void printMsg(String message) {
		System.out.println(message);
	}

	private static void printToday() {
		System.out.println(MESSAGE_TODAY);
		System.out.println();
	}

	private static void getDate() {
		System.out.println(df.format(cal.getTime()));
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
		printMsg(MESSAGE_SUCCESS + addedTask + MESSAGE_ADDED);

	}

	public static void printShowEvent(ArrayList<String> eventToShow) {
		for (int i = 0; i < eventToShow.size(); i++) {
			printMsg(eventToShow.get(i));
		}
	}

	public static void printSearchEvent(ArrayList<String> searchedEvent) {
		if (searchedEvent.isEmpty()) {
			printMsg(MESSAGE_SEARCH_FAIL);
		} else {
			printMsg(MESSAGE_SUCCESS);
			for (int i = 0; i < searchedEvent.size(); i++) {
				printMsg(searchedEvent.get(i));
			}
			printMsg(MESSAGE_SEARCHED);

		}
	}

	public static void printDeletedTask(ArrayList<String> deletedTask) {
		if (deletedTask.isEmpty()){
			printMsg(MESSAGE_DELETE_FAIL);
		} else {
			printMsg(MESSAGE_SUCCESS);
			for (int i = 0; i < deletedTask.size(); i++) {
				printMsg(deletedTask.get(i));
			}
			printMsg(MESSAGE_DELETED);
		}
	}

	public static void printUpdatedEvent(ArrayList<String> updatedEvent) {
		if (updatedEvent.isEmpty()) {
			printMsg(MESSAGE_UPDATE_FAIL);
		} else {
			printMsg(MESSAGE_SUCCESS);
			for (int i = 0; i < updatedEvent.size(); i++) {
				printMsg(updatedEvent.get(i));
			}
		}
		printMsg(MESSAGE_UPDATED);
	}

	public static void printCompletedTask(ArrayList<String> completedTask) {

		printMsg(MESSAGE_SUCCESS);
		for (int i = 0; i < completedTask.size(); i++) {
			printMsg(completedTask.get(i));
		}
		printMsg(MESSAGE_COMPLETED);
	}

	public static void printHelp() {
		printMsg(MESSAGE_HELP);
		printMsg(COMMAND_ADD);
		printMsg(COMMAND_DELETE);
		printMsg(COMMAND_SHOW);
		printMsg(COMMAND_UPDATE);
		printMsg(COMMAND_UNDO);
		printMsg(COMMAND_SEARCH);
		printMsg(COMMAND_DONE);
		printMsg(COMMAND_HELP);
		printMsg(COMMAND_EXIT);
	}

}
