package net.bircs.validation.generic;
import java.util.LinkedList;

/**
 * The idea here is that the chain results false if validation fails and true if not.
 * This class is based on chain of responsibility pattern.
 * @author sakari
 *
 */
public class ValidatorChain {
	
	LinkedList<Validator> chain;

	public ValidatorChain() {
		chain = new LinkedList<Validator>();
	}
	
	public boolean hasValidator() {
		return !chain.isEmpty();
	}
	
	public void addValitator(Validator validator) {
		chain.addLast(validator);
	}

	/**
	 * If there's Validators in the chain then proceed with validation else return true indicating that the validation did succeed.
	 * @param context 
	 * @param value
	 * @return
	 */
	public boolean doValidate(ValidationContext context, Validatable value) {
		if (hasValidator()) {
			Validator next = chain.removeFirst();
			value.setErrorType(next.getErrorType());
			return next.doValidate(context, value, this);
		} else {
			return true;
		}
	}

}
