package planit;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Welcome {
	
	private static final String MESSAGE_MORNING = "Good morning, Jim!";
	private static final String MESSAGE_AFTERNOON = "Good afternoon, Jim!";
	private static final String MESSAGE_EVENING = "Good evening, Jim!";
	private static final String MESSAGE_TODAY = "Your tasks for today are as follows: ";
	private static final String MESSAGE_PROMPT = "Do you have any tasks to add?";
	
	
	private static DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Calendar cal = Calendar.getInstance();
	
	public static void main(String[] args) {
		welcomeMessage();
		
	}

	private static void welcomeMessage() {
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
	
}
