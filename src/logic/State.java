package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class State {
	private ArrayList<Task> _tasklist;
	
	/*****CONSTRUCTOR*****/
	public State(ArrayList<Task> tasklist){
		this._tasklist = tasklist;
	}
	
	/*****GETTER*****/
	public ArrayList<Task> getTaskList(){
		return _tasklist;
	}
	
	public void add(Task task) {
		_tasklist.add(task);
	}
	
	/*****SORTING*****/
	public void sort(){
		Collections.sort(this._tasklist, new Comparator<Task>(){
			@Override
			public int compare(Task t1, Task t2){
				int i = t1.rotateDF().compareTo(t2.rotateDF());
				if(i != 0) return i;
				
				i = t1._time.compareTo(t2._time);
				if(i != 0) return i;
				
				return t1._details.compareTo(t2._details);
			}
		});
		for(Task t : _tasklist){
			t.setIndex(_tasklist.indexOf(t) + 1);
		}
	}
	
	/*****toString()*****/
	//return tasklist in form of arraylist of String
	public ArrayList<String> toStringList(){
		ArrayList<String> list = new ArrayList<String>();
		for(Task t : _tasklist){
			list.add(t.toString());
		}
		return list;
	}
	
	//convert State into String form
	public String toString(){
		String str = new String();
		for(String s : this.toStringList()){
			str.concat(s + "\n");
		}
		return str;
	}
	
}
