//@@author: idawatibustan
package logic;

public class Task {
	int _index;
	String _stats;
	String _date;
	String _time;
	String _details;

	/***** CONSTRUCTOR *****/
	public Task() {

	}

	public Task(String details) {
		this._index = 0;
		this._stats = "? ";
		this._time = "";
		this._date = "";
		this._details = details.trim();
	}

	public Task(String date, String details) {
		this(details);
		if (!date.equals("")){
			this._date = date.trim() + " ";
		}
	}

	public Task(String date, String time, String details) {
		this(date, details);
		if(!time.equals("")){
			this._time = time.trim() + " ";
		}
	}

	public Task(int index, String stat, String date, String time, String details) {
		if (date.equals("")) {
			this._date = date;
			this._time = time;
			this._details = details.trim();
		} else if (time.equals("")) {
			this._date = date.trim() + " ";
			this._time = time;
			this._details = details.trim();
		} else {
			this._date = date.trim() + " ";
			this._time = time.trim() + " ";
			this._details = details.trim();
		}
		this._index = index;
		this._stats = stat.trim() + " ";
	}

	/***** METHOD *****/
	public Task markDone() {
		this._stats = "@ ";
		return this;
	}
	
	public Task markUndone(){
		this._stats = "? ";
		return this;
	}

	@Override
	public String toString() {
		return _index + ") " + _date + _time + _details;
	}
	
	public String toStorage() {
		if(_time.equals("")){
			if(_date.equals("")){
				return _index + " " + _stats + "- - " + _details;
			}
			return _index + " " + _stats + _date + "- " + _details;
		}
		return _index + " " + _stats + _date + _time + _details;
	}
	
	public boolean equals(Task task) {
		return (this._stats.equals(task._stats) && this._time.equals(task._time) && this._date.equals(task._date)
				&& this._details.equals(task._details));
	}

	public String rotateDF() {
		if (_date.length() > 1) {
			String str = new String(this._date.substring(6, 8) + this._date.substring(2, 6) + this._date.substring(0, 2) + " ");
			return str;
		}
		return _date;
	}

	/***** GETTER *****/
	public int getIndex() {
		return _index;
	}

	public String getStatus() {
		return _stats;
	}

	public String getDate() {
		return _date;
	}

	public String getTime() {
		return _time;
	}

	public String getDetail() {
		return _details;
	}

	/***** SETTER *****/
	public void setIndex(int i) {
		_index = i;
	}

}