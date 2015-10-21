package logic;

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
	
	/**********  GETTER   **********/
	public String getDate() {
		return date;
	}
	
	/**********  SETTER   **********/
	public void setDate(String str) {
		this.date = str;
	}

	@Override
	public void setCurrState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isMutator(Command task) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
