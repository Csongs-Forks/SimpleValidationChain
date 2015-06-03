package validation;

import org.junit.Before;
import org.junit.Test;

import net.bircs.validation.generic.FieldValidator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidatorType;
import junit.framework.TestCase;

public class TestRegexpValidation extends TestCase {

	FieldValidator validator;
	
	@Before
	public void setUp() {
		validator = new FieldValidator();
	}
	
	public void testBasicString() {
		Validatable field = new Validatable("value","fieldName", "errormessage", "validation error message");
		validator.setRange(0, 3).validate(ValidatorType.REQUIRED_STRING, field);
		assertEquals(0,validator.getErrors().size());
		validator.validate(ValidatorType.REQUIRED_STRING_LENGTH, field);
		assertEquals(1,validator.getErrors().size());
		//assertEquals("[validation error message]",validator.getErrorAsString("fieldName"));
	}
	
	
	public void testJustLetters() {
		Validatable field = new Validatable("va1ue","fieldName", "errormessage", "validation error message");
		validator.setRange(0, 3).validate(ValidatorType.REQUIRED_LETTER, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue("value");
		validator.validate(ValidatorType.REQUIRED_LETTER, field);
		assertEquals(0,validator.getErrors().size());
	}
}
