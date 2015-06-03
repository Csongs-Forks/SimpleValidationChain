package net.bircs.validation.chains;

import net.bircs.validation.validator.PostcodeValidator;
import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.RequiredValidator;

public class RequiredPostcode extends ValidatorChain {

	public RequiredPostcode() {
		super();
		addValitator(new RequiredValidator());
		addValitator(new PostcodeValidator());
	}
}
