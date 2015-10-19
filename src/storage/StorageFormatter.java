package storage;

import java.util.ArrayList;

public class StorageFormatter {
	public static String formatAdd(String details, ArrayList<String> date, ArrayList<String> time){
		String str;
		switch(date.size()){
		case 0:
			str = new String("??/??/?? " + details);
			break;
		case 1:
			str = formatDefault(details, date, time);
			break;
		case 2:
			str = formatRange(details, date, time);
			break;
		default:
			str = new String();
		}
		return str;
	}
	
	public static String formatDefault(String details, ArrayList<String> date, ArrayList<String> time){
		String str;
		switch(time.size()){
		case 0:
			str = new String(date + " " + details);
			break;
		case 1:
			str = new String(date + " " + time.get(0) + " " + details);
			break;
		case 2:
			str = new String(date + " " + time.get(0) + "-" + time.get(1) + " " + details);
			break;
		default:
			str = new String(date + " " + time.get(0) + " " + details);
		}
		return str;
	}
	
	public static String formatRange(String details, ArrayList<String> date, ArrayList<String> time){
		String str = new String();
		//TODO
		return str;
	}
}
