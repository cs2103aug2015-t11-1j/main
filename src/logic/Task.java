package logic;

public class Task {
	String _stats;
	String _date;
	String _time;
	String _details;
	
	/*****CONSTRUCTOR*****/
	public Task(){
	
	}
	
	public Task(String details){
		this._stats = "? ";
		this._time = "";
		this._date = "";
		this._details = details.trim();
	}
	
	public Task(String date, String details){
		this(details);
		this._date = date.trim() + " ";
	}
	
	public Task (String date, String time, String details){
		this(date, details);
		this._time = time.trim() + " ";
	}
	
	public Task (String stat, String date, String time, String details){
		if(date.equals("")){
			this._date = date;
			this._time = time;
			this._details = details.trim();
		} else if (time.equals("")){
			this._date = date.trim() + " ";
			this._time = time;
			this._details = details.trim();
		} else {
			this._date = date.trim() + " ";
			this._time = time.trim() + " ";
			this._details = details.trim();
		}
		this._stats = stat.trim() + " ";
	}
	
	/*****METHOD*****/
	public Task markDone(){
		this._stats = "@ ";
		return this;
	}
	
	@Override
	public String toString(){
		return _stats + _date + _time + _details;
	}
	
	public boolean equals(Task task){
		return (this._stats.equals(task._stats)
				&& this._time.equals(task._time)
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
	
//	public static String modifySign(String str){
//		if(str.equals("\u0023 ")){
//			return "\u2610 ";
//		}
//		if(str.equals("\u00B1 ")){
//			return"\u2611 ";
//		}
//		return str;
//	}
	
	/*****GETTER*****/
	public String getStatus(){
		return _stats;
	}
	
	public String getDate(){
		return _date;
	}
	
	public String getTime(){
		return _time;
	}
	
	public String getDetail(){
		return _details;
	}
	
}
