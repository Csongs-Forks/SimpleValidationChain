package net.bircs.validation.chains;

import net.bircs.validation.validator.RangeValidator;
import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.RequiredValidator;

public class RequiredStringRange extends ValidatorChain {

	public RequiredStringRange() {
		addValitator(new RequiredValidator());
		addValitator(new RangeValidator());
	}
}
