package net.bircs.validation.generic;

import net.bircs.validation.chains.DateAndAgeChain;
import net.bircs.validation.chains.IntLength;
import net.bircs.validation.chains.IntLengthRange;
import net.bircs.validation.chains.IntRange;
import net.bircs.validation.chains.LongPhone;
import net.bircs.validation.chains.NotRequiredLength;
import net.bircs.validation.chains.NotRequiredPromo;
import net.bircs.validation.chains.Required;
import net.bircs.validation.chains.RequiredConfirm;
import net.bircs.validation.chains.RequiredEmail;
import net.bircs.validation.chains.RequiredInt;
import net.bircs.validation.chains.RequiredLetter;
import net.bircs.validation.chains.RequiredPostcode;
import net.bircs.validation.chains.RequiredSting;
import net.bircs.validation.chains.RequiredStringLength;
import net.bircs.validation.chains.StringExclude;

public abstract class Validator {

	public DateValidationUtil dateUtil = new DateValidationUtil();

	private int errorType;
	
	/*
	 * Field error is used to indicate that there's something wrong with the field. 
	 */
	public static final int FIELD_ERROR = 0;
	public static final int DATA_ERROR 	= 1;

	public boolean doValidate(ValidationContext context, Validatable validatable, ValidatorChain chain) {
		if (isValid(context, validatable)) {
			return chain.doValidate(context, validatable);
		} else {
			return false;
		}
	}

	protected abstract boolean isValid(ValidationContext context, Validatable validateable);

	/**
	 * Add your custom chains to this method and to the enum.
	 * @param type
	 * @return
	 */
	public static ValidatorChain getChain(ValidatorType type) {
		switch(type) {
			case REQUIRED:
				return new Required();
			case REQUIRED_INT:
				return new RequiredInt();
			case INT_LENGTH:
				return new IntLength();
			case INT_LENGTH_RANGE:
				return new IntLengthRange();
			case INT_RANGE:
				return new IntRange();
			case REQUIRED_STRING:
				return new RequiredSting();
			case REQUIRED_STRING_LENGTH:
				return new RequiredStringLength();
			case REQUIRED_LETTER:
				return new RequiredLetter();
			case REQUIRED_EMAIL:
				return new RequiredEmail();
			case REQUIRED_POSTCODE:
				return new RequiredPostcode();
			case REQUIRED_CONFIRM:
				return new RequiredConfirm();
			case LONG_PHONE:
				return new LongPhone();
			case NOT_REQUIRED_LENGTH:
				return new NotRequiredLength();
			case DATE_AND_AGE:
				return new DateAndAgeChain();
			case STRING_EXCLUDE:
				return new StringExclude();
			case NOT_REQUIRED_PROMO:	
				return new NotRequiredPromo();
			default:
				return new Required();
		}
	}
	
	/**
	 * Override this method in the Validator subclass if you want to return a value error.
	 * @return
	 */
	public int getErrorType() {
		return errorType;
	}
}
