package planit;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTaskParserTest {

	@Test
	public void testEventTaskParser() {
		String test = "add meeting on monday from 1pm to 2pm";
		Parser parser = new Parser(test);
		
		EventTaskParser etp = new EventTaskParser(parser.getUserInputArray());
		String result = etp.getUserEventTask();
		String expected = "meeting";
		
		assertEquals(expected, result);
	}

}
