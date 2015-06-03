package validation;

import org.junit.Before;
import org.junit.Test;

import net.bircs.validation.generic.FieldValidator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;
import net.bircs.validation.generic.ValidatorType;
import net.bircs.validation.validator.ValueLengthValidator;
import junit.framework.TestCase;

public class TestNotRequiredStringLengthValidation extends TestCase {

	FieldValidator validator;
	
	@Before
	public void setUp() {
		validator = new FieldValidator();
	}
	
	public void testNotRequiredStringLength() {
		Validatable field = new Validatable("value","fieldName", "errormessage", "validation error message");
		ValueLengthValidator vlv = new ValueLengthValidator();
		ValidationContext vc = new ValidationContext();
		vc.setLength(1, 10);
		assertTrue(vlv.isValid(vc, field));
		field.setValue("");
		assertTrue(vlv.isValid(vc, field));
		field.setValue(null);
		assertTrue(vlv.isValid(vc, field));
		field.setValue("00000000000000000000");
		assertFalse(vlv.isValid(vc, field));
	}
	
	
	public void testWithChain() {
		Validatable field = new Validatable("value","fieldName", "errormessage", "validation error message");
		validator.setLength(1, 10).validate(ValidatorType.NOT_REQUIRED_LENGTH, field);
		assertEquals(0,validator.getErrors().size());
		validator.reset();
		field.setValue(null);
		validator.setLength(1, 10).validate(ValidatorType.NOT_REQUIRED_LENGTH, field);
		assertEquals(0,validator.getErrors().size());
		validator.reset();
		field.setValue("xxxxxxxxxxxxxxxxxxxx");
		validator.setLength(1, 10).validate(ValidatorType.NOT_REQUIRED_LENGTH, field);
		assertEquals(1,validator.getErrors().size());
	} 
}
