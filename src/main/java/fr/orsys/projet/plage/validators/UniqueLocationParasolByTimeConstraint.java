package fr.orsys.projet.plage.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.orsys.projet.plage.business.Location;

public class UniqueLocationParasolByTimeConstraint implements ConstraintValidator<UniqueLocationParasolByTime, Location> {

	@Override
	public boolean isValid(Location location, ConstraintValidatorContext context) {
		return location.getParasols().stream().flatMap(parasol -> parasol.getLocations().stream())
				.filter(loc -> !loc.equals(location))
				.noneMatch(loc -> !loc.getDateHeureFin().isBefore(location.getDateHeureDebut())
						&& !loc.getDateHeureDebut().isAfter(location.getDateHeureFin()));
	}
	
	
}
