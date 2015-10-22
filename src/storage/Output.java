package storage;

import java.util.ArrayList;

public class Output {
	private boolean _status;
	private String _entry;
	private ArrayList<Task> _results;

	/*********** CONSTRUCTOR **********/
	public Output(boolean status, String entry) {
		this._status = status;
		this._entry = entry;
		this._results = new ArrayList<Task>();
	}

	public Output(boolean status, ArrayList<Task> results) {
		this._status = status;
		this._results = results;
		this._entry = new String();
	}
	
	public Output(Output op){
		
	}

	/********** GETTER **********/
	public boolean getStatus() {
		return _status;
	}

	public String getEntry() {
		return _entry;
	}

	public ArrayList<String> getresults() {
		return _results;
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

	public boolean equals(Object obj) {
		
		if (obj instanceof Output) {
			Output op = (Output) obj;
			return (this.getStatus() == op.getStatus() && this.getEntry().equals(op.getEntry()));
		} else {
			return false;
		}
	}
}
