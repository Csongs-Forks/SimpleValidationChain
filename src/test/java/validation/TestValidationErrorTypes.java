package validation;

import org.junit.Before;
import org.junit.Test;

import net.bircs.validation.generic.FieldValidator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.Validator;
import net.bircs.validation.generic.ValidatorType;
import junit.framework.TestCase;

public class TestValidationErrorTypes extends TestCase {

	FieldValidator validator;
	
	@Before
	public void setUp() {
		validator = new FieldValidator();
	}
	
	public void testErrorType() {
		Validatable field = new Validatable("value","fieldName","errormessage", "validation error message");
		validator.setRange(0,3).validate(ValidatorType.REQUIRED_STRING, field);
		assertEquals(Validator.FIELD_ERROR,field.getErrorType());
		validator.setLength(1, 2).validate(ValidatorType.REQUIRED_STRING_LENGTH, field);
		assertEquals(Validator.DATA_ERROR, field.getErrorType());
	}
	
}
