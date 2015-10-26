package logic;

import java.util.ArrayList;

import storage.Output;

public class ShowFileTask implements Command {

	private State currState = new State(new ArrayList<Task>());

	public ShowFileTask() {

	}

	@Override
	public Output execute() {
		// need help with this
		ArrayList<Task> list = currState.getTaskList();
		ArrayList<Task> fileTasks = new ArrayList<Task>();
		for(Task t : list){
			if(t.getDate().contains(this.date)){
				fileTasks.add(t);
			}
		}	
		return new Output(true, fileTasks, "fp");
	}

	@Override
	public State getCurrState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrState(State state) {
		currState = state;

	}

	@Override
	public boolean isMutator(Command task) {
		if (task instanceof ShowFileTask) {
			return true;
		} else {
			return false;
		}
	}

}
