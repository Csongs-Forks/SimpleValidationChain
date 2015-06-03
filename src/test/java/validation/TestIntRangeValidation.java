package validation;

import org.junit.Before;
import org.junit.Test;

import net.bircs.validation.generic.FieldValidator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidatorType;
import junit.framework.TestCase;

public class TestIntRangeValidation extends TestCase {

	FieldValidator validator;
	
	@Before
	public void setUp() {
		validator = new FieldValidator();
	}
	
	public void testIntRange() {
		Validatable field = new Validatable("value","fieldName", "errormessage", "validation error message");
		validator.setRange(0, 3).validate(ValidatorType.INT_RANGE, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue(null);
		validator.setRange(0, 1).validate(ValidatorType.INT_RANGE, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue("");
		validator.setRange(0, 1).validate(ValidatorType.INT_RANGE, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue("03");
		validator.setRange(0, 1).validate(ValidatorType.INT_RANGE, field);
		assertEquals(1,validator.getErrors().size());
		validator.reset();
		field.setValue("01");
		validator.setRange(0, 1).validate(ValidatorType.INT_RANGE, field);
		assertEquals(0,validator.getErrors().size());
	}
	
}
