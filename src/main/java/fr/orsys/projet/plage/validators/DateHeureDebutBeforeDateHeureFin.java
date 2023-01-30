package fr.orsys.projet.plage.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.orsys.projet.plage.business.Location;


public class DateHeureDebutBeforeDateHeureFin implements ConstraintValidator<DateHeureDebutBeforeDateHeureFinConstraint, Location> {
    @Override
    public boolean isValid(Location location, ConstraintValidatorContext context) {
        return location.getDateHeureDebut().isBefore(location.getDateHeureFin());
    }
}
