package planit;

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
	private static final String MESSAGE_ADDED = " has been added to your schedule:)";
	
	private static final String COMMAND_EXIT = "exit";
	
	
	private static DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Calendar cal = Calendar.getInstance();
	private static Scanner sc;
	
	public static void main(String[] args) throws IOException {
		welcomeMessage();
		String userInput = requestInput();

		while(!userInput.equals(COMMAND_EXIT)) {
			Logic.executeCommand(userInput);
			printPrompt();
			userInput = requestInput();
		}
		System.exit(0);
		
	}
	public static void welcomeMessage() {
		if(getMornNight() >= 4 && getMornNight() < 12) {
			 printWelcomeMorning();
		}
		else if(getMornNight() >= 12 && getMornNight() < 18) {
			printWelcomeAfternoon();
		}
		else if(getMornNight() >= 18 && getMornNight() < 4) {
			printWelcomeEvening();
		}
		else {
			printWelcomeEvening();
		}
		getDate();
		printToday();
		printPrompt();
	}
	
	private static void printPrompt() {
		System.out.println(MESSAGE_PROMPT);
		
	}

	private static void printWelcomeMorning() {
		System.out.println(MESSAGE_MORNING);
	}

	private static void printWelcomeEvening() {
		System.out.println(MESSAGE_EVENING);
		
	}

	private static void printWelcomeAfternoon() {
		System.out.println(MESSAGE_AFTERNOON);
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
		System.out.println(MESSAGE_SUCCESS + addedTask + MESSAGE_ADDED);
		
	}

	public static void printShowEvent(String eventToShow) {
		// TODO Auto-generated method stub
		
	}

	public static void printSearchEvent(String searchedEvent) {
		// TODO Auto-generated method stub
		
	}

	public static void printDeletedTask(String taskToDelete) {
		// TODO Auto-generated method stub
		
	}
	
	
}
