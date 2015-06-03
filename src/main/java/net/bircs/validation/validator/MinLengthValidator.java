package net.bircs.validation.validator;

import net.bircs.validation.generic.Validator;
import org.apache.commons.validator.GenericValidator;

import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;

public class MinLengthValidator extends Validator {

	@Override
	protected boolean isValid(ValidationContext context,
			Validatable validateable) {
		return GenericValidator.minLength(validateable.getValue(), context.getMinLength());
	}

}
