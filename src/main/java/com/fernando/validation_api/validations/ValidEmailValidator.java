package com.fernando.validation_api.validations;

import com.fernando.validation_api.validations.annotations.ValidEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String>{
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null) {
            return false;
        }
       return email.matches("^[a-z][\\w-_\\.]+@([\\w]+\\.)+[\\w]{2,4}$");
    }
    
}
