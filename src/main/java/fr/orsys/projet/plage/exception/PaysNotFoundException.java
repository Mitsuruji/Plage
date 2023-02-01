package fr.orsys.projet.plage.exception;

public class PaysNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PaysNotFoundException(String message) {
		super(message);
	}
}
