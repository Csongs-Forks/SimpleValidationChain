package net.bircs.validation.chains;

import net.bircs.validation.validator.LengthValidator;
import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.LongValidator;

public class LongPhone extends ValidatorChain {

	public LongPhone() {
		addValitator(new LongValidator());
		addValitator(new LengthValidator());
	}
}
