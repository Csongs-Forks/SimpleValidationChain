package net.bircs.validation.chains;

import net.bircs.validation.generic.ValidatorChain;
import net.bircs.validation.validator.LetterValidator;
import net.bircs.validation.validator.RequiredValidator;

public class RequiredLetter extends ValidatorChain {

	public RequiredLetter() {
		super();
		addValitator(new RequiredValidator());
		addValitator(new LetterValidator());
	}
}
