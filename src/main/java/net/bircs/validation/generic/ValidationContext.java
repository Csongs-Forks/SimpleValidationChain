package net.bircs.validation.generic;

/**
 * This class is the context for the validation. It defines the limits, expression etc. which are needed by the validation.
 * You can add new fields for the context or subclass the context and create Validator specific parameters.
 * @author sakari
 *
 */
public class ValidationContext {
	
	private int minValue = 0;
	private int maxValue = 0;
	private String pattern;
	private int maxLength = 0;
	private int minLength = 0;
	
	public int getMinValue() {
		return minValue;
	}
	
	public void setMinValue(int min) {
		this.minValue = min;
	}
	
	public int getMaxValue() {
		return maxValue;
	}
	
	public void setMaxValue(int max) {
		this.maxValue = max;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setRange(int min, int max) {
		this.minValue = min;
		this.maxValue = max;		
	}

	public void setLength(int min, int max) {
		this.minLength = min;
		this.maxLength = max;
		
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	
	
}
