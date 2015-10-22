package storage;

import java.util.ArrayList;

public class Output {
	private boolean _status;
	private String _entry;
	private ArrayList<String> _results;
	private String _cmdType;

	/*********** CONSTRUCTOR **********/
	public Output(boolean status, String entry, String cmdType) {
		this._status = status;
		this._entry = entry;
		this._cmdType = cmdType;
	}

	public Output(boolean status, ArrayList<String> results, String cmdType) {
		this._status = status;
		this._results = results;
		this._cmdType = cmdType;
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

	public String get_cmdType() {
		return _cmdType;
	}

	
	/********** SETTER **********/
	public void setStatus(boolean status) {
		this._status = status;
	}

	public void setEntry(String entry) {
		this._entry = entry;
	}

	public void setResults(ArrayList<String> results) {
		this._results = results;
	}
	
	public void set_cmdType(String _cmdType) {
		this._cmdType = _cmdType;
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
