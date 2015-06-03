package net.bircs.validation.chains;

import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.ConfirmValidator;
import net.bircs.validation.validator.RequiredValidator;

public class RequiredConfirm extends ValidatorChain {

	public RequiredConfirm() {
		super();
		addValitator(new RequiredValidator());
		addValitator(new ConfirmValidator());
	}
}
