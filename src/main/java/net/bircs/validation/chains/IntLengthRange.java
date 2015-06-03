package net.bircs.validation.chains;

import net.bircs.validation.validator.IntRangeValidator;
import net.bircs.validation.validator.LengthValidator;
import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.IntValidator;

public class IntLengthRange extends ValidatorChain {

	public IntLengthRange() {
		addValitator(new IntValidator());
		addValitator(new LengthValidator());
		addValitator(new IntRangeValidator());
	}
}
