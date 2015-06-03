package net.bircs.validation.chains;

import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.RequiredValidator;

public class RequiredSting extends ValidatorChain {

	public RequiredSting() {
		super();
		addValitator(new RequiredValidator());
	}
}
