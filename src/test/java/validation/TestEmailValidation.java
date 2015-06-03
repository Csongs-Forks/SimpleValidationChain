package validation;

import org.junit.Before;
import org.junit.Test;

import net.bircs.validation.generic.FieldValidator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidatorType;
import junit.framework.TestCase;

public class TestEmailValidation extends TestCase {

	FieldValidator validator;
	
	@Before
	public void setUp() {
		validator = new FieldValidator();
	}
	
	public void testBasicString() {
		Validatable field = new Validatable("xxx","email", "errormessage", "validation error message");
		validator.validate(ValidatorType.REQUIRED_EMAIL, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue("");
		validator.validate(ValidatorType.REQUIRED_EMAIL, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue(null);
		validator.validate(ValidatorType.REQUIRED_EMAIL, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue("something@gmail.com");
		validator.validate(ValidatorType.REQUIRED_EMAIL, field);
		assertEquals(0,validator.getErrors().size());
	}
}
