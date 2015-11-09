/*
 * @@author A0121319R
 * 
 * Reused some constants from T11-3J
 */

package parser;

public class ParserConstants {

	protected static final String[] KW_TOMORROW = { "tomorrow", "tmr" };
	protected static final String[] KW_TODAY = { "today", "tdy" };

	// DateTimeFormat formats
	protected static final String[] FORMAT_DATE_WITH_YEAR = { "dd/MM/yy", "dd-MM-yy", "dd.MM.yy", "ddMMyy",
			"dd.MMMM.yy" };
	protected static final String[] FORMAT_DATE_WITHOUT_YEAR = { "dd/MM", "dd-MM", "dd.MM", "ddMM", "dd.MMMM" };
	protected static final String[] FORMAT_TIME = { "HHmm", "HH:mm", "HH.mm", "hha", "hh:mma", "hh.mma", "hhmma" };
	protected static final String FORMAT_DATE_STORAGE = "dd/MM/yy";
	protected static final String FORMAT_TIME_STORAGE = "HHmm";

	// Command Keywords (KW)
	protected static final String[] KW_COMMAND_ADD = { "add", "new" };
	protected static final String[] KW_COMMAND_DELETE = { "delete", "rm", "del" };
	protected static final String[] KW_COMMAND_SHOW = { "show", "display" };
	protected static final String[] KW_COMMAND_SEARCH = { "search", "find" };
	protected static final String[] KW_COMMAND_UPDATE = { "edit", "change", "update" };
	protected static final String[] KW_COMMAND_DONE = { "done", "mark" };
	protected static final String[] KW_COMMAND_UNDONE = { "undone", "unmark" };
	protected static final String[] KW_COMMAND_UNDO = { "undo" };
	protected static final String[] KW_COMMAND_EXIT = { "exit", "quit" };

	// User string input Keywords (KW)
	protected static final String[] KW_START = { "from", "on", "at" };
	protected static final String[] KW_END = { "by", "until", "till", "to", "-" };
	protected static final String[] KW_TIME = { "today", "tdy", "tomorrow", "tmr" };
	protected static final String KW_FLOAT = "float";

	// Indexes
	protected static final int INDEX_FIRST = 0;
	protected static final int INDEX_SECOND = 1;

	// Integers
	protected static final int INT_ZERO = 0;
	protected static final int INT_ONE = 1;
	protected static final int INT_NEG_ONE = -1;
	protected static final int INT_TWO = 2;

	// REGEX
	protected static final String REGEX_WHITESPACES = "[\\s,]+";

	// Single Characters
	protected static final String CHAR_SINGLE_WHITESPACE = " ";
	protected static final String CHAR_SINGLE_BLANK = "";
	protected static final String CHAR_RIGHT_ANGLE_BRACKET = ">";
	protected static final String CHAR_PERIOD = ".";
	protected static final String CHAR_FORWARD_SLASH = "/";
	protected static final String CHAR_HYPHEN = "-";
}
