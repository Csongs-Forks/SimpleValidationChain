package net.bircs.validation.chains;

import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.IntValidator;
import net.bircs.validation.validator.LengthValidator;

public class IntLength extends ValidatorChain {

	public IntLength() {
		addValitator(new IntValidator());
		addValitator(new LengthValidator());
	}
}
