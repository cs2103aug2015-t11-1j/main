package planit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Welcome {
	
	private static final String MESSAGE_MORNING = "Good morning, Jim!";
	private static final String MESSAGE_AFTERNOON = "Good afternoon, Jim!";
	private static final String MESSAGE_EVENING = "Good evening, Jim!";
	private static final String MESSAGE_TODAY = "Your tasks for today are as follows: ";
	private static final String MESSAGE_PROMPT = "Do you have any tasks to add?";
	private static final String MESSAGE_SUCCESS = "Success! ";
	private static final String MESSAGE_ADDED = " is added to your schedule:)";
	private static final String MESSAGE_DELETED = "is deleted from your schedule! ";
	private static final String MESSAGE_SEARCHED = "is found in your schedule! ";
	
	
	private static final String COMMAND_EXIT = "exit";
	
	
	private static DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Calendar cal = Calendar.getInstance();
	private static Scanner sc;
	
	public static void main(String[] args) throws IOException {
		welcomeMessage();
		initiateProg();
		
	}
	
	private static void initiateProg() throws IOException {
		String userInput = requestInput();

		while(!userInput.equals(COMMAND_EXIT)) {
			Logic.executeCommand(userInput);
			printMsg(MESSAGE_PROMPT);
			userInput = requestInput();
		}
		System.exit(0);
	}
	
	public static void welcomeMessage() {
		if(getMornNight() >= 4 && getMornNight() < 12) {
			 printMsg(MESSAGE_MORNING);
		}
		else if(getMornNight() >= 12 && getMornNight() < 18) {
			printMsg(MESSAGE_AFTERNOON);
		}
		else if(getMornNight() >= 18 && getMornNight() < 4) {
			printMsg(MESSAGE_EVENING);
		}
		else {
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
		String userInput = sc.nextLine();
		return userInput;
	}

	public static void printAddedEvent(String addedTask) {
		printMsg(MESSAGE_SUCCESS + addedTask + MESSAGE_ADDED);
		
	}

	public static void printShowEvent(ArrayList<String> eventToShow) {
		for(int i=0; i<eventToShow.size(); i++){
			printMsg(eventToShow.get(i));
		}
	}

	public static void printSearchEvent(ArrayList<String> searchedEvent) {
		System.out.println(MESSAGE_SUCCESS);
		for(int i=0; i<searchedEvent.size(); i++){
			printMsg(searchedEvent.get(i));
		}
		printMsg(MESSAGE_SEARCHED);
	}

	public static void printDeletedTask(String taskToDelete) {
		printMsg(MESSAGE_SUCCESS + taskToDelete + MESSAGE_DELETED);
	}
	
	
}
