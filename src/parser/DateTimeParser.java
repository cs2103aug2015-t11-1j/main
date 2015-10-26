/*
 * Work in progress
 */

package parser;

import java.util.ArrayList;

public class DateTimeParser {

	private static ArrayList<String> dateArgs;
	private static ArrayList<String> timeArgs;

	protected static void getDateTimeArgs(String str) {

		dateArgs = new ArrayList<String>();
		timeArgs = new ArrayList<String>();
		String startDate = null;
		String startTime = null;
		String endDate = null;
		String endTime = null;
		boolean startDateExist = false;
		boolean startTimeExist = false;
		boolean endDateExist = false;
		boolean endTimeExist = false;

		// TODO Check for start and end KW.
		// Partition from start to end (CAN BE REUSED)
		// Partition from end to string end (CAN BE REUSED)
		// Check for FORMAT_DATE_LONG
		
	}

	/***** GETTERS *****/
	protected static ArrayList<String> getDateArgs() {
		return dateArgs;
	}

	protected static ArrayList<String> getTimeArgs() {
		return timeArgs;
	}
}
