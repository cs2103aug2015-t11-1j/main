package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

public class DummyDateTimeParserTest {

	@Test
	public void testGetDateTimeArgs() {
		String test2 = ("add CS2103 class 10am to 12pm");
		try {
			DateTimeParser.getDateTimeArgs(test2);
		} catch (InvalidInputException e) {
			System.out.println("Exception caught at date/time");
		}
		ArrayList<String> dateArr = DateTimeParser.getDateArgs();
		ArrayList<String> timeArr = DateTimeParser.getTimeArgs();
		try {
			String event = EventTaskParser.getEventTask(test2);
			System.out.println(event);
		} catch (InvalidInputException e) {
			System.out.println("Exception caught at event/task");
		}
		System.out.println(dateArr.toString() + " " + "size: " + dateArr.size());
		System.out.println(timeArr.toString() + " " + "size: " + timeArr.size());
	}

}
