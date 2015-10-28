package ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import logic.Session;
import storage.Output;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Welcome {

	// test comment

	private static DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Calendar cal = Calendar.getInstance();
	private static Scanner sc;

	public static void main(String[] args) throws IOException {
		String userInput = "";
		
		welcomeMessage();
		while(true) {
			userInput = requestInput();
			initiateProg(userInput);
		}


	}
	
	/**
	public static String printResults(Output op) {
		String message = "";
		
		if (op.getStatus() && op.getCmdType().toUpperCase().equals("ADD")) {
			message = Constants.MESSAGE_SUCCESS;
		}
		else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("ADD")) {
			message = Constants.MESSAGE_ADD_FAIL;
		}
		
		return message;
	}
	**/
	
	public static String printMessage(Output op) {
		// TODO Auto-generated method stub
		/**
		 *  
		 * <String>();
		 **/
		String message = "";
		ArrayList<String> msgList = new ArrayList<String>();
				
		if (op.getStatus() && op.getCmdType().toUpperCase().equals("ADD")) {
			message = (Constants.MESSAGE_SUCCESS + op.getEntry() + Constants.MESSAGE_ADDED);
		} 
		else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("ADD")) {
			message = (Constants.MESSAGE_ADD_FAIL);
		}
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("DELETE")) {
			message = (Constants.MESSAGE_SUCCESS + op.getEntry() + Constants.MESSAGE_DELETED);
		} //Not wokring if i type "delete name of event"
		else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("DELETE")) {
			message = (Constants.MESSAGE_DELETE_FAIL);
		} 
		
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("SEARCH")) {
			//printMsg(Constants.MESSAGE_SUCCESS);
			for (int i = 0; i < op.getResults().size(); i++) {
				msgList.add(op.getResults().get(i).toString());
			}
			message = Constants.MESSAGE_SUCCESS + "\n";
			for(String s : msgList) {
				message += s + "\n";
			}
			
			message += Constants.MESSAGE_SEARCHED;
		}
		//Not working yet.
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("SEARCH") && op.getResults().isEmpty()) {
			message = (Constants.MESSAGE_SEARCH_FAIL);
		} 
		//Show is not working yet. 
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("SHOW")) {
			//printMsg(Constants.MESSAGE_SHOW);
			for (int i = 0; i < op.getResults().size(); i++) {
				msgList.add(op.getResults().get(i).toString());
			}
			message = Constants.MESSAGE_SHOW + "\n";
			
			for(String s : msgList) {
				message += s + "\n";
			}
			
		} 
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("SHOW") && op.getResults().isEmpty()) {
			message = (Constants.MESSAGE_SHOW_NOTHING);
		} 
		else if (!op.getStatus() && op.getCmdType().toUpperCase().equals("SHOW")) {
			message = (Constants.MESSAGE_SHOW_FAIL);
		}
		//Not yet
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("DONE")) {
			message = (Constants.MESSAGE_DONE);
		}
		//Not yet
		else if (op.getStatus() && op.getCmdType().toUpperCase().equals("HELP")) {
			message = (Constants.MESSAGE_HELP + Constants.COMMAND_DELETE + Constants.COMMAND_ADD +
					Constants.COMMAND_DONE + Constants.COMMAND_EXIT + Constants.COMMAND_SEARCH + 
					Constants.COMMAND_SHOW + Constants.COMMAND_UNDO + Constants.COMMAND_UPDATE + Constants.COMMAND_EXIT
					+ Constants.COMMAND_HELP);
		}
		//Not yet
		else if(op.getStatus() && op.getCmdType().toUpperCase().equals("UNDO")) {
			message = (Constants.MESSAGE_SUCCESS + op.getEntry());
		}
		//Not yet
		else if(op.getStatus() && op.getCmdType().toUpperCase().equals("UPDATE")) {
			message = (Constants.MESSAGE_SUCCESS + op.getEntry() + Constants.MESSAGE_UPDATED);
		}
		else if(!op.getStatus() && op.getCmdType().toUpperCase().equals("UPDATE")) {
			message = Constants.MESSAGE_UPDATE_FAIL;
		}
		//Not yet
		else if(op.getStatus() && op.getCmdType().toUpperCase().equals("EXIT")) {
			message = Constants.MESSAGE_EXIT;
		}
		else {
			message = Constants.MESSAGE_ERROR;
			
		}
		 return message;
	}

	public static String initiateProg(String userInput) throws IOException {
		Session session = new Session();
		Output op = null;
		String message = "";
		
			op = session.executeCommand(userInput);
			//printResults(op);
			message = printMessage(op);
			//printMsg(Constants.MESSAGE_PROMPT);
			
			return message;
		
	}

	public static String welcomeMessage() {
		String message = "";
		if (getMornNight() >= 4 && getMornNight() < 12) {
			message = Constants.MESSAGE_MORNING +"\n"+ Constants.MESSAGE_PROMPT;
		} else if (getMornNight() >= 12 && getMornNight() < 18) {
			message = Constants.MESSAGE_AFTERNOON +"\n"+ Constants.MESSAGE_PROMPT;
		} else {
			message = Constants.MESSAGE_EVENING +"\n"+ Constants.MESSAGE_PROMPT;
		}
		return message;
		//printMsg(message);
		//printMsg(Constants.MESSAGE_PROMPT);
	}

	private static void printMsg(String message) {
		System.out.println(message);
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

	private static int getMornNight() {
		int i = cal.get(Calendar.HOUR_OF_DAY);
		return i;

	}

	public static String printToday() {
		String message = Constants.MESSAGE_TODAY;
		return message;
	}
	/**
	 * private static int getMornNight() { int i =
	 * cal.get(Calendar.HOUR_OF_DAY); return i;
	 * 
	 * }
	 * 
	 * 
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
