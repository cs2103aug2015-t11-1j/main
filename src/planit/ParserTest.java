package planit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {

	// Dummy test
	@Test
	public void test() {
		String[] arr = {"today"};
		String str = "TODAY";
		System.out.println(Parser.isPresent(arr, str));
	}
}
