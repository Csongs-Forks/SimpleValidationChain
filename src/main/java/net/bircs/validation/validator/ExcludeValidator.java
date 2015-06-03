package net.bircs.validation.validator;

import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;
import net.bircs.validation.generic.Validator;


/**
 * This validator seem pointless, but it's useful in conjuction with other validators.
 * If you check that first that there's value and exclude some value you can assure that
 * select box was not -1 for example.
 * @author sakari
 *
 */
public class ExcludeValidator extends Validator {
	
	@Override
	protected boolean isValid(ValidationContext context, Validatable validatable) {
		return !validatable.getValue().equals(context.getPattern());
	}

}
