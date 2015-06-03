package net.bircs.validation.chains;

import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.ExclusionValidator;
import net.bircs.validation.validator.MinLengthValidator;
import net.bircs.validation.validator.RequiredValidator;

public class StringExclude extends ValidatorChain {

	public StringExclude() {
		super();
		addValitator(new RequiredValidator());
		addValitator(new MinLengthValidator());
		addValitator(new ExclusionValidator());
	}
}
