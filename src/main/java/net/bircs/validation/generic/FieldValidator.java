package net.bircs.validation.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * This is the concrete class which you will use for the validation.
 * Validatable contains info about the field and ValidationContext is
 * used to set validation properties. Remember if you use validation
 * which uses context remember that the old context used for previous
 * validation might be in memory, so set it before calling validate().
 * @author sakari
 *
 */
public class FieldValidator {
	
	private ValidatorChain chain;
	private Map<String, List<String>> fieldErrors = new HashMap<String, List<String>>();
	private List<String> errorMessage;
	private boolean isShortCircuit = true;
	private ValidationContext context;
	
	// Add prefix to this list if you want to create a new global error
	List<String> globalErrorTitles = Arrays.asList(new String[] 
		{	
			"Please make sure",
			"Please tell us",
			"Please confirm"
		});

	
	public FieldValidator() {
		context = new ValidationContext(); 
	}
	
	public FieldValidator(ValidationContext context) {
		this.context = context; 
	}
	

	public void validate(ValidatorType type, Validatable validatable) {
		if (shortCircuit(validatable)) {
			ValidatorChain chain = Validator.getChain(type);
			if (!chain.doValidate(context, validatable)) {
				addFieldError(validatable.getFieldName(), validatable.getErrorMessage());
				addGlobalError(validatable.getErrorMessage());
				System.out.println("Validation did not succeed: " + validatable.getErrorMessage());
			} else { // TODO: remove as unnecessary
				System.out.println("Validation did succeed.");
			}
		}
	}

	/**
	 * If the validation is set to short circuit the validation chain will not launch if there's
	 * already an error with a same field name. Basically you can't add objects to a map with same
	 * key so this could be removed, but it enhances validation performance like this.
	 * @param validatable
	 * @return
	 */
	private boolean shortCircuit(Validatable validatable) {
		return !fieldErrors.containsKey(validatable.getFieldName());
	}

	private void addFieldError(String fieldName, String message) {
		if (message != null) {
			System.out.println("addFieldError: " + fieldName + ", " + message);
			errorMessage = new ArrayList<String>();
			errorMessage.add(message);
			fieldErrors.put(fieldName, errorMessage);
		} else {
			System.out.println("null");
		}
	}
	
	/**
	 * Add global error which is added to an value array with same key for all the messages.
	 * @param message
	 */
	public void addGlobalError(String message) {
		String type = getGlobalType(message);
		if (type != null) {
			System.out.println("append error");
			appendError(type,message);
		} // TODO: for now don't add message if there's no type defined, but could add the functionality here 
	}

	public void appendError(String key, String message) {
		if (hasError(key)) {
			List<String> messages = getError(key);
			messages.add(message);
			fieldErrors.put(key, messages);
		} else {
			addFieldError(key, message);
		}
		
	}

	public String getGlobalType(String message) {
		for (String prefix : globalErrorTitles) {
			if (message.startsWith(prefix)) {
				return prefix;
			}
		}
		return null;
	}

	public boolean hasError(String type) {
		if (getError(type) != null)
			return true;
		return false;
	}


	public List<String> getError(String fieldName) {
		return fieldErrors.get(fieldName);
	}
	
	public String getErrorAsString(String fieldName) {
		return fieldErrors.get(fieldName).toString(); 
		//return StringUtils.join(fieldErrors, ',');
	}

	public void reset() {
		fieldErrors.clear();
	}

	public boolean isShortCircuit() {
		return isShortCircuit;
	}

	public void setShortCircuit(boolean isShortCircuit) {
		this.isShortCircuit = isShortCircuit;
	}

	public Map<String,List<String>> getErrors() {
		return fieldErrors;
	}

	public FieldValidator setRange(int min, int max) {
		this.context.setRange(min, max);
		return this;
	}

	public FieldValidator setPattern(String pattern) {
		this.context.setPattern(pattern);
		return this;
	}

	public FieldValidator setMinValue(int min) {
		context.setMinValue(min);
		return this;
	}

	public FieldValidator setLength(int min, int max) {
		context.setLength(min, max);
		return this;
	}	
	
	/**
	 * Create new context so that all the values are reset.
	 * Call before setting values as the values will be erased ;)
	 * @return
	 */
	public FieldValidator resetContext() {
		context = new ValidationContext();
		return this;
	}
}
