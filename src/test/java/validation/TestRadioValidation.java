package validation;

import org.junit.Before;
import org.junit.Test;

import net.bircs.validation.generic.FieldValidator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidatorType;
import junit.framework.TestCase;

public class TestRadioValidation extends TestCase {

	FieldValidator validator;
	
	@Before
	public void setUp() {
		validator = new FieldValidator();
	}
	
	public void testRequiredValueRadio() {
		Validatable field = new Validatable(null,"fieldName", "errormessage", "validation error message");
		validator.validate(ValidatorType.REQUIRED, field);
		assertEquals(1,validator.getErrors().size());
		field.setValue("");
		validator.reset();
		validator.validate(ValidatorType.REQUIRED, field);
		assertEquals(1,validator.getErrors().size());
	}
	
}
