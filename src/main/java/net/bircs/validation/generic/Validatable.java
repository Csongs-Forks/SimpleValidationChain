package net.bircs.validation.generic;

public class Validatable {
	
	private String value;
	private int errorType = Validator.FIELD_ERROR; //default to field error
	private String fieldName;
	private String errorMessage;
	private String invalidDataErrorMessage;
	private String pattern;
	
	public Validatable(String value, String fieldName, String errorMessage) {
		super();
		this.value = value;
		this.fieldName = fieldName;
		this.errorMessage = errorMessage;
		this.invalidDataErrorMessage = errorMessage;
	}
	
	public Validatable(String value, String errorMessage) {
		super();
		this.value = value;
		this.errorMessage = errorMessage;
	}
	
	public Validatable() {}
	
	public Validatable(String value, String fieldName, String errorMessage,
			String invalidDataErrorMessage) {
		this.value = value;
		this.fieldName = fieldName;
		this.errorMessage = errorMessage;
		this.invalidDataErrorMessage = invalidDataErrorMessage;
	}

	public Validatable(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public Validatable setValue(String value) {
		this.value = value;
		return this;
	}

	public String getErrorMessage() {
		if (errorType == Validator.FIELD_ERROR) {
			return errorMessage;
		} else {
			return invalidDataErrorMessage;
		} 
	}

	public Validatable setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	public String getInvalidDataErrorMessage() {
		return invalidDataErrorMessage;
	}

	public Validatable setInvalidDataErrorMessage(String invalidDataErrorMessage) {
		this.invalidDataErrorMessage = invalidDataErrorMessage;
		return this;
	}

	public int getErrorType() {
		return errorType;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

	public String getFieldName() {
		return fieldName;
	}
	
	public Validatable setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	public String getPattern() {
		return pattern;
	}
	
	public Validatable setPattern(String pattern) {
		this.pattern = pattern;
		return this;
	}
}
