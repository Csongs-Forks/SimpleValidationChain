package validation;

import org.junit.Before;
import org.junit.Test;

import net.bircs.validation.generic.FieldValidator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidatorType;
import junit.framework.TestCase;

public class TestIntLengthValidation extends TestCase {

	FieldValidator validator;
	
	@Before
	public void setUp() {
		validator = new FieldValidator();
	}
	
	public void testIntLength() {
		Validatable field = new Validatable("value","fieldName", "errormessage", "validation error message");
		validator.setLength(0, 3).validate(ValidatorType.INT_LENGTH, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue("01");
		validator.setRange(1,31).setLength(0, 3).validate(ValidatorType.INT_LENGTH, field);
		
	}
	
}
