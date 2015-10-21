package parser;

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidInputException() {
		
	}
	
	public InvalidInputException(String str) {
		this.message = str;
	}
	
	public String getMessage() {
		return message;
	}
}
