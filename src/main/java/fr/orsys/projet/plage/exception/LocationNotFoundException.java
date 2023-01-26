package fr.orsys.projet.plage.exception;

public class LocationNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public LocationNotFoundException(String message) {
		super(message);
	}

}