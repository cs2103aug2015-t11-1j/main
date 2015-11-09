//@@author A0130383N

package logic;

public class Task {

	private static final String SYMBOL_NUMBERING = ") ";
	private static final String SYMBOL_DONE = "@ ";
	private static final String SYMBOL_UNDONE = "? ";
	private static final String SYMBOL_EMPTY = "";
	private static final int IND_DD_START = 2;
	private static final int IND_YY_START = 6;
	private static final int IND_YY_END = 8;

	int _index;
	String _stats;
	String _date;
	String _time;
	String _details;

	/*********** CONSTRUCTOR **********/
	public Task() {

	}

	public Task(String details) {
		this._index = 0;
		this._stats = SYMBOL_UNDONE;
		this._time = SYMBOL_EMPTY;
		this._date = SYMBOL_EMPTY;
		this._details = details.trim();
	}

	public Task(String date, String details) {
		this(details);
		if (!date.equals(SYMBOL_EMPTY)) {
			this._date = date.trim() + " ";
		}
	}

	public Task(String date, String time, String details) {
		this(date, details);
		if (!time.equals(SYMBOL_EMPTY)) {
			this._time = time.trim() + " ";
		}
	}

	public Task(int index, String stat, String date, String time, String details) {
		if (date.equals(SYMBOL_EMPTY)) {
			this._date = date;
			this._time = time;
			this._details = details.trim();
		} else if (time.equals(SYMBOL_EMPTY)) {
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
		this._stats = SYMBOL_DONE;
		return this;
	}

	public Task markUndone() {
		this._stats = SYMBOL_UNDONE;
		return this;
	}

	@Override
	public String toString() {
		return _index + SYMBOL_NUMBERING + _date + _time + _details;
	}

	public String toStorage() {
		if (_time.equals(SYMBOL_EMPTY)) {
			if (_date.equals(SYMBOL_EMPTY)) {
				return _index + " " + _stats + "- "
						+ "- " + _details;
			}
			return _index + " " + _stats + _date + "- " + _details;
		}
		return _index + " " + _stats + _date + _time + _details;
	}

	public boolean equals(Task task) {
		return (this._stats.equals(task._stats) && this._time.equals(task._time)
				&& this._date.equals(task._date) && this._details.equals(task._details));
	}

	public String rotateDF() {
		if (getDate().length() > 1) {
			String str = new String(
					this._date.substring(IND_YY_START, IND_YY_END) + this._date.substring(IND_DD_START, IND_YY_START)
							+ this._date.substring(0, IND_DD_START) + " ");
			return str;
		}
		return getDate();
	}

	/********** GETTER **********/
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

	/********** SETTER **********/
	public void setIndex(int i) {
		_index = i;
	}

}