package net.bircs.validation.validator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;
import net.bircs.validation.generic.Validator;


public class ConfirmValidator extends Validator {
	
	@Override
	protected boolean isValid(ValidationContext context, Validatable validatable) {
		return validatable.getValue().equals("on");
	}
}

	
