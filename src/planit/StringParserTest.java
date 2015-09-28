package planit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class StringParserTest {

	@Test
	public void testStringParserUserCommand1() {
		String testString = "this is a test string";
		StringParser sp = new StringParser(testString);
		String resultString = sp.extractUserCommand(sp.splitStringIntoArrayDelimSpace(testString));
		
		assertTrue("first word is incorrect", resultString.equals("this"));
	}
	
	@Test
	public void testStringParserUserCommand2() {
		String testString = "thisisateststring";
		StringParser sp = new StringParser(testString);
		String resultString = sp.extractUserCommand(sp.splitStringIntoArrayDelimSpace(testString));
		
		assertTrue("first word is incorrect", resultString.equals("thisisateststring"));
	}
	
	@Test
	public void testStringParserUserCommand3() {
		String testString = "";
		StringParser sp = new StringParser(testString);
		String resultString = sp.extractUserCommand(sp.splitStringIntoArrayDelimSpace(testString));
		
		assertTrue("first word is incorrect", resultString.equals(""));
	}
	
	@Test
	public void testSplitStringIntoArrayDelimColon1() {
		String testString = "add this event :1111 2222 - 1111 2222";
		StringParser sp = new StringParser(testString);
		ArrayList<String> resultArray = sp.splitStringIntoArrayDelimColon(testString);
		
		ArrayList<String> expectedArray = new ArrayList<String>();
		expectedArray.add("1111");
		expectedArray.add("2222");
		expectedArray.add("-");
		expectedArray.add("1111");
		expectedArray.add("2222");
		assertTrue("the arrays are not similar", expectedArray.equals(resultArray));
	}
	
	@Test
	public void testSplitStringIntoArrayDelimColon2() {
		String testString = ":1111 2222 - 1111 2222";
		StringParser sp = new StringParser(testString);
		ArrayList<String> resultArray = sp.splitStringIntoArrayDelimColon(testString);
		
		ArrayList<String> expectedArray = new ArrayList<String>();
		expectedArray.add("1111");
		expectedArray.add("2222");
		expectedArray.add("-");
		expectedArray.add("1111");
		expectedArray.add("2222");
		assertTrue("the arrays are not similar", expectedArray.equals(resultArray));
	}
	
	@Test
	public void testExtractUserEventTask() {
		String testString = "add this event :1111 2222 - 1111 2222";
		StringParser sp = new StringParser(testString);
		String resultString = sp.extractEventTask(sp.splitStringIntoArrayDelimColon(testString));
		
		String expectedString = "this event";
		
		assertTrue("the strings are not similar", expectedString.equals(resultString));
	}

}
