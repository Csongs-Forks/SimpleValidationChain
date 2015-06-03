package net.bircs.validation.validator;

import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.Validator;
import org.apache.commons.validator.GenericValidator;

import net.bircs.validation.generic.ValidationContext;

public class IntRangeValidator extends Validator {

	@Override
	protected boolean isValid(ValidationContext context,
			Validatable validateable) {
		try {
			return GenericValidator.isInRange(Integer.parseInt(validateable.getValue()), context.getMinValue(), context.getMaxValue());
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}
