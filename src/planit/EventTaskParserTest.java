package planit;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTaskParserTest {

	@Test
	public void testEventTaskParser() {
		String test = "add meeting 12.30pm to 1am";
		Parser parser = new Parser(test);
		
		EventTaskParser etp = new EventTaskParser(parser.getUserInputArray());
		String result = etp.getUserEventTask();
		String expected = "meeting";
		
		assertEquals(expected, result);
	}

}
