package net.bircs.validation.chains;

import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.IntValidator;
import net.bircs.validation.validator.RequiredValidator;

public class RequiredInt extends ValidatorChain {
	
	public RequiredInt() {
		super();
		addValitator(new RequiredValidator());
		addValitator(new IntValidator());
	}
}
