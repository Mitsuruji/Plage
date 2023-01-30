package fr.orsys.projet.plage.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateHeureDebutBeforeDateHeureFin.class)
@Documented
public @interface DateHeureDebutBeforeDateHeureFinConstraint {
	String message() default "La date de début doit être antérieure à la date de fin";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
