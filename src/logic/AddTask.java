//@@author A0130383N

package logic;

import java.util.ArrayList;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import storage.Output;

public class AddTask implements Command {

	private static final String MESSAGE_SYMBOL_NOTHING = "";
	private static final String MESSAGE_SYMBOL_HYPHEN = "-";
	private static final String MESSAGE_SYMBOL_SPACE = " ";
	private static final String MESSAGE_HYPHEN_WITH_SPACE = MESSAGE_SYMBOL_SPACE + MESSAGE_SYMBOL_HYPHEN + MESSAGE_SYMBOL_SPACE;
	private static final String MESSAGE_DATE_FORMAT = "dd/MM/yy";
	private static final String MESSAGE_TASK_TYPE = "add";
	private static final String MESSAGE_END_OF_DAY = MESSAGE_SYMBOL_HYPHEN + "2359";
	private static final String MESSAGE_START_OF_DAY = "0000" + MESSAGE_SYMBOL_HYPHEN;
	private static final String MESSAGE_DATE_ADDED = "date added";
	private static final int INDEX_ZERO = 0;
	private static final int INDEX_ONE = 1;

	private String eventTask;
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	private State currState = new State(new ArrayList<Task>());

	/*********** CONSTRUCTOR **********/
	public AddTask() {

	}

	@Override
	public Output execute() {
		ArrayList<Task> tasklist = createTask();
		updateCurrState(tasklist);
		if (tasklist.size() == INDEX_ONE) {
			return new Output(true, tasklist.get(INDEX_ZERO).toString(), MESSAGE_TASK_TYPE);
		}
		return new Output(true, this.longString(), MESSAGE_TASK_TYPE);
	}

	private void updateCurrState(ArrayList<Task> tasklist) {
		for (Task task : tasklist) {
			this.currState.add(task);
		}
		this.currState.sort();
	}

	private ArrayList<Task> createTask() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		if (date.get(INDEX_ZERO).equals(MESSAGE_SYMBOL_NOTHING)) {
			tasks.add(new Task(this.eventTask));
			return tasks;
		} else if (date.get(INDEX_ONE).equals(MESSAGE_SYMBOL_NOTHING)) {
			tasks.add(this.createTask(this.date.get(INDEX_ZERO)));
			return tasks;
		} else {
			return this.createTask(this.date.get(INDEX_ZERO), this.date.get(INDEX_ONE));
		}
	}

	private Task createTask(String date) {
		if (time.get(INDEX_ZERO).equals(MESSAGE_SYMBOL_NOTHING)) {
			return new Task(date, this.eventTask);
		} else if (time.get(INDEX_ONE).equals(MESSAGE_SYMBOL_NOTHING)) {
			return new Task(date, this.time.get(INDEX_ZERO), this.eventTask);
		} else {
			return new Task(date, this.time.get(INDEX_ZERO) + MESSAGE_SYMBOL_HYPHEN + this.time.get(INDEX_ONE),
					this.eventTask);
		}
	}

	private ArrayList<Task> createTask(String date1, String date2) {
		ArrayList<String> dates = listDates(date1, date2);
		ArrayList<Task> tasks = new ArrayList<Task>();

		if (date1.equals(date2)) {
			tasks.add(this.createTask(date1));
			return tasks;
		}

		for (String date : dates) {
			if (date.equals(date1)) {
				if (time.get(INDEX_ZERO).equals(MESSAGE_SYMBOL_NOTHING)) {
					tasks.add(new Task(date, this.eventTask));
				} else {
					tasks.add(new Task(date, this.time.get(INDEX_ZERO) + MESSAGE_END_OF_DAY, this.eventTask));
				}
			} else if (date.equals(date2)) {
				if (time.get(INDEX_ONE).equals(MESSAGE_SYMBOL_NOTHING)) {
					tasks.add(new Task(date, this.eventTask));
				} else {
					tasks.add(new Task(date, MESSAGE_START_OF_DAY + this.time.get(INDEX_ONE), this.eventTask));
				}
			} else {
				tasks.add(new Task(date, this.eventTask));
			}
		}
		return tasks;
	}

	private static ArrayList<String> listDates(String date1, String date2) {
		ArrayList<String> dates = new ArrayList<String>();
		LocalDateTime d1 = getDate(date1);
		LocalDateTime d2 = getDate(date2);
		dates.add(d1.toString(MESSAGE_DATE_FORMAT));
		System.out.println(MESSAGE_DATE_ADDED);
		for (LocalDateTime dt = d1.plusDays(INDEX_ONE); dt.compareTo(d2) == -INDEX_ONE; dt = dt.plusDays(INDEX_ONE)) {
			System.out.println(dt.toString(MESSAGE_DATE_FORMAT));
			dates.add(dt.toString(MESSAGE_DATE_FORMAT));
		}
		dates.add(d2.toString(MESSAGE_DATE_FORMAT));
		return dates;
	}

	private String longString() {
		if (time.get(INDEX_ZERO).equals(MESSAGE_SYMBOL_NOTHING) && time.get(INDEX_ONE).equals(MESSAGE_SYMBOL_NOTHING)) {
			return date.get(INDEX_ZERO) + MESSAGE_HYPHEN_WITH_SPACE + date.get(INDEX_ONE) + MESSAGE_SYMBOL_SPACE
					+ this.eventTask;
		} else if (time.get(INDEX_ZERO).equals(MESSAGE_SYMBOL_NOTHING)) {
			return date.get(INDEX_ZERO) + MESSAGE_HYPHEN_WITH_SPACE + date.get(INDEX_ONE) + MESSAGE_SYMBOL_SPACE
					+ time.get(INDEX_ONE) + MESSAGE_SYMBOL_SPACE + this.eventTask;
		} else if (time.get(INDEX_ONE).equals(MESSAGE_SYMBOL_NOTHING)) {
			return date.get(INDEX_ZERO) + MESSAGE_SYMBOL_SPACE + time.get(INDEX_ZERO) + MESSAGE_HYPHEN_WITH_SPACE
					+ date.get(INDEX_ONE) + MESSAGE_SYMBOL_SPACE + this.eventTask;
		} else {
			return date.get(INDEX_ZERO) + MESSAGE_SYMBOL_SPACE + time.get(INDEX_ZERO) + MESSAGE_HYPHEN_WITH_SPACE
					+ date.get(INDEX_ONE) + MESSAGE_SYMBOL_SPACE + time.get(INDEX_ONE) + MESSAGE_SYMBOL_SPACE
					+ this.eventTask;
		}
	}

	@Override
	public boolean isMutator(Command task) {
		if (task instanceof AddTask) {
			return true;
		} else {
			return false;
		}
	}

	/********** GETTER **********/
	public String getEventTask() {
		return eventTask;
	}

	public ArrayList<String> getDate() {
		return date;
	}

	public ArrayList<String> getTime() {
		return time;
	}

	public State getCurrState() {
		return currState;
	}

	private static LocalDateTime getDate(String str) {
		LocalDateTime date = DateTimeFormat.forPattern(MESSAGE_DATE_FORMAT).parseLocalDateTime(str);
		return date;
	}

	/********** SETTER **********/
	public void setEventTask(String eventTask) {
		this.eventTask = eventTask;
	}

	public void setDate(ArrayList<String> date) {
		this.date = date;
	}

	public void setTime(ArrayList<String> time) {
		this.time = time;
	}

	@Override
	public void setCurrState(State state) {
		currState = new State(state);
	}

}
