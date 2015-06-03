package net.bircs.validation.chains;

import net.bircs.validation.validator.PromotionalCodeValidator;
import net.bircs.validation.generic.ValidatorChain;

public class NotRequiredPromo extends ValidatorChain {

	public NotRequiredPromo() {
		super(); // Might want to check max length here 
		addValitator(new PromotionalCodeValidator());
	}
}
