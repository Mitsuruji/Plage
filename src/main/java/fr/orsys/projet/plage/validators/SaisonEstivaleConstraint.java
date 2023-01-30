package fr.orsys.projet.plage.validators;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SaisonEstivaleConstraint implements ConstraintValidator<SaisonEstivale, LocalDateTime> {

	@Override
	public boolean isValid(LocalDateTime dateHeure, ConstraintValidatorContext context) {
		if (dateHeure == null) {
			return false;
		}
		LocalDate start = LocalDate.of(dateHeure.getYear(), Month.JUNE, 1);
		LocalDate end = LocalDate.of(dateHeure.getYear(), Month.SEPTEMBER, 15);
		return dateHeure.toLocalDate().isAfter(start) && dateHeure.toLocalDate().isBefore(end);
	}
}