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

	// DateTimeFormat formats
	public static final String[] FORMAT_DATE = { "d-MM-yy", "d/MM/yy", "d.MM.yy", "d-MM", "d/MM", "d.MM", "d-MMM-yy",
			"d/MMM/yy", "d.MMM.yy", "d-MMM", "d/MMM", "d.MMM", "d-MM-yyyy", "d/MM/yyyy", "d.MM.yyyy", "d-MM", "d/MM",
			"d.MM", "d-MMM-yyyy", "d/MMM/yyyy", "d.MMM.yyyy", "d-MMM", "d/MMM", "d.MMM", "d MMM yyyy", "d MMM yy",
			"d MMMM yyyy", "d MMMM yy", "dd-MM-yy", "dd/MM/yy", "dd.MM.yy", "dd-MM", "dd/MM", "dd.MM", "dd-MMM-yy",
			"dd/MMM/yy", "dd.MMM.yy", "dd-MMM", "dd/MMM", "dd.MMM", "dd-MM-yyyy", "dd/MM/yyyy", "dd.MM.yyyy",
			"dd-MMM-yyyy", "dd/MMM/yyyy", "dd.MMM.yyyy", "dd-MMM", "dd/MMM", "dd.MMM", "dd MMM yyyy", "dd MMM yy",
			"dd MMMM yyyy", "dd MMMM yy" };
	public static final String[] FORMAT_TIME = { "HHmm", "HH:mm", "HH.mm", "H:mm", "H.mm" };
	public static final String FORMAT_DATE_STORAGE = "dd/MM/yy";

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
	public static final String[] KW_START = { "by", "from", "on", "at", ">", "tomorrow", "tmr", "today",
			"tdy" };
	public static final String[] KW_END = { "by", "until", "till", "to" };
	public static final String KW_NEXT = "next";

	/*
	 * this needs changing public static final String[] KW_TO_EXCLUDE = { "in",
	 * "from", "on", "by", "until", "till", "at", "to", "pm", "am", "1am",
	 * "2am", "3am", "4am", "5am", "6am", "7am", "8am", "9am", "10am", "11am",
	 * "12am", "12noon", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm",
	 * "7pm", "8pm", "9pm", "10pm", "11pm", "12pm", "1.15am", "2.15am",
	 * "3.15am", "4.15am", "5.15am", "6.15am", "7.15am", "8.15am", "9.15am",
	 * "10.15am", "11.15am", "12.15am", "12.15pm", "1.15pm", "2.15pm", "3.15pm",
	 * "4.15pm", "5.15pm", "6.15pm", "7.15pm", "8.15pm", "9.15pm", "10.15pm",
	 * "11.15pm", "12.15pm", "1.30am", "2.30am", "3.30am", "4.30am", "5.30am",
	 * "6.30am", "7.30am", "8.30am", "9.30am", "10.30am", "11.30am", "12.30am",
	 * "12.30pm", "1.30pm", "2.30pm", "3.30pm", "4.30pm", "5.30pm", "6.30pm",
	 * "7.30pm", "8.30pm", "9.30pm", "10.30pm", "11.30pm", "12.30pm", "1.45am",
	 * "2.45am", "3.45am", "4.45am", "5.45am", "6.45am", "7.45am", "8.45am",
	 * "9.45am", "10.45am", "11.45am", "12.45am", "12.45pm", "1.45pm", "2.45pm",
	 * "3.45pm", "4.45pm", "5.45pm", "6.45pm", "7.45pm", "8.45pm", "9.45pm",
	 * "10.45pm", "11.45pm", "12.45pm", "mon", "monday", "tue", "tues",
	 * "tuesday", "wed", "wednesday", "thur", "thurs", "thursday", "fri",
	 * "friday", "sat", "saturday", "sun", "sunday", "tomorrow", "tmr", "today",
	 * "tdy", "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep",
	 * "oct", "nov", "dec", "january", "february", "march", "april", "may",
	 * "june", "july", "august", "september", "october", "november", "december",
	 * "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
	 * "Nov", "Dec", "January", "February", "March", "April", "May", "June",
	 * "July", "August", "September", "October", "November", "December" };
	 */

	// Indexes
	public static final int INDEX_FIRST = 0;
	public static final int INDEX_NEGATIVE_ONE = -1;

	// Integers
	public static final int INT_ONE = 1;

	// REGEX
	public static final String REGEX_WHITESPACES = "[\\s,]+";

	// Single Characters
	public static final String CHAR_SINGLE_WHITESPACE = " ";
	public static final String CHAR_SINGLE_BLANK = "";
	public static final String CHAR_RIGHT_ANGLE_BRACKET = ">";
}
