package storage;

import java.util.ArrayList;

public class Output {
	private boolean _status;
	private String _entry;
	private ArrayList<String> _results;
	
	/***********CONSTRUCTOR**********/
	public Output(boolean status, String entry) {
		this._status = status;
		this._entry = entry;
	}
	
	public Output(boolean status, ArrayList<String> results){
		this._status = status;
		this._results = results;
	}
	
	/**********  GETTER   **********/
	public boolean getStatus(){
		return _status;
	}
	
	public String getEntry(){
		return _entry;
	}
	
	public ArrayList<String> getresults(){
		return _results;
	}
	
	/**********  SETTER  **********/
	public void setStatus(boolean status) {
		this._status = status;
	}
	
	public void setEntry(String entry) {
		this._entry = entry;
	}
	
	public void setResults(ArrayList<String> results) {
		this._results = results;
	}
}
