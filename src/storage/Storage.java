package storage;

import java.io.File;
import java.util.ArrayList;

import logic.Task;
import logic.State;

public class Storage {
	private static File _filepath = new File("filepath.txt"); //file that store path location
	
	private File _file;
	private String _filename;
		
	public Storage(){
		StorageManager.checkFileExist(_filepath);
		this._filename = new String(getFilePath());
		if(this._filename == null){
			this._filename = "planner.txt";
		}
		setFilePath(this._filename);
	}
	
	/*****METHOD*****/
	//get current tasklist from file
	public State extractState(){
		ArrayList<Task> list = new ArrayList<Task>();
		list = StorageManager.extractFile(_file);
		return new State(list);
	}
	
	// change content of storage with current state
	public void update(State state){
		StorageManager.clearFile(_file);
		StorageManager.writeToFile(state.getTaskList(), _file);
	}
	
	public String getFilePath(){
		String str = new String(StorageManager.extractLine(_filepath));
		return str;
	}
	
	public void setFilePath(String str){
		this._file = new File(this._filename);
		StorageManager.checkFileExist(_file);
		StorageManager.clearFile(_filepath);
		StorageManager.writeToFile(_file.getAbsolutePath(), _filepath);
	}
	
	
}
