package parser;

public class ParserConstants {

	// Day Keywords (KW)
	/*
	 * protected static final String[] KW_MONDAY = { "mon", "monday" }; protected
	 * static final String[] KW_TUESDAY = { "tue", "tues", "tuesday" }; protected
	 * static final String[] KW_WEDNESDAY = { "wed", "wednesday" }; protected
	 * static final String[] KW_THURSDAY = { "thur", "thurs", "thursday" };
	 * protected static final String[] KW_FRIDAY = { "fri", "friday" }; protected
	 * static final String[] KW_SATURDAY = { "sat", "saturday" }; protected static
	 * final String[] KW_SUNDAY = { "sun", "sunday" };
	 */
	protected static final String[] KW_TOMORROW = { "tomorrow", "tmr" };
	protected static final String[] KW_TODAY = { "today", "tdy" };

	// Month Keywords (KW)
	/*
	 * protected static final String[] KW_MONTHS_SHORT = { "jan", "feb", "mar",
	 * "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" }; protected
	 * static final String[] KW_MONTHS_LONG = { "january", "february", "march",
	 * "april", "may", "june", "july", "august", "september", "october",
	 * "november", "december" }; protected static final String[]
	 * KW_MONTHS_1ST_UPPER_SHORT = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
	 * "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }; protected static final String[]
	 * KW_MONTHS_1ST_UPPER_LONG = { "January", "February", "March", "April",
	 * "May", "June", "July", "August", "September", "October", "November",
	 * "December" };
	 */

	// DateTimeFormat formats
	/*
	 * protected static final String[] FORMAT_DATE1 = { "d-MM-yy", "d/MM/yy",
	 * "d.MM.yy", "d-MM", "d/MM", "d.MM", "d-MMM-yy", "d/MMM/yy", "d.MMM.yy",
	 * "d-MMM", "d/MMM", "d.MMM", "d-MM-yyyy", "d/MM/yyyy", "d.MM.yyyy", "d-MM",
	 * "d/MM", "d.MM", "d-MMM-yyyy", "d/MMM/yyyy", "d.MMM.yyyy", "d-MMM",
	 * "d/MMM", "d.MMM", "d MMM yyyy", "d MMM yy", "d MMMM yyyy", "d MMMM yy",
	 * "dd-MM-yy", "dd/MM/yy", "dd.MM.yy", "dd-MM", "dd/MM", "dd.MM",
	 * "dd-MMM-yy", "dd/MMM/yy", "dd.MMM.yy", "dd-MMM", "dd/MMM", "dd.MMM",
	 * "dd-MM-yyyy", "dd/MM/yyyy", "dd.MM.yyyy", "dd-MMM-yyyy", "dd/MMM/yyyy",
	 * "dd.MMM.yyyy", "dd-MMM", "dd/MMM", "dd.MMM", "dd MMM yyyy", "dd MMM yy",
	 * "dd MMMM yyyy", "dd MMMM yy", "ddMMyy", "dd MMMM" };
	 */
	protected static final String[] FORMAT_DATE_WITH_YEAR = { "dd/MM/yy", "dd-MM-yy", "dd.MM.yy", "ddMMyy",
			"dd.MMMM.yy" };
	protected static final String[] FORMAT_DATE_WITHOUT_YEAR = { "dd/MM", "dd-MM", "dd.MM", "ddMM", "dd.MMMM" };
	protected static final String[] FORMAT_TIME = { "HHmm", "HH:mm", "HH.mm", "hha", "hh:mma", "hh.mma" };
	protected static final String FORMAT_DATE_STORAGE = "dd/MM/yy";
	protected static final String FORMAT_TIME_STORAGE = "HHmm";

	// Command Keywords (KW)
	protected static final String[] KW_COMMAND_ADD = { "add", "new" };
	protected static final String[] KW_COMMAND_DELETE = { "delete", "rm", "del" };
	protected static final String[] KW_COMMAND_SHOW = { "show", "display" };
	protected static final String[] KW_COMMAND_SEARCH = { "search", "find" };
	protected static final String[] KW_COMMAND_UPDATE = { "edit", "change", "update" };
	protected static final String[] KW_COMMAND_DONE = { "done", "mark" };
	protected static final String[] KW_COMMAND_UNDO = { "undo" };
	protected static final String[] KW_COMMAND_EXIT = { "exit", "quit" };

	// User string input Keywords (KW)
	protected static final String[] KW_START = { "from", "on", "at", ">", "tomorrow", "tmr", "today", "tdy" };
	protected static final String[] KW_END = { "by", "until", "till", "to" };
	// protected static final String KW_NEXT = "next";

	// Indexes
	protected static final int INDEX_FIRST = 0;
	protected static final int INDEX_SECOND = 1;

	// Integers
	protected static final int INT_ONE = 1;

	// REGEX
	protected static final String REGEX_WHITESPACES = "[\\s,]+";

	// Single Characters
	protected static final String CHAR_SINGLE_WHITESPACE = " ";
	protected static final String CHAR_SINGLE_BLANK = "";
	protected static final String CHAR_RIGHT_ANGLE_BRACKET = ">";
	protected static final String CHAR_PERIOD = ".";
	protected static final String CHAR_FORWARD_SLASH = "/";
	protected static final String CHAR_FORWARD_HYPHEN = "-";
}
