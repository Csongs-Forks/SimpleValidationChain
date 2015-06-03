package net.bircs.validation.chains;

import net.bircs.validation.validator.IntRangeValidator;
import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.IntValidator;

public class IntRange extends ValidatorChain {
	
	public IntRange() {
		addValitator(new IntValidator());
		addValitator(new IntRangeValidator());
	}
	
}
