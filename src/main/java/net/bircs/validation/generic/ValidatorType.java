package net.bircs.validation.generic;

/**
 * These names are used to identify chains which combine multiple filters.
 * Naming convention is by filter in a procedural order.
 * @author sakari
 *
 */
public enum ValidatorType {
	REQUIRED_INT,
	REQUIRED_STRING,
	REQUIRED_STRING_LENGTH, 
	REQUIRED_LETTER, 
	DATE_AND_AGE, 
	STRING_EXCLUDE, 
	REQUIRED, 
	INT_RANGE, 
	INT_LENGTH, 
	INT_LENGTH_RANGE, 
	REQUIRED_EMAIL, 
	REQUIRED_POSTCODE, 
	LONG_PHONE, 
	NOT_REQUIRED_LENGTH, 
	REQUIRED_CONFIRM, 
	NOT_REQUIRED_PROMO
}
