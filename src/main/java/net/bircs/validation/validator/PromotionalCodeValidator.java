package net.bircs.validation.validator;

import java.util.Arrays;
import java.util.List;

import net.bircs.validation.generic.Validator;
import org.apache.commons.validator.GenericValidator;

import net.bircs.validation.generic.Validatable;
import net.bircs.validation.generic.ValidationContext;

public class PromotionalCodeValidator extends Validator {


	/* Inject the codes here */
	List<String> codes = Arrays.asList(	"VL0101/V99",
										"VL0102/V99",
										"VL0103/V99",
										"VL0104/V99",
										"VL0201/V99",
										"VL0202/V99",
										"VL0401/V99",
										"VL0402/V99",
										"VL0403/V99",
										"VL0501/V99",
										"VL0502/V99",
										"VL0503/V99",
										"VL0601/V99",
										"VL0602/V99",
										"VL0603/V99",
										"VL0701/V99",
										"VL0801/V99",
										"VL0802/V99",
										"VL0901/V99",
										"VL1001/V99",
										"VL1002/V99",
										"VL1102/V99");
	
	@Override
	protected boolean isValid(ValidationContext context,
			Validatable validateable) {
		if (!GenericValidator.isBlankOrNull(validateable.getValue())) {
			return codes.contains(validateable.getValue()) ? true : false;
		} else {
			return true;
		}
	}

}
