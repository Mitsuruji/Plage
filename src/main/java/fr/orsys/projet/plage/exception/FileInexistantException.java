package fr.orsys.projet.plage.exception;

public class FileInexistantException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileInexistantException(String message) {
		super(message);
	}
}
