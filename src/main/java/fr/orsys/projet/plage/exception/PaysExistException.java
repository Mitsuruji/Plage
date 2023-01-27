package fr.orsys.projet.plage.exception;

public class PaysExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PaysExistException(String message) {
		super(message);
	}
}
