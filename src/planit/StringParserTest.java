package planit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class StringParserTest {

	@Test
	public void testStringParserUserCommand1() {
		String testString = "this is a test string";
		ArrayList<String> testStringArray = new ArrayList<String>();
		StringParser sp = new StringParser();
		testStringArray = sp.splitStringIntoArray(testString);
		String resultString = sp.extractUserCommand(testStringArray);
		
		assertTrue("this was extracted", resultString.equals("this"));
	}
	
	@Test
	public void testStringParserUserCommand2() {
		String testString = "thisisateststring";
		ArrayList<String> testStringArray = new ArrayList<String>();
		StringParser sp = new StringParser();
		testStringArray = sp.splitStringIntoArray(testString);
		String resultString = sp.extractUserCommand(testStringArray);
		
		assertTrue("this was extracted", resultString.equals("thisisateststring"));
	}
	
	@Test
	public void testStringParserUserCommand3() {
		String testString = "";
		ArrayList<String> testStringArray = new ArrayList<String>();
		StringParser sp = new StringParser();
		testStringArray = sp.splitStringIntoArray(testString);
		String resultString = sp.extractUserCommand(testStringArray);
		
		assertTrue("this was extracted", resultString.equals(""));
	}

}
