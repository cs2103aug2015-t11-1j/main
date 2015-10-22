package logic;

public class Task {
	String _date;
	String _time;
	String _details;
	
	/*****CONSTRUCTOR*****/
	public Task(){
	
	}
	
	public Task(String details){
		this._time = "";
		this._date = "";
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
	@Override
	public String toString(){
		return _date + _time + _details;
	}
	
	@Override
	public boolean equals(Task task){
		return (this._time.equals(task._time)
				&& this._date.equals(task._date)
				&& this._details.equals(task._details));
	}
	
	public String rotateDF(){
		if(_date.length() > 0){
			String str = new String(this._date.substring(6, 8) + this._date.substring(2, 6) + this._date.substring(0, 2) + " ");
			return str;
		}
		return _date;
	}
}
