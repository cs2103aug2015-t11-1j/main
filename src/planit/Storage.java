package planit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {
	private String mainFileName;
	private static File mainFile;
	private String toDoFileName;
	private static File toDoFile;
	
	public Storage(){
		mainFile = new File("main.txt");
		this.checkFileExist(mainFile);
		mainFileName = "main.txt";
		toDoFile = new File("todo.txt");
		this.checkFileExist(toDoFile);
		mainFileName = "todo.txt";
	}
	
	
	//
	public static String storeNewEvent(Command cmd) throws IOException {
//		String item = userCommand.
		if(cmd.getUserDateString().equals(null) && cmd.getUserTimeString().equals(null)){
			FileWriter fwTodo= new FileWriter(toDoFile, true);
			fwTodo.write(cmd.getUserEventTask());
			fwTodo.write(System.lineSeparator());
			fwTodo.close();
			return cmd.getUserEventTask();
		} else {
			// TODO Auto-generated method stub
			// Return String with <event><dateString><timeString>
			String line = new String(cmd.getUserDateString() + " " + cmd.getUserTimeString() + " " + cmd.getUserEventTask());
			FileWriter fwMain = new FileWriter(mainFile, true);
			fwMain.write(line);
			fwMain.write(System.lineSeparator());
			fwMain.close();
			return line;
		}
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
