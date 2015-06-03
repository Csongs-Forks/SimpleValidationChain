package net.bircs.validation.validator;

import net.bircs.validation.generic.Validator;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;

public class AgeValidator extends Validator {

	@Override
	protected boolean isValid(ValidationContext context, Validatable validatable) {
		System.out.println("age validator");
		try {
			DateTimeFormatter formatter = DateTimeFormat.forPattern(dateUtil.getPattern());
			DateTime birthdate = formatter.parseDateTime(validatable.getValue());
			DateTime now = new DateTime();
			int age = Years.yearsBetween(birthdate, now).getYears();
			return ((age >= context.getMinValue()) && (age < context.getMaxValue())) ? true : false;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public int getErrorType() {
		return Validator.DATA_ERROR;
	}

}
