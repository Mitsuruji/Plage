package fr.orsys.projet.plage.exception;

public class LocataireNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public LocataireNotFoundException(String message) {
		super(message);
	}

}