package storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import logic.Task;
import logic.State;

public class Storage {
	private File _file;
	private String _filename;
	private int _numEntry;
	private File _filepath; //file that store path location
		
	public Storage(){
		this._filepath = new File("path.txt");
		checkFileExist(_filepath);
		this._filename = StorageManager.getFilePath(_filepath);
		checkFileExist(_file);
		this._file = new File(_filename);
	}
	
	/*****METHOD*****/
	//get current tasklist from file
	public State extractState(){
		ArrayList<Task> list = new ArrayList<Task>();
		//TODO
		return new State(list);
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
}
