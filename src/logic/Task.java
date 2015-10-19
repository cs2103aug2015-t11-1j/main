package logic;

public class Task {
	private String _date;
	private String _time;
	private String _details;
	
	/*****CONSTRUCTOR*****/
	public Task(){
	
	}
	
	public Task(String details){
		this._details = details;
	}
	
	public Task(String date, String details){
		this(details);
		this._date = date.trim() + " ";
	}
	
	public Task (String date, String time, String details){
		this(date, details);
		this._time = time.trim() + " ";
	}
	
	/*****METHOD*****/
	public String toString(){
		return _date + _time + _details;
	}
	
}
