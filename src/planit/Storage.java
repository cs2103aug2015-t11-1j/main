package planit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
		mainFileName = "main.txt";
		toDoFile = new File("todo.txt");
		this.checkFileExist(toDoFile);
		mainFileName = "todo.txt";
	}
	
	
	//
	public String storeNewEvent(Command cmd) throws IOException {
//		String item = userCommand.
		if(cmd.getUserDateString().equals(null) && cmd.getUserTimeString().equals(null)){
			FileWriter fwTodo= new FileWriter(toDoFile, true);
			fwTodo.write(cmd.getUserEventTask());
			fwTodo.write(System.lineSeparator());
			fwTodo.close();
			return cmd.getUserEventTask();
		} else {
			String line = new String(cmd.getUserDateString() + " " + cmd.getUserTimeString() + " " + cmd.getUserEventTask());
			FileWriter fwMain = new FileWriter(mainFile, true);
			BufferedWriter bwMain = new BufferedWriter(fwMain);
			PrintWriter pwMain = new PrintWriter(bwMain);
			pwMain.write(line);
			pwMain.write(System.lineSeparator());
			pwMain.close();
			return line;
		}
	}

	public ArrayList<String> searchCommandParam(String userEventTask) {
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
	
	private String changeToYYMMDD(String date){
		date = date.substring(4,6) + date.substring(2,3) + date.substring(0, 2);
		return date;
	}
	
}
