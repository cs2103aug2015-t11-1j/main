package planit;

public interface Command {
	
	public void execute();
	public void parse();
	public void undo();
}
