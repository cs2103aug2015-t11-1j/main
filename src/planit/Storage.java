package planit;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Storage {
	private String mainFileName;
	private static File mainFile;
	private String toDoFileName;
	private static File toDoFile;
	
	public Storage(){
		mainFile = new File("main.txt");
		this.checkFileExist(mainFile);
		setMainFileName("main.txt");
		toDoFile = new File("todo.txt");
		this.checkFileExist(toDoFile);
		setMainFileName("todo.txt");
	}
	
	
	//
	public String storeNewEvent(Command cmd) throws IOException {
		String line = new String(changeDDMMYY(cmd.getUserDateString()) + " " + cmd.getUserTimeString() + " " + cmd.getUserEventTask());
		writeToFile(line, mainFile);
		return line;
	}

	public ArrayList<String> searchCommandKey(String userEventTask) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		return list;
	}

	public static void deleteTask(String taskToDelete) {
		// TODO Auto-generated method stub
		
	}

	//catch IOException create file
	private void checkFileExist(File file) {
		try{
			if(!file.exists()){
				file.createNewFile();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//write line to file
	private void writeToFile(String line, File file){
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
	
	//change DD/MM/YY to YY/MM/DD and otherwise
	private static String changeDDMMYY(String date){
		date = date.substring(6,8) + date.substring(2,6) + date.substring(0, 2);
		return date;
	}


	public ArrayList<String> showDateEvents(String userDateString) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		return list;
	}


	public String getMainFileName() {
		return mainFileName;
	}


	public void setMainFileName(String mainFileName) {
		this.mainFileName = mainFileName;
	}


	public String getToDoFileName() {
		return toDoFileName;
	}


	public void setToDoFileName(String toDoFileName) {
		this.toDoFileName = toDoFileName;
	}
	
	
}
