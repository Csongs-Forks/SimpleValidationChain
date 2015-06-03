package validation;

import org.junit.Before;
import org.junit.Test;

import net.bircs.validation.generic.FieldValidator;
import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidatorType;
import junit.framework.TestCase;

public class TestExclusionValidation extends TestCase {

	FieldValidator validator;
	
	@Before
	public void setUp() {
		validator = new FieldValidator();
	}
	
	public void testExclusionChain() {
		Validatable field = new Validatable("moo","fieldName", "errormessage", "validation error message");
		validator.setMinValue(1).setPattern("-1").validate(ValidatorType.STRING_EXCLUDE, field);
		assertEquals(0,validator.getErrors().size());
		field.setValue("-1");
		validator.setMinValue(1).setPattern("-1").validate(ValidatorType.STRING_EXCLUDE, field);
		assertEquals(1,validator.getErrors().size());
		
	}
}
