package planit;

import java.util.ArrayList;

public class Parser {
	
	private String userInput;
	private ArrayList<String> userInputArray;
	
	public Parser(String str) {
		this.userInput = str;
		userInputArray = stringToArrayList();
	}
	
	private ArrayList<String> stringToArrayList() {
		String[] strArr = userInput.split(ParserConstants.REGEX_WHITESPACES);
		ArrayList<String> strArrList = new ArrayList<String>();
		for (String strTransfer : strArr) {
			strArrList.add(strTransfer);
		}
		return strArrList;
	}
	
	public String getUserInput() {
		return this.userInput;
	}
	
	public ArrayList<String> getUserInputArray() {
		return this.userInputArray;
	}
}
