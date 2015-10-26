package ui;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;

public class JUnitTest {
	
	@Test
	public void testPrintMessage() throws IOException {
		
		
		String actualString = Welcome.printMessage(Welcome.initiateProg());
		String expectedString = "Success! meeting tmr is added to your schedule:)";
		
		assertEquals(expectedString, actualString);
		
		
	}
	
	}



