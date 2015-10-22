package parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class IndexParserTest {

	@Test
	public void testGetIndex1() {
		String test = "delete 1";
		int result = IndexParser.getIndex(test);
		int expected = 1;
		assertEquals(expected, result);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetIndex2() {
		String test = "delete ";
		IndexParser.getIndex(test);
	}
	
	@Test
	public void testGetIndex3() {
		String test = "update 2 this event";
		int result = IndexParser.getIndex(test);
		int expected = 2;
		assertEquals(expected, result);
	}
}