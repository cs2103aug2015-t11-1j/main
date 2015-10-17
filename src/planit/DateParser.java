package planit;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateParser {
	
	LocalDateTime currentDateTime;
	
	public DateParser() {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-MM-yyyy");
		currentDateTime = new LocalDateTime();
	}
}
