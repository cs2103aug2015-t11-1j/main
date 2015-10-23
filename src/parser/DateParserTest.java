package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DateParserTest {

	@Test
	public void testTwoDateArgParsed() throws NullPointerException, InvalidInputException {
		String test = "add event from 22/10/15 to 23/10/15";
		ArrayList<String> result = DateParser.addDateArg(test);
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("22/10/15");
		expected.add("23/10/15");
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testOneStartDateArgParsed() throws NullPointerException, InvalidInputException {
		String test = "add event on 22/10/15";
		ArrayList<String> result = DateParser.addDateArg(test);
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("22/10/15");
		expected.add("");
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testOneEndDateArgParsed() throws NullPointerException, InvalidInputException {
		String test = "add event by 23/10/15";
		ArrayList<String> result = DateParser.addDateArg(test);
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("");
		expected.add("23/10/15");
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testNoDateArgParsedWithoutTimeArg() throws NullPointerException, InvalidInputException {
		String test = "add event";
		ArrayList<String> result = DateParser.addDateArg(test);
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("");
		expected.add("");
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testNoDateArgParsedWithTimeArg() throws NullPointerException, InvalidInputException {
		String test = "add event from 11:00 to 12.00";
		ArrayList<String> result = DateParser.addDateArg(test);
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add(DateParser.getDate(0));
		expected.add("");
		
		assertEquals(expected, result);
	}
	
	@Test(expected = InvalidInputException.class) 
	public void testTooManyStartDateInput() throws NullPointerException, InvalidInputException {
		String test = "add event from 23/10/15 22/10/15 to 24/10/15";
		DateParser.addDateArg(test);
	}
	
	@Test(expected = InvalidInputException.class) 
	public void testTooManyEndDateInput() throws NullPointerException, InvalidInputException {
		String test = "add event from 23/10/15 to 24/10/15 22/10/15";
		DateParser.addDateArg(test);
	}
	
	@Test(expected = InvalidInputException.class) 
	public void testInvalidEndDateInput() throws NullPointerException, InvalidInputException {
		String test = "add event from 23/10/15 to ";
		DateParser.addDateArg(test);
	}
	
	@Test(expected = InvalidInputException.class) 
	public void testInvalidStartDateInput() throws NullPointerException, InvalidInputException {
		String test = "add event from to 24/10/15 ";
		DateParser.addDateArg(test);
	}
	
	@Test(expected = InvalidInputException.class) 
	public void testInvalidDateInput() throws NullPointerException, InvalidInputException {
		String test = "add event from to ";
		DateParser.addDateArg(test);
	}

}
