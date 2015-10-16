package planit;

import planit.ParserConstants;

public class Parser {

	enum ACTION_TYPE {
		ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO, INVALID, HELP;
	}

	public Parser(String str) {
		setUserAction(str);
	}

	private ACTION_TYPE setUserAction(String str) {
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
		} else if (compareHelpKeywords(userAction)) {
			return ACTION_TYPE.HELP;
		} else {
			return ACTION_TYPE.INVALID;
		}
	}

	/*
	 * Comparison Methods
	 * 
	 * Compares the first word of the user's string input to the keywords specified under ParserConstants
	 */
	private boolean compareAddKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_ADD) {
			if (keyWords.equals(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}
	
	private boolean compareShowKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_SHOW) {
			if (keyWords.equals(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}
}
