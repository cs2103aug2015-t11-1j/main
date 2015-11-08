//@@author: idawatibustan A0130383N

package storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import logic.Task;

public class Handler {
	
	// catch IOException create file
	static void checkFileExist(File file) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			System.out.println("IOException: Can't create file. " + e.toString());
			e.printStackTrace();
		}
	}

	// write line to file
	static void writeToFile(String line, File file) throws FileNotFoundException {
		try {
			FileWriter w = new FileWriter(file, true);
			w.write(line);
			w.write(System.lineSeparator());
			w.close();
		} catch (IOException e) {
			System.out.println("IOException: Write to file. " + e.toString());
			e.printStackTrace();
		}
	}

	static void writeToFile(ArrayList<Task> list, File file) throws FileNotFoundException {
		try {
			FileWriter w = new FileWriter(file, true);
			for (Task task : list) {
				w.write(task.toStorage());
				w.write(System.lineSeparator());
			}
			w.close();
		} catch (IOException e) {
			System.out.println("IOException: Write to file. " + e.toString());
			e.printStackTrace();
		}
	}

	// extract first line of string from file
	static String extractLine(File file) throws FileNotFoundException {
		String str = new String();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			str = br.readLine();
			br.close();
		} catch (IOException e) {
			System.out.println("IOException: " + e.toString());
			e.printStackTrace();
		}
		return str;
	}

	// extract whole file into ArrayList of Task
	static ArrayList<Task> extractFile(File file) throws FileNotFoundException{
		ArrayList<Task> tasklist = new ArrayList<Task>();
		Task task;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			for (int i = 0; i < countEntry(file); i++) {
				task = Formatter.strToTask(br.readLine());
				tasklist.add(task);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("IOException: " + e.toString());
			e.printStackTrace();
		}
		return tasklist;
	}

	// clear file content
	static void clearFile(File file) throws FileNotFoundException {
		try {
			FileWriter fw = new FileWriter(file, false);
			fw.write("");
			fw.close();
		} catch (IOException e) {
			System.out.println("IOException: Can't clear file." + e.toString());
			e.printStackTrace();
		}
	}
	
	static void deleteFile(File file) {
		if(file.exists()){
			file.delete();
		}
	}

	// count lines in file
	private static int countEntry(File file) throws FileNotFoundException {
		int count = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while (br.readLine() != null) {
				count++;
			}
			br.close();
		} catch (IOException e) {
			System.out.println("IOException: Can't read file." + e.toString());
			e.printStackTrace();
		}
		return count;
	}
	
}