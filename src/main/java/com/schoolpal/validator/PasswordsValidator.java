package com.schoolpal.validator;

import com.schoolpal.web.model.PasswordsForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsValidator implements ConstraintValidator<Passwords, PasswordsForm>{

    @Override
    public void initialize(Passwords constraintAnnotation) {

    }

    @Override
    public boolean isValid(PasswordsForm value, ConstraintValidatorContext context) {
        if (value.getOriPass().trim().equals(value.getNewPass().trim())) {
            return false;
        }
        return true;
    }
}
