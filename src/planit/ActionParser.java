package planit;

import java.util.ArrayList;

public class ActionParser {

	enum ACTION_TYPE {
		ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO, INVALID, EXIT, HELP;
	}

	public static ACTION_TYPE setUserAction(String str) {
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
		} else if (compareDeleteKeywords(userAction)) {
			return ACTION_TYPE.DELETE;
		} else if (compareUndoKeywords(userAction)) {
			return ACTION_TYPE.UNDO;
		} else if (compareExitKeywords(userAction)) {
			return ACTION_TYPE.EXIT;
		} else if (userAction.equalsIgnoreCase("help")) {
			return ACTION_TYPE.HELP;
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
