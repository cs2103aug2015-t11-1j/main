package logic;

import java.util.ArrayList;

import storage.Output;

public class ShowTask implements Command {
	
	private String date;
	
	/***********CONSTRUCTOR**********/
	public ShowTask() {
		
	}
	
	@Override
	public Output execute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String str) {
		this.date = str;
	}
	
}
