//@@author: idawatibustan A0130383N

package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import logic.Task;
import logic.State;

public class Storage {
	private static File _filepath = new File("FilePath.txt"); //file that store path location
	
	private static String _filename;
	static File _file;
	static State _tempState;
	
	public Storage(){
		Handler.checkFileExist(_filepath);
		_filename = new String(getFilePath());
		try{
			_file = new File(_filename);
		} catch (NullPointerException e){
			_file = new File("Planner.txt");
			setFilePath(_filename);
		}
		Handler.checkFileExist(_file);
		try{
			_tempState = new State(Handler.extractFile(_file));
		} catch (FileNotFoundException fe){
			recreateFile();
		}
	}
	
	/*****METHOD*****/
	//get current tasklist from file
	
	public State extractState(){
		ArrayList<Task> list = new ArrayList<Task>();
		try {
			list = Handler.extractFile(_file);
		} catch (FileNotFoundException fe){
			recreateFile();
		}
		_tempState = new State(list);
		return _tempState;
	}
	
	// change content of storage with current state
	public void update(State state){
		_tempState = state;
		try{
			Handler.clearFile(_file);
			Handler.writeToFile(state.getTaskList(), _file);
		} catch (FileNotFoundException fe){
			recreateFile();
		}
	}
	
	public String getFilePath(){
		String str = null;
		try{
			str = Handler.extractLine(_filepath);
			if(str.equals("")){
				str = new String("Planner.txt");
			}
		} catch (NullPointerException e){
			str = new String("Planner.txt");
		} catch (FileNotFoundException fe){
			recreateFile();
		}
		return str;
	}
	
	public String setFilePath(String str){
		int i = str.trim().length();
		try {
			if(str.substring(i-4).equals(".txt")){
				// change directory of main planner file
				File oldfile = _file;
				_filename = str;
				_file = new File(_filename);
				Handler.checkFileExist(_file);
			
				//change stored directory in FilePath.txt
				Handler.clearFile(_filepath);
				Handler.writeToFile(_file.getPath(), _filepath);
				Handler.deleteFile(oldfile);
				}
				return _file.getPath();
			} catch (FileNotFoundException fe){
				recreateFile();
			} catch (IndexOutOfBoundsException e){
				return _file.getPath();
			}
		return _file.getPath();
	}
	
	/*****PRIVATE METHOD*****/
	private void recreateFile(){
		_file = new File(_filename);
		try {
			Handler.writeToFile(_tempState.getTaskList() , _file);
		} catch (FileNotFoundException fe){
			recreateFile();
		}
	}

}
