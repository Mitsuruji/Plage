package fr.orsys.projet.plage.exception;

public class FileExistantException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileExistantException(String message) {
		super(message);
	}
}
