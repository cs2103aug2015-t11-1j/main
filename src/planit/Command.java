package planit;

public interface Command {
	
	void execute();
	void parse();
	void undo();
}
