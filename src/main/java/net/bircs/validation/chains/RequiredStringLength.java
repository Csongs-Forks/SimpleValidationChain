package net.bircs.validation.chains;

import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.LengthValidator;
import net.bircs.validation.validator.RequiredValidator;

public class RequiredStringLength extends ValidatorChain {

	public RequiredStringLength() {
		addValitator(new RequiredValidator());
		addValitator(new LengthValidator());
	}
}
