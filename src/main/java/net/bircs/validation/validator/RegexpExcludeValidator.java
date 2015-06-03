package net.bircs.validation.validator;

import net.bircs.validation.generic.Validator;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;

public class RegexpExcludeValidator extends Validator {
	
	@Override
	protected boolean isValid(ValidationContext context, Validatable validatable) {
		try {
			DateTimeFormatter formatter = DateTimeFormat.forPattern(dateUtil.getPattern());
			formatter.parseDateTime(validatable.getValue());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
