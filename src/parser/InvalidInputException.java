/*
 * @@author A0121319R
 * 
 * This exception is thrown whenever an invalid input is detected in the user's string input
 */

package parser;

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message = "Invalid inputs";

	public InvalidInputException() {

	}

	public InvalidInputException(String str) {
		this.message = str;
	}

	public String getMessage() {
		return message;
	}
}
