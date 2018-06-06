package com.testcomp.testweb;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

public class NotEmptyValidator implements ConstraintValidator<NotEmpty, String> {  
  
    @Override  
    public void initialize(NotEmpty constraintAnnotation) {  
    }  
  
    @Override  
    public boolean isValid(String value, ConstraintValidatorContext context) {  
        return StringUtils.isNotEmpty(value);  
    }  
}