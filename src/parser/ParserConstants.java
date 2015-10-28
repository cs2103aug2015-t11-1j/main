package parser;

public class ParserConstants {

	// Day Keywords (KW)
	/*
	 * public static final String[] KW_MONDAY = { "mon", "monday" }; public
	 * static final String[] KW_TUESDAY = { "tue", "tues", "tuesday" }; public
	 * static final String[] KW_WEDNESDAY = { "wed", "wednesday" }; public
	 * static final String[] KW_THURSDAY = { "thur", "thurs", "thursday" };
	 * public static final String[] KW_FRIDAY = { "fri", "friday" }; public
	 * static final String[] KW_SATURDAY = { "sat", "saturday" }; public static
	 * final String[] KW_SUNDAY = { "sun", "sunday" };
	 */
	public static final String[] KW_TOMORROW = { "tomorrow", "tmr" };
	public static final String[] KW_TODAY = { "today", "tdy" };

	// Month Keywords (KW)
	/*
	 * public static final String[] KW_MONTHS_SHORT = { "jan", "feb", "mar",
	 * "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" }; public
	 * static final String[] KW_MONTHS_LONG = { "january", "february", "march",
	 * "april", "may", "june", "july", "august", "september", "october",
	 * "november", "december" }; public static final String[]
	 * KW_MONTHS_1ST_UPPER_SHORT = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
	 * "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }; public static final String[]
	 * KW_MONTHS_1ST_UPPER_LONG = { "January", "February", "March", "April",
	 * "May", "June", "July", "August", "September", "October", "November",
	 * "December" };
	 */

	// DateTimeFormat formats
	/*
	 * public static final String[] FORMAT_DATE1 = { "d-MM-yy", "d/MM/yy",
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
	public static final String[] FORMAT_DATE_WITH_YEAR = { "dd/MM/yy", "dd-MM-yy", "dd.MM.yy", "ddMMyy",
			"dd.MMMM.yy" };
	public static final String[] FORMAT_DATE_WITHOUT_YEAR = { "dd/MM", "dd-MM", "dd.MM", "ddMM", "dd.MMMM" };
	public static final String[] FORMAT_TIME = { "HHmm", "HH:mm", "HH.mm", "hha", "hh:mma", "hh.mma" };
	public static final String FORMAT_DATE_STORAGE = "dd/MM/yy";
	public static final String FORMAT_TIME_STORAGE = "HHmm";

	// Command Keywords (KW)
	public static final String[] KW_COMMAND_ADD = { "add", "new" };
	public static final String[] KW_COMMAND_DELETE = { "delete", "rm", "del" };
	public static final String[] KW_COMMAND_SHOW = { "show", "display" };
	public static final String[] KW_COMMAND_SEARCH = { "search", "find" };
	public static final String[] KW_COMMAND_UPDATE = { "edit", "change", "update" };
	public static final String[] KW_COMMAND_DONE = { "done", "mark" };
	public static final String[] KW_COMMAND_UNDO = { "undo" };
	public static final String[] KW_COMMAND_EXIT = { "exit", "quit" };

	// User string input Keywords (KW)
	public static final String[] KW_START = { "from", "on", "at", ">", "tomorrow", "tmr", "today", "tdy" };
	public static final String[] KW_END = { "by", "until", "till", "to" };
	// public static final String KW_NEXT = "next";

	// Indexes
	public static final int INDEX_FIRST = 0;
	public static final int INDEX_SECOND = 1;

	// Integers
	public static final int INT_ONE = 1;

	// REGEX
	public static final String REGEX_WHITESPACES = "[\\s,]+";

	// Single Characters
	public static final String CHAR_SINGLE_WHITESPACE = " ";
	public static final String CHAR_SINGLE_BLANK = "";
	public static final String CHAR_RIGHT_ANGLE_BRACKET = ">";
	public static final String CHAR_PERIOD = ".";
	public static final String CHAR_FORWARD_SLASH = "/";
	public static final String CHAR_FORWARD_HYPHEN = "-";
}
