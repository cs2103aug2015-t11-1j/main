/*
 * ADD SUPPORT FOR AM, PM INPUTS
 */

package parser;

import java.util.ArrayList;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

public class TimeParser {

	protected static ArrayList<String> getTimeArg(String str) throws InvalidInputException, NullPointerException {
		ArrayList<String> arr = Parser.toArrayList(str, ParserConstants.CHAR_SINGLE_WHITESPACE);
		ArrayList<String> timeArg = new ArrayList<String>();
		boolean startExist = false;
		boolean endExist = false;

		int startIndex = Parser.indexOf(ParserConstants.KW_START, arr);
		int endIndex = Parser.indexOf(ParserConstants.KW_END, arr);

		// Split arr into 2 separate ArrayList<String>
		ArrayList<String> startArr = new ArrayList<String>();
		ArrayList<String> endArr = new ArrayList<String>();

		if (startIndex != -1 && endIndex != -1) {
			for (int i = startIndex + 1; i < endIndex; i++) {
				startArr.add(arr.get(i));
			}
			for (int i = endIndex + 1; i < arr.size(); i++) {
				endArr.add(arr.get(i));
			}
		} else if (startIndex != -1 && endIndex == -1) {
			for (int i = startIndex + 1; i < arr.size(); i++) {
				startArr.add(arr.get(i));
			}
		} else if (startIndex == -1 && endIndex != -1) {
			for (int i = endIndex + 1; i < arr.size(); i++) {
				endArr.add(arr.get(i));
			}
		}

		startExist = extractArguments(timeArg, startExist, startArr);
		endExist = extractArguments(timeArg, endExist, endArr);

		if (timeArg.size() > 2 || (startExist == false && startIndex != -1) || (endExist == false && endIndex != -1)) {
			throw new InvalidInputException("Invalid input. Please try again");
		} else {
			if (startExist == false && endExist == false) {
				timeArg.add("");
				timeArg.add("");
				return timeArg;
			} else if (startExist == false && endExist == true) {
				timeArg.add(timeArg.get(0));
				timeArg.set(0, "");
				return timeArg;
			} else if (startExist == true && endExist == false) {
				timeArg.add("");
				return timeArg;
			} else {
				return timeArg;
			}
		}
	}

	/*
	 * Refactored method
	 * 
	 * Extracts the relevant arguments from the specified partition. Returns
	 * true if an argument exists. False if otherwise.
	 */
	private static boolean extractArguments(ArrayList<String> timeArg, boolean argExist, ArrayList<String> partition) {
		for (String s1 : partition) {
			LocalDateTime startTime = null;
			for (String s2 : ParserConstants.FORMAT_TIME) {
				try {
					startTime = DateTimeFormat.forPattern(s2).parseLocalDateTime(s1);
					timeArg.add(startTime.toString(ParserConstants.FORMAT_TIME_STORAGE));
					argExist = true;
				} catch (NullPointerException | IllegalArgumentException e) {

				}
			}
		}
		return argExist;
	}
}
