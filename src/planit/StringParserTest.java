package planit;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringParserTest {

	@Test
	public void testStringParserUserCommand1() {
		String testString = "this is a test string";
		StringParser sp = new StringParser();
		String resultString = sp.extractUserCommand(testString);

		assertTrue("first word is incorrect", resultString.equals("this"));
	}

	@Test
	public void testStringParserUserCommand2() {
		String testString = "thisisateststring";
		StringParser sp = new StringParser();
		String resultString = sp.extractUserCommand(testString);

		assertTrue("first word is incorrect", resultString.equals("thisisateststring"));
	}

	@Test
	public void testStringParserUserCommand3() {
		String testString = "";
		StringParser sp = new StringParser();
		String resultString = sp.extractUserCommand(testString);

		assertTrue("first word is incorrect", resultString.equals(""));
	}

	/*
	 * @Test public void testSplitStringIntoArrayDelimAngleBrackets1() { String
	 * testString = "add this event >111111 2222 to 111111 2222"; StringParser
	 * sp = new StringParser(); ArrayList<String> resultArray =
	 * sp.splitStringIntoArrayDelimAngleBrackets(testString);
	 * 
	 * ArrayList<String> expectedArray = new ArrayList<String>();
	 * expectedArray.add("add this event "); expectedArray.add(
	 * "111111 2222 to 111111 2222"); assertTrue("the arrays are not similar",
	 * expectedArray.equals(resultArray)); }
	 * 
	 * @Test public void testSplitStringIntoArrayDelimAngleBrackets2() { String
	 * testString = ">111111 2222 to 111111 2222"; StringParser sp = new
	 * StringParser(); ArrayList<String> resultArray =
	 * sp.splitStringIntoArrayDelimAngleBrackets(testString);
	 * 
	 * ArrayList<String> expectedArray = new ArrayList<String>();
	 * expectedArray.add(""); expectedArray.add("111111 2222 to 111111 2222");
	 * assertTrue("the arrays are not similar",
	 * expectedArray.equals(resultArray)); }
	 */

	@Test
	public void testExtractUserEventTask1() {
		String testString = "add this event >111111 2222 to 111111 2222";
		StringParser sp = new StringParser();
		String resultString = sp.extractUserEventTask(testString);
		String expectedString = "this event";

		assertTrue("the strings are not similar", expectedString.equals(resultString));
	}

	@Test
	public void testExtractUserEventTask2() {
		String testString = "search this event ";
		StringParser sp = new StringParser();
		String resultString = sp.extractUserEventTask(testString);
		String expectedString = "this event";

		assertTrue("the strings are not similar", expectedString.equals(resultString));
	}

	@Test
	public void testExtractUserDate1() {
		String testString = "add this event > 111111 2222 to 333333 4444";
		StringParser sp = new StringParser();
		String[] resultArray = sp.extractUserDate(testString);
		String[] expectedArray = { "111111", "333333" };

		assertArrayEquals(expectedArray, resultArray);
	}

	@Test
	public void testExtractUserDate2() {
		String testString = "add this event > 111111 2222 to 4444";
		StringParser sp = new StringParser();
		String[] resultArray = sp.extractUserDate(testString);
		String[] expectedArray = { "111111", null };

		assertArrayEquals(expectedArray, resultArray);
	}

	@Test
	public void testExtractUserDate3() {
		String testString = "add this event >111111 2222 to 333333 4444";
		StringParser sp = new StringParser();
		String[] resultArray = sp.extractUserDate(testString);
		String[] expectedArray = { "111111", "333333" };

		assertArrayEquals(expectedArray, resultArray);
	}
	
	@Test
	public void testExtractUserDate4() {
		String testString = "add this event > 1111 to 2222";
		StringParser sp = new StringParser();
		String[] resultArray = sp.extractUserDate(testString);
		String[] expectedArray = {null, null};

		assertArrayEquals(expectedArray, resultArray);
	}

	@Test
	public void testExtractUserTime1() {
		String testString = "add this event > 111111 2222 to 333333 4444";
		StringParser sp = new StringParser();
		String[] resultArray = sp.extractUserTime(testString);
		String[] expectedArray = { "2222", "4444" };

		assertArrayEquals(expectedArray, resultArray);
	}

	@Test
	public void testExtractUserTime2() {
		String testString = "add this event > 111111 2222 to 4444";
		StringParser sp = new StringParser();
		String[] resultArray = sp.extractUserTime(testString);
		String[] expectedArray = { "2222", "4444" };

		assertArrayEquals(expectedArray, resultArray);
	}

	@Test
	public void testExtractUserTime3() {
		String testString = "add this event > 2222 to 4444";
		StringParser sp = new StringParser();
		String[] resultArray = sp.extractUserTime(testString);
		String[] expectedArray = { "2222", "4444" };

		assertArrayEquals(expectedArray, resultArray);
	}
}
