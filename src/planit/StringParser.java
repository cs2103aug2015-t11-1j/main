/*
 * @author: Jeston Teo
 * 
 * This class parses an entire string command into its respective <categories>
 * ASSUMPTIONS:
 * 1) Commands are entered in this general format: <command> <event> <date> <time>
 * TODO  
 */

package planit;

import java.util.ArrayList;
import java.util.Arrays;

public class StringParser {
	
	private static final String REGEX_WHITESPACES = "[\\s,]+";
	
	/*
	 * CONSTRUCTORS
	 */
	public StringParser() {
		
	}
	
	public ArrayList<String> splitStringIntoArray(String userStringInput) {
		String[] stringSplitArray = userStringInput.trim().split(REGEX_WHITESPACES);
		return new ArrayList<String>(Arrays.asList(stringSplitArray));
	}
	
	public String extractUserCommand(ArrayList<String> stringArray) {
		return stringArray.get(0);
	}
}
