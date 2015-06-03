package validation;

import org.junit.Before;
import org.junit.Test;

import net.bircs.validation.generic.FieldValidator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidatorType;
import junit.framework.TestCase;

public class TestConfirmValidation extends TestCase {

	FieldValidator validator;
	
	@Before
	public void setUp() {
		validator = new FieldValidator();
	}
	
	public void testConfrim() {
		Validatable field = new Validatable("","confirmf", "errormessage", "validation error message");
		validator.validate(ValidatorType.REQUIRED_CONFIRM, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue(null);
		validator.validate(ValidatorType.REQUIRED_CONFIRM, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue("false");
		validator.validate(ValidatorType.REQUIRED_CONFIRM, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue("true");
		validator.validate(ValidatorType.REQUIRED_CONFIRM, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue(new Boolean(true).toString());
		validator.validate(ValidatorType.REQUIRED_CONFIRM, field);
		assertEquals(1,validator.getErrors().size());
	}
}
