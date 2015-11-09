//@@author A0130383N
package storage;

import logic.Task;

public class Formatter {

	// convert string to Task objects
	static Task strToTask(String string) {
		Task task;
		String[] str = string.split(" ", 5);
		if (str[3].equals("-")){
			if(str[2].equals("-")){
				task = new Task(Integer.valueOf(str[0]), str[1], "", "", str[4]);
			} else {
				task = new Task(Integer.valueOf(str[0]), str[1], str[2], "", str[4]);
			}
		} else {
			task = new Task(Integer.valueOf(str[0]), str[1], str[2], str[3], str[4]);
		}
		return task;
	}
}
