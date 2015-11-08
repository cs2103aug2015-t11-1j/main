package logic;

import storage.Output;

public class ClearList implements Command {

	private static final String MESSAGE_CLEAR = "clear";
	private static final String MESSAGE_SYMBOL_NOTHING = "";

	/*********** CONSTRUCTOR **********/
	public ClearList() {

	}

	@Override
	public Output execute() {
		String message = MESSAGE_SYMBOL_NOTHING;
		return new Output(true, message, MESSAGE_CLEAR);
	}

	@Override
	public boolean isMutator(Command task) {
		return false;
	}

	/********** GETTER **********/
	@Override
	public State getCurrState() {
		return null;
	}

	/********** SETTER **********/
	@Override
	public void setCurrState(State state) {

	}
}
