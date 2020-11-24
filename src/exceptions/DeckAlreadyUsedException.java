package exceptions;

public class DeckAlreadyUsedException extends Exception  {
	
	private static final long serialVersionUID = 1L;

	public DeckAlreadyUsedException(String message) {
		super(message);
	}

}
