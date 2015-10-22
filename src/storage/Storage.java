package storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import logic.Task;
import logic.State;

public class Storage {
	private static File _filepath = new File("FilePath.txt"); //file that store path location
	
	private File _file;
	private String _filename;
		
	public Storage(){
		if(!_filepath.exists()){
			initialSetup();
		} else {
			this._filename = new String(getFilePath());
			this._file = new File(_filename);
			StorageManager.checkFileExist(_file);
		}
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
		String str;
		try{
			str = new String(StorageManager.extractLine(_filepath));
			if(str.equals("")){
				str = new String("planner.txt");
			}
		} catch (NullPointerException e){
			str = new String("planner.txt");
		}
		return str;
	}
	
	public void setFilePath(String str){
		this._file = new File(this._filename);
		StorageManager.checkFileExist(_file);
		StorageManager.clearFile(_filepath);
		StorageManager.writeToFile(_file.getName(), _filepath);
	}
	
	/*****PRIVATE METHOD*****/
	private void initialSetup(){
		try {
			_filepath.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this._filename = new String("Planner.txt");
		this._file = new File(_filename);
		StorageManager.checkFileExist(_file);
	}

}
