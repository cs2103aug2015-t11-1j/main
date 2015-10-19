package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ParserTest {

	// Dummy tests
	
	@Test
	public void test() {
		String[] arr = { "today" };
		String str = "TODAY";
		System.out.println(Parser.isPresent(arr, str));
	}

	@Test
	public void test1() {
		String test = "add event from 210493 to 210493";
		// ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> arr = Parser.toArrayList(test, ParserConstants.CHAR_SINGLE_WHITESPACE);
		for (int i = 0; i < 3; i++) {
			arr.remove(0);
		}
		for (int i = 1; i < arr.size();) {
			arr.remove(i);
		}
		System.out.println(arr.toString());
	}
	
	@Test
	public void test2() {
		String test = "ADD SUBMIT ASSIGNMENT BY 210493";
		String result1 = DateParser.getStartDate(test);
		String result2 = DateParser.getEndDate(test);
		
		System.out.println(result1);
		System.out.println(result2);
	}
	
	@Test
	public void test3() {
		String test = "add this > 210493 02:00 to 220493 03:00";
		
		System.out.println(DateParser.getStartDate(test));
		System.out.println(DateParser.getEndDate(test));
		System.out.println(TimeParser.getStartTime(test));
		System.out.println(TimeParser.getEndTime(test));
	}
}
