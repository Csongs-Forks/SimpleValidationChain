package net.bircs.validation.validator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.Validator;
import org.apache.commons.validator.GenericValidator;

import net.bircs.validation.generic.ValidationContext;


public class LetterValidator extends Validator {
	
	private static final String LETTER_REGEXP = "^[A-Za-z '\\-]+$";

	@Override
	protected boolean isValid(ValidationContext context, Validatable validatable) {
		return GenericValidator.matchRegexp(validatable.getValue(), LETTER_REGEXP);
	}
}

	
