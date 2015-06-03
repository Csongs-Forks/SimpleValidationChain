package validation;

import org.junit.Before;
import org.junit.Test;

import net.bircs.validation.generic.FieldValidator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidatorType;
import junit.framework.TestCase;

public class TestShortCircuitValidation extends TestCase {

	FieldValidator validator;
	
	@Before
	public void setUp() {
		validator = new FieldValidator();
	}
	
	public void testBasicString() {
		Validatable field = new Validatable("value","field.name", "errormessage", "validation error message");
		validator.setLength(0,7).validate(ValidatorType.REQUIRED_STRING_LENGTH, field);
		validator.validate(ValidatorType.REQUIRED_STRING_LENGTH, field.setValue("another failing value"));
		assertEquals(1, validator.getErrors().size());
		validator.validate(ValidatorType.REQUIRED_STRING_LENGTH, field.setFieldName("another.fieldName"));
		assertEquals(2, validator.getErrors().size());
	}
}
