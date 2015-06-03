package net.bircs.validation.validator;

import net.bircs.validation.generic.Validator;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;

public class DateValidator extends Validator {
	
	@Override
	protected boolean isValid(ValidationContext context, Validatable validatable) {
		try {
			String pattern = (context.getPattern() != null) ? context.getPattern() : dateUtil.getPattern();
			DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
			formatter.parseDateTime(validatable.getValue());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int getErrorType() {
		return Validator.DATA_ERROR;
	}

}
