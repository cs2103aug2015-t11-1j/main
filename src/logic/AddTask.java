package logic;

import java.util.ArrayList;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import storage.Output;

public class AddTask implements Command {

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
		for(Task task : tasklist){
			this.currState.add(task);
		}
		this.currState.sort();
		if(tasklist.size() == 1){
			return new Output(true, tasklist.get(0).toString(), "add");
		}
		return new Output(true, this.longString() ,"add");
	}

//	private ArrayList<Task> createTask() {
//		ArrayList<Task> tasks = new ArrayList<Task>();
//		switch (date.size()) {
//		case 0:
//			tasks.add(new Task(this.eventTask));
//			return tasks;
//		case 1:
//			tasks.add(this.createTask(this.date.get(0)));
//			return tasks;
//		case 2:
//			return this.createTask(this.date.get(0), this.date.get(1));
//		default:
//			tasks.add(new Task(this.date.get(0), this.time.get(0), this.eventTask));
//			return tasks;
//		}
//	}
//
//	private Task createTask(String date) {
//		switch(time.size()){
//		case 0:
//			return new Task(date, this.eventTask);
//		case 1:
//			return new Task(date, this.time.get(0), this.eventTask);
//		case 2:
//			return new Task(date, this.time.get(0)+"-"+this.time.get(1), this.eventTask);
//		default:
//			return new Task(date, this.time.get(0), this.eventTask);
//		}
//	}
	
	/****if cannot by size*****/
	private ArrayList<Task> createTask() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		if(date.get(0).equals("")) {
			tasks.add(new Task(this.eventTask));
			return tasks;
		} else if(date.get(1).equals("")){
			tasks.add(this.createTask(this.date.get(0)));
			return tasks;
		} else {
			return this.createTask(this.date.get(0), this.date.get(1));
		}
	}

	private Task createTask(String date) {
		if(time.get(0).equals("")){
			return new Task(date, this.eventTask);
		} else if(time.get(1).equals("")){
			return new Task(date, this.time.get(0), this.eventTask);
		} else {
			return new Task(date, this.time.get(0)+"-"+this.time.get(1), this.eventTask);
		}
	}

	
	private ArrayList<Task> createTask(String date1, String date2){
		ArrayList<String> dates = listDates(date1, date2);
		ArrayList<Task> tasks = new ArrayList<Task>();
		
		if(date1.equals(date2)){
			tasks.add(this.createTask(date1));
			return tasks;
		}
		
		for(String date : dates){
			if(date.equals(date1)){
				if(time.get(0).equals("")){
					tasks.add(new Task(date, this.eventTask));
				} else {
					tasks.add(new Task(date, this.time.get(0)+"-2359", this.eventTask));
				}
			} else if (date.equals(date2)){
				if(time.get(1).equals("")){
					tasks.add(new Task(date, this.eventTask));
				} else {
					tasks.add(new Task(date, "0000-"+this.time.get(1), this.eventTask));
				}
			} else {
				tasks.add(new Task(date, this.eventTask));
				System.out.println(new Task(date, this.eventTask).toString());
			}
		}
		return tasks;
	}
	
	/****old one*****/
//	private Task createTask() {
//		try {
//			if (this.date.size() > 1) {
//				if (this.time.size() > 1) {
//					return new Task((this.date.get(0) + "-" + this.date.get(1)),
//							(this.time.get(0) + "-" + this.time.get(1)), this.eventTask);
//				} else {
//					return new Task(this.date.get(0) + "-" + this.date.get(1), this.time.get(0), this.eventTask);
//				}
//			} else if (this.time.size() > 1) {
//				return new Task(this.date.get(0), this.time.get(0) + "-" + this.time.get(1), this.eventTask);
//			} else {
//				return new Task(this.date.get(0), this.time.get(0), this.eventTask);
//			}
//
//		} catch (NullPointerException e) {
//			System.err.println(e.getMessage());
//			return new Task(this.date.get(0), "", this.eventTask);
//		}
//	}

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
		currState = state;
	}

	@Override
	public boolean isMutator(Command task) {
		if (task instanceof AddTask) {
			return true;
		} else {
			return false;
		}
	}
	
	private static LocalDateTime getDate(String str){
		LocalDateTime date = DateTimeFormat.forPattern("dd/MM/yy").parseLocalDateTime(str);
		return date;
	}
	
	private static ArrayList<String> listDates(String date1, String date2){
		ArrayList<String> dates = new ArrayList<String>();
		LocalDateTime d1 = getDate(date1);
		LocalDateTime d2 = getDate(date2);
		dates.add(d1.toString("dd/MM/yy"));
		System.out.println("date added");
		for(LocalDateTime dt = d1.plusDays(1); dt.compareTo(d2) == -1; dt = dt.plusDays(1)){
			System.out.println(dt.toString("dd/MM/yy"));
			dates.add(dt.toString("dd/MM/yy"));
		}
		dates.add(d2.toString("dd/MM/yy"));		
		return dates;
	}
		
	private String longString(){
		return date.get(0) + "-" + time.get(0) + " " 
				+ date.get(1) + "-" + time.get(1) + " "
				+ this.eventTask;
	}
}
