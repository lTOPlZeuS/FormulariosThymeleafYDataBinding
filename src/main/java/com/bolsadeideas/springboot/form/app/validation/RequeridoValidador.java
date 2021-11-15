package com.bolsadeideas.springboot.form.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//StringUtils.hasText(value) == value.isEmpty() || value.isBlank()
		if(value == null || !StringUtils.hasText(value)) {
			return false;
		}
		return true;
	}
}
