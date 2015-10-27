package logic;

import storage.Output;

public class SetFilePathTask implements Command {
	
	private String newFilePath;
	
	public SetFilePathTask() {
		
	}

	@Override
	public Output execute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrState(State state) {
		// TODO Auto-generated method stub

	}

	@Override
	public State getCurrState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMutator(Command task) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setFilePath(String filePath) {
		this.newFilePath = filePath;
	}
	
	public String getFilePath() {
		return this.newFilePath;
	}

}
