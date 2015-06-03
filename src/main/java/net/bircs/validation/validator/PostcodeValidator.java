package net.bircs.validation.validator;
import net.bircs.validation.generic.Validator;
import org.apache.commons.validator.GenericValidator;

import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;


public class PostcodeValidator extends Validator {
	
	private static final String POSTCODE_REGEXP = "^([A-Z]{1,2})([0-9]{2,3})([A-Z]{2})$";

	@Override
	protected boolean isValid(ValidationContext context, Validatable validatable) {
		return GenericValidator.matchRegexp(validatable.getValue().replaceAll("\\s+", ""), POSTCODE_REGEXP);
	}
}

	
