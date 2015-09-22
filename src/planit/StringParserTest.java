package planit;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringParserTest {

	@Test
	public void testStringParserUserCommand1() {
		String testString = "this is a test string";
		StringParser sp = new StringParser();
		String resultString = sp.extractUserCommand(testString);
		
		assertTrue("this was extracted", resultString.equals("this"));
	}
	
	@Test
	public void testStringParserUserCommand2() {
		String testString = "thisisateststring";
		StringParser sp = new StringParser();
		String resultString = sp.extractUserCommand(testString);
		
		assertTrue("this was extracted", resultString.equals("thisisateststring"));
	}
	
	@Test
	public void testStringParserUserCommand3() {
		String testString = "";
		StringParser sp = new StringParser();
		String resultString = sp.extractUserCommand(testString);
		
		assertTrue("this was extracted", resultString.equals(""));
	}

}
