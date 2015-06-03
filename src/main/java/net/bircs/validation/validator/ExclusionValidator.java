package net.bircs.validation.validator;

import net.bircs.validation.generic.Validator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;

public class ExclusionValidator extends Validator {

	@Override
	protected boolean isValid(ValidationContext context,
			Validatable validateable) {
		return !validateable.getValue().equals(context.getPattern());
	}

}
