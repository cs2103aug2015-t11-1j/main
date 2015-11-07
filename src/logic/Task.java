//@@author: idawatibustan

package logic;

public class Task {

	private static final String MESSAGE_SYMBOL_INDEX_BRACKET = ") ";
	private static final String MESSAGE_SYMBOL_DONE_TASK = "@ ";
	private static final String MESSAGE_SYMBOL_SPACE = " ";
	private static final String MESSAGE_SYMBOL_NOTHING = "";
	private static final String MESSAGE_SYMBOL_UNDONE_TASK = "? ";
	private static final String MESSAGE_SYMBOL_HYPHEN = "-";
	private static final String MESSAGE_SYMBOL_HYPHEN_SPACE = MESSAGE_SYMBOL_HYPHEN + MESSAGE_SYMBOL_SPACE;
	private static final int INT_ZERO = 0;
	private static final int INT_ONE = 1;
	private static final int INT_TWO = 2;
	private static final int INT_SIX = 6;
	private static final int INT_EIGHT = 8;

	int _index;
	String _stats;
	String _date;
	String _time;
	String _details;

	/*********** CONSTRUCTOR **********/
	public Task() {

	}

	public Task(String details) {
		this._index = INT_ZERO;
		this._stats = MESSAGE_SYMBOL_UNDONE_TASK;
		this._time = MESSAGE_SYMBOL_NOTHING;
		this._date = MESSAGE_SYMBOL_NOTHING;
		this._details = details.trim();
	}

	public Task(String date, String details) {
		this(details);
		if (!date.equals(MESSAGE_SYMBOL_NOTHING)) {
			this._date = date.trim() + MESSAGE_SYMBOL_SPACE;
		}
	}

	public Task(String date, String time, String details) {
		this(date, details);
		if (!time.equals(MESSAGE_SYMBOL_NOTHING)) {
			this._time = time.trim() + MESSAGE_SYMBOL_SPACE;
		}
	}

	public Task(int index, String stat, String date, String time, String details) {
		if (date.equals(MESSAGE_SYMBOL_NOTHING)) {
			this._date = date;
			this._time = time;
			this._details = details.trim();
		} else if (time.equals(MESSAGE_SYMBOL_NOTHING)) {
			this._date = date.trim() + MESSAGE_SYMBOL_SPACE;
			this._time = time;
			this._details = details.trim();
		} else {
			this._date = date.trim() + MESSAGE_SYMBOL_SPACE;
			this._time = time.trim() + MESSAGE_SYMBOL_SPACE;
			this._details = details.trim();
		}
		this._index = index;
		this._stats = stat.trim() + MESSAGE_SYMBOL_SPACE;
	}

	/***** METHOD *****/
	public Task markDone() {
		this._stats = MESSAGE_SYMBOL_DONE_TASK;
		return this;
	}

	public Task markUndone() {
		this._stats = MESSAGE_SYMBOL_UNDONE_TASK;
		return this;
	}

	@Override
	public String toString() {
		return _index + MESSAGE_SYMBOL_INDEX_BRACKET + _date + _time + _details;
	}

	public String toStorage() {
		if (_time.equals(MESSAGE_SYMBOL_NOTHING)) {
			if (_date.equals(MESSAGE_SYMBOL_NOTHING)) {
				return _index + MESSAGE_SYMBOL_SPACE + _stats + MESSAGE_SYMBOL_HYPHEN_SPACE
						+ MESSAGE_SYMBOL_HYPHEN_SPACE + _details;
			}
			return _index + MESSAGE_SYMBOL_SPACE + _stats + _date + MESSAGE_SYMBOL_HYPHEN_SPACE + _details;
		}
		return _index + MESSAGE_SYMBOL_SPACE + _stats + _date + _time + _details;
	}

	public boolean equals(Task task) {
		return (this._stats.equals(task._stats) && this._time.equals(task._time) && this._date.equals(task._date)
				&& this._details.equals(task._details));
	}

	public String rotateDF() {
		if (_date.length() > INT_ONE) {
			String str = new String(this._date.substring(INT_SIX, INT_EIGHT) + this._date.substring(INT_TWO, INT_SIX)
					+ this._date.substring(INT_ZERO, INT_TWO) + MESSAGE_SYMBOL_SPACE);
			return str;
		}
		return _date;
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