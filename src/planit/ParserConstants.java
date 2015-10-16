package planit;

public class ParserConstants {

	// Day Keywords (KW)
	public static final String[] KW_MONDAY = { "mon", "monday" };
	public static final String[] KW_TUESDAY = { "tue", "tues", "tuesday" };
	public static final String[] KW_WEDNESDAY = { "wed", "wednesday" };
	public static final String[] KW_THURSDAY = { "thur", "thurs", "thursday" };
	public static final String[] KW_FRIDAY = { "fri", "friday" };
	public static final String[] KW_SATURDAY = { "sat", "saturday" };
	public static final String[] KW_SUNDAY = { "sun", "sunday" };
	public static final String[] KW_TOMORROW = { "tomorrow", "tmr" };
	public static final String[] KW_TODAY = { "today", "tdy" };

	// Month Keywords (KW)
	public static final String[] KW_MONTHS_SHORT = { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep",
			"oct", "nov", "dec" };
	public static final String[] KW_MONTHS_LONG = { "january", "february", "march", "april", "may", "june", "july",
			"august", "september", "october", "november", "december" };
	public static final String[] KW_MONTHS_1ST_UPPER_SHORT = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
			"Sep", "Oct", "Nov", "Dec" };
	public static final String[] KW_MONTHS_1ST_UPPER_LONG = { "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" };

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
	public static final String[] KW_START_DATE = { "from", "on" };
	public static final String[] KW_END_DATE = { "by", "until", "till" };

	public static final String[] KW_START_TIME = { "between" };
	public static final String[] KW_END_TIME = { "at", "to" };
}
