package planit;

import java.util.ArrayList;

public class Parser {

	public static ArrayList<String> toArrayList(String str) {
		String[] strArr = str.split(ParserConstants.REGEX_WHITESPACES);
		ArrayList<String> strArrList = new ArrayList<String>();
		for (String strTransfer : strArr) {
			strArrList.add(strTransfer);
		}
		return strArrList;
	}

	/*
	 * Returns the index of the first occurrence of the specified element in the
	 * String, or -1 if it does not contain the element.
	 */
	public static int indexOf(String[] arr, String str) {
		ArrayList<String> strArr = toArrayList(str.trim().toLowerCase());
		int index = strArr.size();
		for (String s : arr) {
			if (strArr.indexOf(s) < index && strArr.indexOf(s) != -1) {
				index = strArr.indexOf(s);
			}
		}
		if (index == strArr.size()) {
			return -1;
		} else {
			return index;
		}
	}

	/*
	 * Returns the index of the last occurrence of the specified element in the
	 * String, or -1 if it does not contain the element.
	 */
	public static int lastIndexOf(String[] arr, String str) {
		ArrayList<String> strArr = toArrayList(str.trim().toLowerCase());
		int index = -1;
		for (String s : arr) {
			if (strArr.lastIndexOf(s) > index && strArr.lastIndexOf(s) != -1) {
				index = strArr.lastIndexOf(s);
			}
		}
		if (index == -1) {
			return -1;
		} else {
			return index;
		}
	}

	public static boolean isPresent(String[] arr, String str) {
		ArrayList<String> strArr = toArrayList(str.trim().toLowerCase());
		for (String s : arr) {
			if (strArr.contains(s)) {
				return true;
			}
		}
		return false;
	}
}
