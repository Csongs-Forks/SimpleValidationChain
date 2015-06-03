package net.bircs.validation.chains;

import net.bircs.validation.validator.ValueLengthValidator;
import net.bircs.validation.generic.ValidatorChain;

public class NotRequiredLength extends ValidatorChain {

	public NotRequiredLength() {
		super();
		addValitator(new ValueLengthValidator());
	}
}
