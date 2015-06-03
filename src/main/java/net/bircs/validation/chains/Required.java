package net.bircs.validation.chains;

import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.RequiredValidator;

public class Required extends ValidatorChain {
	public Required() {
		super();
		addValitator(new RequiredValidator());
	}
}
