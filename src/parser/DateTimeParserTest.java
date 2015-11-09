/*
 * @@author A0121319R
 */

package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DateTimeParserTest {

	private ArrayList<String> resultTime = new ArrayList<String>();
	private ArrayList<String> resultDate = new ArrayList<String>();
	private ArrayList<String> expectedTime = new ArrayList<String>();
	private ArrayList<String> expectedDate = new ArrayList<String>();

	@Test
	public void testForTwoDateAndTimeArgs() throws InvalidInputException {
		String test = "add camping trip at somewhere from 12-12-15 11:00 to 13/12/15 1200";
		DateTimeParser.getDateTimeArgs(test);
		resultTime = DateTimeParser.getTimeArgs();
		resultDate = DateTimeParser.getDateArgs();
		expectedTime.add("1100");
		expectedTime.add("1200");
		expectedDate.add("12/12/15");
		expectedDate.add("13/12/15");
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test
	public void testOneStartDateAndTime() throws InvalidInputException {
		String test = "add meeting with boss today 10.30am";
		DateTimeParser.getDateTimeArgs(test);
		resultDate = DateTimeParser.getDateArgs();
		resultTime = DateTimeParser.getTimeArgs();
		expectedDate = add(DateTimeParser.getDate(0), "");
		expectedTime = add("1030", "");
		assertEquals(expectedDate, resultDate);
		assertEquals(expectedTime, resultTime);
	}

	@Test
	public void testOneEndDateAndTime() throws InvalidInputException {
		String test = "add submit maths assignment by tomorrow 2359";
		DateTimeParser.getDateTimeArgs(test);
		resultDate = DateTimeParser.getDateArgs();
		resultTime = DateTimeParser.getTimeArgs();
		expectedDate = add(DateTimeParser.getDate(1), "");
		expectedTime = add("2359", "");
		assertEquals(expectedDate, resultDate);
		assertEquals(expectedTime, resultTime);
	}

	@Test
	public void testTravellingCasual() throws InvalidInputException {
		String test = "add drive from clementi to yishun today 10:00pm";
		DateTimeParser.getDateTimeArgs(test);
		resultDate = DateTimeParser.getDateArgs();
		resultTime = DateTimeParser.getTimeArgs();
		expectedDate = add(DateTimeParser.getDate(0), "");
		expectedTime = add("2200", "");
		assertEquals(expectedDate, resultDate);
		assertEquals(expectedTime, resultTime);
	}

	@Test
	public void testTravellingStrictStartInputs() throws InvalidInputException {
		String test = "add drive from clementi to yishun > today 10:00pm";
		DateTimeParser.getDateTimeArgs(test);
		resultDate = DateTimeParser.getDateArgs();
		resultTime = DateTimeParser.getTimeArgs();
		expectedDate = add(DateTimeParser.getDate(0), "");
		expectedTime = add("2200", "");
		assertEquals(expectedDate, resultDate);
		assertEquals(expectedTime, resultTime);
	}

	@Test
	public void testTravellingStrictBothInputs() throws InvalidInputException {
		String test = "add drive from clementi to yishun > today 10:00pm to tomorrow 12.37pm";
		DateTimeParser.getDateTimeArgs(test);
		resultDate = DateTimeParser.getDateArgs();
		resultTime = DateTimeParser.getTimeArgs();
		expectedDate = add(DateTimeParser.getDate(0), DateTimeParser.getDate(1));
		expectedTime = add("2200", "1237");
		assertEquals(expectedDate, resultDate);
		assertEquals(expectedTime, resultTime);
	}

	@Test(expected = InvalidInputException.class)
	public void testWatchMovieCasual() throws InvalidInputException {
		String test = "add watch day after tomorrow today 10am";
		DateTimeParser.getDateTimeArgs(test);
		resultDate = DateTimeParser.getDateArgs();
		resultTime = DateTimeParser.getTimeArgs();
		expectedDate = add(DateTimeParser.getDate(1), DateTimeParser.getDate(0));
		expectedTime = add("1000", "");
		assertEquals(expectedDate, resultDate);
		assertEquals(expectedTime, resultTime);
	}

	@Test
	public void testWatchMovieStrict() throws InvalidInputException {
		String test = "add watch day after tomorrow > today 10am";
		DateTimeParser.getDateTimeArgs(test);
		resultDate = DateTimeParser.getDateArgs();
		resultTime = DateTimeParser.getTimeArgs();
		expectedDate = add(DateTimeParser.getDate(0), "");
		expectedTime = add("1000", "");
		assertEquals(expectedDate, resultDate);
		assertEquals(expectedTime, resultTime);
	}

	@Test
	public void testForOneEndDateAndTwoTimeArgs() throws InvalidInputException {
		String test = "add event from 10:00 to 12.dec 10:00";
		DateTimeParser.getDateTimeArgs(test);
		resultDate = DateTimeParser.getDateArgs();
		resultTime = DateTimeParser.getTimeArgs();
		expectedTime = add("1000", "1000");
		expectedDate = add(DateTimeParser.getDate(0), "12/12/15");
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test(expected = InvalidInputException.class)
	public void testForTooManyStartInputs() throws InvalidInputException {
		String test = "add event from 10/10/15 11:00 11:01 to 11/10/15 12:34";
		DateTimeParser.getDateTimeArgs(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testForTooManyEndInputs() throws InvalidInputException {
		String test = "add event from 11:00 to 12:34 12:43";
		DateTimeParser.getDateTimeArgs(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testTooManyEndDateInput() throws InvalidInputException {
		String test = "add event from 12/12/20 to 13/12/20 14/12/20";
		DateTimeParser.getDateTimeArgs(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testEndDateBeforeStartDate() throws InvalidInputException {
		String test = "add training tomorrow to today";
		DateTimeParser.getDateTimeArgs(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testEndTimeBeforeStartTime() throws InvalidInputException {
		String test = "add training 11am to 10am";
		DateTimeParser.getDateTimeArgs(test);
	}

	// For easier adding to ArrayLists
	private static ArrayList<String> add(String start, String end) {
		ArrayList<String> returnArr = new ArrayList<String>();
		returnArr.add(start);
		returnArr.add(end);
		return returnArr;
	}
}
