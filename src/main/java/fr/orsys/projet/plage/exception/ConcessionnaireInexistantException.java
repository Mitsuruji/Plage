package fr.orsys.projet.plage.exception;

public class ConcessionnaireInexistantException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConcessionnaireInexistantException(String message) {
		super(message);
	}
}
