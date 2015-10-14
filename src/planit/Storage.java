package planit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Storage {
	private static File mainFile;
	private String mainFileName;
	private int mainCount;

	public Storage() throws IOException {
		mainFile = new File("main.txt");
		this.checkFileExist(mainFile);
		setMainFileName("main.txt");
		mainCount = lineCounter(mainFile);
	}

	/***** MAIN FEATURES METHOD *****/
	// write new event or task into file
	public String storeNewEvent(Command cmd) throws IOException {
		String line = new String(changeDDMMYY(cmd.getDateString() + " " + cmd.getTimeString() + " " + cmd.getUserEventTask()));
		writeToFile(line, mainFile);
		mainCount++;
		return line;
	}

	public ArrayList<String> searchCommandKey(String key) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> list = extract(mainFile);
		int count = 0;
		while (count < this.mainCount) {
			if (list.get(count).toLowerCase().contains(key.toLowerCase())) {
				result.add(changeDFinLine(list.get(count)));
			}
			count++;
		}
		return result;
	}

	public ArrayList<String> showDateEvents(String key) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> list = extract(mainFile);
		int count = 0;
		while (count < this.mainCount) {
			if (list.get(count).contains(changeDDMMYY(key))) {
				result.add(changeDFinLine(list.get(count)));
			}
			count++;
		}
		return result;
	}

	public ArrayList<String> deleteTask(String key) {
		ArrayList<String> result = searchCommandKey(key);
		
		return result;
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
		PrintWriter pwMain;
		try {
			pwMain = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			pwMain.write(line);
			pwMain.write(System.lineSeparator());
			pwMain.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<String> extract(File file) {
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			int count = 0;
			while (count < this.mainCount) {
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
		return list;
	}

	// count lines in file
	private static int lineCounter(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		int lineCount = 0;
		while (br.readLine() != null) {
			lineCount++;
		}
		br.close();
		return lineCount;
	}

	// change DD/MM/YY to YY/MM/DD and otherwise
	private static String changeDDMMYY(String date) {
		date = date.substring(6, 8) + date.substring(2, 6) + date.substring(0, 2);
		return date;
	}

	private static String changeDFinLine(String line) {
		line = changeDDMMYY(line.substring(0, 8)) + line.substring(8);
		return line;
	}

	/***** GETTERS & SETTERS *****/
	public String getMainFileName() {
		return mainFileName;
	}

	public void setMainFileName(String mainFileName) {
		this.mainFileName = mainFileName;
	}

	public ArrayList<String> markDone(String completeTask) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> updateEvent(String eventToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
