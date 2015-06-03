package net.bircs.validation.validator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;
import net.bircs.validation.generic.Validator;
import org.apache.commons.validator.GenericValidator;


public class EmailValidator extends Validator {

	@Override
	protected boolean isValid(ValidationContext context, Validatable validatable) {
		return GenericValidator.isEmail(validatable.getValue());
	}
	
	@Override
	public int getErrorType() {
		return Validator.DATA_ERROR;
	}
}

	
