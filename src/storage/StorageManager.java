package storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import logic.Task;

public class StorageManager {

	// catch IOException create file
	protected static void checkFileExist(File file) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
	}

	// write line to file
	static void writeToFile(String line, File file) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			pw.write(line);
			pw.write(System.lineSeparator());
			pw.close();
		} catch (IOException e) {
			//TODO
			e.printStackTrace();
		}
	}
	
	static void writeToFile(ArrayList<Task> list, File file) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			for(Task task : list){
				pw.write(task.toString());
				pw.write(System.lineSeparator());
			}
			pw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	// extract one line of string from file
	static String extractLine(File file){
		String str = new String();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			str = br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			//TODO
			e.printStackTrace();
		} catch (IOException e) {
			//TODO
			e.printStackTrace();
		}
		return str;
	}

	// extract whole file into ArrayList of Task
	static ArrayList<Task> extractFile(File file){
		ArrayList<Task> tasklist = new ArrayList<Task>();
		Task task;
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			for(int i = 0; i < countEntry(file); i++){
				task = strToTask(br.readLine());
				tasklist.add(task);
			}
			br.close();
		} catch (FileNotFoundException e) {
			//TODO
			e.printStackTrace();
		} catch (IOException e) {
			//TODO
			e.printStackTrace();
		}
		return tasklist;
	}

	//clear file content
	protected static void clearFile(File file){
		try{
			FileWriter fw = new FileWriter(file, false);
			fw.write("");
			fw.close();
		}
		catch(IOException e){
			//TODO
			e.printStackTrace();
		}
	}
		
	// count lines in file
	private static int countEntry(File file) {
		int count = 0;
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			while (br.readLine() != null) {
				count++;
			}
			br.close();
		}
		catch(IOException e){
			//TODO
			e.printStackTrace();
		}
		return count;
	}

	// convert string to Task objects
	private static Task strToTask(String string){
		Task task;
		String[] str = string.split(" ", 4);
		if(str[2].length() == 4 && Integer.valueOf(str[2].substring(0, 4)) <= 2400){
			task = new Task(str[0], str[1], str[2], str[3]);
		} else if(str[1].length() == 8 && Integer.valueOf(str[1].substring(0, 2)) <= 31){
			task = new Task(str[0], str[1], "", str[2]+" "+str[3]);
		} else {
			task = new Task(str[0], "", "", str[1]+" "+str[2]+" "+str[3]);
			//TODO in case of change of signs
		}
		return task;
	}

}
