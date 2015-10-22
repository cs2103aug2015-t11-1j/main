package storage;

import java.util.ArrayList;

import logic.Task;

public class Output {
	private boolean _status;
	private String _entry;
	private ArrayList<Task> _results;
	private String _cmdType;

	/*********** CONSTRUCTOR **********/
	public Output(boolean status, String entry, String cmdType) {
		this._status = status;
		this._entry = entry;
		this._results = new ArrayList<Task>();
		this._cmdType = cmdType;
	}

	public Output(boolean status, ArrayList<Task> results, String cmdType) {
		this._status = status;
		this._entry = new String();
		this._results = results;
		this._cmdType = cmdType;
	}
	
	public Output(Output op){
		this.setStatus(op.getStatus());
		this.setEntry(op.getEntry());
		this.setResults(op.getResults());
		this.setCmdType(op.getCmdType());
	}

	/********** GETTER **********/
	public boolean getStatus() {
		return _status;
	}

	public String getEntry() {
		return _entry;
	}

	public ArrayList<Task> getResults() {
		return _results;
	}

	private String getCmdType() {
		return _cmdType;
	}
	
	/********** SETTER **********/
	public void setStatus(boolean status) {
		this._status = status;
	}

	public void setEntry(String entry) {
		this._entry = entry;
	}

	public void setResults(ArrayList<Task> results) {
		this._results = results;
	}

	public void setCmdType(String cmdType) {
		this._cmdType = cmdType;
		
	}

	/*****METHODS*****/
	public boolean equals(Output op) {
		return (this.getStatus() == op.getStatus()
				&& this.getEntry().equals(op.getEntry())
//				&& this.getResults().equals(op.getResults())
				);
	}
	
	
}
