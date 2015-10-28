package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Strge {
	private static File _file;
	private String _fileName;
	private int _entryCount;

	/*****CONSTRUCTOR*****/
	public Strge(){
	}
	

	/***** MAIN FEATURES METHOD *****/
	public ArrayList<String> searchCommandKey(String key) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> list = extract(_file);
		int count = 0;
		while (count < this._entryCount) {
			if (list.get(count).toLowerCase().contains(key.toLowerCase())) {
				result.add(list.get(count));
			}
			count++;
		}
		return displayFormat(result);
	}

	public ArrayList<String> showDateEvents(String key) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> list = extract(_file);
		int count = 0;
		while (count < this._entryCount) {
			if (list.get(count).contains(changeDDMMYY(key))) {
				result.add(list.get(count));
			}
			count++;
		}
		return displayFormat(result);
	}

	// return array of entries containing key
	// delete only if array size is 1
	public ArrayList<String> deleteTask(String key) {
		ArrayList<String> list = extract(_file);
		ArrayList<String> result = searchCommandKey(key);
		if(result.size()==1){
			list.remove(list.indexOf(result.get(0)));
			clearFile(_file);
			writeToFile(list, _file);
			_entryCount--;
		}
		return displayFormat(result);
	}

	public ArrayList<String> markDone(String completeTask) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<String> updateEvent(String eventToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/***** PRIVATE METHODS *****/
	// catch IOException create file
	private void checkFileExist(File file) {
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
	private void writeToFile(String line, File file) {
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
	
	private void writeToFile(ArrayList<String> list, File file) {
		Collections.sort(list);
		try {
			clearFile(file);
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			for(String line : list){
				pw.write(line);
				pw.write(System.lineSeparator());
			}
			pw.close();
			_entryCount = list.size();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	// extract lines in file into list
	private ArrayList<String> extract(File file) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			int count = 0;
			while (count < this._entryCount) {
				list.add(br.readLine());
				count++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO
			e.printStackTrace();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
		Collections.sort(list);
		return list;
	}
	
	// clear this file content
	private void clearFile(File file){
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

	// change DD/MM/YY to YY/MM/DD and otherwise
	private static String changeDDMMYY(String date) {
		date = date.substring(6, 8) + date.substring(2, 6) + date.substring(0, 2);
		return date;
	}

	private static String displayFormat(String line) {
		line = changeDDMMYY(line.substring(0, 8)) + line.substring(8);
		return line;
	}

	private static ArrayList<String> displayFormat(ArrayList<String> list){
		for(String line : list)
		{
			line = displayFormat(line);
		}
		return list;
	}

	//change file name
	public void changeFileName(String fileName){
		this._fileName = fileName;
		
		File oldFile = _file;
		File newFile = new File(_fileName);
		checkFileExist(newFile);
		writeToFile(extract(oldFile), newFile);
		_file = newFile;
		oldFile.delete();
	}
	
}
