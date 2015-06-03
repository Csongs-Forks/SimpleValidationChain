package net.bircs.validation.validator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.Validator;
import org.apache.commons.validator.GenericValidator;

import net.bircs.validation.generic.ValidationContext;


public class IntValidator extends Validator {
	
	@Override
	protected boolean isValid(ValidationContext context, Validatable validatable) {
		return GenericValidator.isInt(validatable.getValue());
	}
}

	
