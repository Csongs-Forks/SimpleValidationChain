package net.bircs.validation.chains;

import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.EmailValidator;
import net.bircs.validation.validator.RequiredValidator;

public class RequiredEmail extends ValidatorChain {

	public RequiredEmail() {
		super();
		addValitator(new RequiredValidator());
		addValitator(new EmailValidator());
	}
}
