package net.bircs.validation.validator;

import org.apache.commons.validator.GenericValidator;

import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;
import net.bircs.validation.generic.Validator;

public class RangeValidator extends Validator  {
	
	/**
	 * TODO: This method works on length despite the name.. change it.
	 */
	@Override
	public boolean isValid(ValidationContext context, Validatable validatable) {
		try {
			return (GenericValidator.minValue(Integer.parseInt(validatable.getValue()), context.getMinValue()) && 
					GenericValidator.maxValue(Integer.parseInt(validatable.getValue()), context.getMaxValue()));
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	
	// Value errors need to override the error type
	@Override
	public int getErrorType() {
		return Validator.DATA_ERROR;
	}
	
}

	
