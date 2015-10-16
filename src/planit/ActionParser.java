package planit;

public class ActionParser {

	private ACTION_TYPE userAction;

	enum ACTION_TYPE {
		ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO, INVALID, EXIT, HELP;
	}

	public ActionParser(String str) {
		userAction = setUserAction(str);
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
	private boolean compareAddKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_ADD) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private boolean compareShowKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_SHOW) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private boolean compareSearchKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_SEARCH) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private boolean compareUpdateKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_UPDATE) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private boolean compareDoneKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_DONE) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private boolean compareDeleteKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_DELETE) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private boolean compareUndoKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_UNDO) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	private boolean compareExitKeywords(String str) {
		boolean containKeywords = false;
		for (String keyWords : ParserConstants.KW_COMMAND_EXIT) {
			if (keyWords.equalsIgnoreCase(str)) {
				containKeywords = true;
			}
		}
		return containKeywords;
	}

	public ACTION_TYPE getUserAction() {
		return this.userAction;
	}
}
