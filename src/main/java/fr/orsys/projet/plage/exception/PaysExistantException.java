package fr.orsys.projet.plage.exception;

public class PaysExistantException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PaysExistantException(String message) {
		super(message);
	}
}
