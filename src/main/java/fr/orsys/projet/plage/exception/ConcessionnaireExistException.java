package fr.orsys.projet.plage.exception;

public class ConcessionnaireExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConcessionnaireExistException(String message) {
		super(message);
	}
}
