/*
 * ADD SUPPORT FOR AM, PM INPUTS
 */

package parser;

import java.util.ArrayList;

public class TimeParser {

	/*
	 * Method for parsing time arguments for an ADD command
	 */
	protected static ArrayList<String> addTimeArg(String str) throws InvalidInputException, NullPointerException {
		ArrayList<String> arr = Parser.toArrayList(str, ParserConstants.CHAR_SINGLE_WHITESPACE);
		ArrayList<String> timeArg = new ArrayList<String>();
		boolean startExist = false;
		boolean endExist = false;

		int startIndex = Parser.indexOf(ParserConstants.KW_START, arr);
		int endIndex = Parser.indexOf(ParserConstants.KW_END, arr);

		// Partitions
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

		// Presence of time arguments
		startExist = Parser.extractArguments(timeArg, startExist, startArr, ParserConstants.FORMAT_TIME,
				ParserConstants.FORMAT_TIME_STORAGE);
		endExist = Parser.extractArguments(timeArg, endExist, endArr, ParserConstants.FORMAT_TIME,
				ParserConstants.FORMAT_TIME_STORAGE);

		// Presence of date arguments
		boolean startDateExist = false;
		boolean endDateExist = false;
		startDateExist = Parser.isPresent(startArr, ParserConstants.FORMAT_DATE)
				|| Parser.isPresent(startArr, ParserConstants.KW_TOMORROW);
		endDateExist = Parser.isPresent(endArr, ParserConstants.FORMAT_DATE)
				|| Parser.isPresent(endArr, ParserConstants.KW_TODAY);
		// boolean dateArgExist = (startDateExist || endDateExist);

		if (timeArg.size() > 2 || (startExist == false && startIndex != -1 && startDateExist == false)
				|| (endExist == false && endIndex != -1 && endDateExist == false)) {
			throw new InvalidInputException();
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
}
