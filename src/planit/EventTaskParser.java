package planit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventTaskParser {

	private ArrayList<String> userEventTaskArr;
	private String userEventTask;

	public EventTaskParser(ArrayList<String> strArr) {
		userEventTaskArr = strArr;
		userEventTask = extractEventTask();
	}

	private String extractEventTask() {
		userEventTaskArr.remove(ParserConstants.INDEX_FIRST);
		List<String> list = Arrays.asList(ParserConstants.KW_TIMEFRAMES);
		userEventTaskArr.removeAll(list);

		String strReturn = ParserConstants.CHAR_SINGLE_BLANK;
		for (String str : userEventTaskArr) {
			strReturn = strReturn + ParserConstants.CHAR_SINGLE_WHITESPACE + str;
		}
		return strReturn.trim();
	}

	public String getUserEventTask() {
		return this.userEventTask;
	}
}
