package planit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {
	private String mainFileName;
	private File mainFile;
	private String toDoFileName;
	private File toDoFile;
	
	public Storage(){
		mainFile = new File("main.txt");
		this.checkFileExist(mainFile);
		mainFileName = "main.txt";
		toDoFile = new File("todo.txt");
		this.checkFileExist(toDoFile);
		mainFileName = "todo.txt";
	}
	
	FileWriter fwMain = new FileWriter(this.mainFile, true);
	FileWriter fwTodo= new FileWriter(this.toDoFile, true);
	
	//
	public static String storeNewEvent(Command userCommand) {
//		String item = userCommand.
		if(userCommand.getUserTimeStart().equals("null")){
			
		} else {
			
		}
		return null;
		// TODO Auto-generated method stub
		// Return String with <event><dateString><timeString>
	}

	public static String searchCommandParam(String userEventTask) {
		// TODO Auto-generated method stub
		return null;
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
	
}
