/* 
 * @@author A0121319R
 */

package parser;

public class ActionParser {

	protected enum ACTION_TYPE {
		ADD, SHOW, SEARCH, UPDATE, DONE, UNDONE, DELETE, UNDO, INVALID, EXIT, HELP, FP, CFP, CLEAR;
	}

	/*
	 * This method extracts the user's specified action and returns it as an
	 * ACTION_TYPE
	 * 
	 * Assumptions: 1) The user action is always in the first index in the
	 * entire String
	 */
	protected static ACTION_TYPE setUserAction(String str) {
		String[] strArray = str.split(ParserConstants.REGEX_WHITESPACES);
		String userAction = strArray[ParserConstants.INDEX_FIRST];

		if (compareAddKeywords(userAction)) {
			return ACTION_TYPE.ADD;
		} else if (compareShowKeywords(userAction)) {
			return ACTION_TYPE.SHOW;
		} else if (compareSearchKeywords(userAction)) {
			return ACTION_TYPE.SEARCH;
		} else if (compareUpdateKeywords(userAction)) {
			return ACTION_TYPE.UPDATE;
		} else if (compareDoneKeywords(userAction)) {
			return ACTION_TYPE.DONE;
		} else if (compareUndoneKeywords(userAction)) {
			return ACTION_TYPE.UNDONE;
		} else if (compareDeleteKeywords(userAction)) {
			return ACTION_TYPE.DELETE;
		} else if (compareUndoKeywords(userAction)) {
			return ACTION_TYPE.UNDO;
		} else if (compareExitKeywords(userAction)) {
			return ACTION_TYPE.EXIT;
		} else if (userAction.equalsIgnoreCase("help")) {
			return ACTION_TYPE.HELP;
		} else if (userAction.equalsIgnoreCase("fp")) {
			return ACTION_TYPE.FP;
		} else if (userAction.equalsIgnoreCase("cfp")) {
			return ACTION_TYPE.CFP;
		} else if (userAction.equalsIgnoreCase("clear")) {
			return ACTION_TYPE.CLEAR;
		} else {
			return ACTION_TYPE.INVALID;
		}
	}

	/*
	 * Comparison Methods
	 * 
	 * Compares the first word of the user's string input to the keywords
	 * specified under ParserConstants
	 */
	private static boolean compareAddKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_ADD) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private static boolean compareShowKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_SHOW) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private static boolean compareSearchKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_SEARCH) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private static boolean compareUpdateKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_UPDATE) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private static boolean compareDoneKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_DONE) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private static boolean compareUndoneKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_UNDONE) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private static boolean compareDeleteKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_DELETE) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private static boolean compareUndoKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_UNDO) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private static boolean compareExitKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_EXIT) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}
}
