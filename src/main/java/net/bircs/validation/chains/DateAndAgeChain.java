package net.bircs.validation.chains;

import net.bircs.validation.validator.DateValidator;
import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.AgeValidator;

public class DateAndAgeChain extends ValidatorChain {

	public DateAndAgeChain() {
		super();
		addValitator(new DateValidator());
		addValitator(new AgeValidator());
	}
}
