package logic;

import java.util.ArrayList;

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
}
