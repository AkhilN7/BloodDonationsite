package com.blooddonation.blooddonation;

import java.util.List;
import java.util.Arrays;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GroupValidator implements ConstraintValidator<Group,String>{

    List<String> groups=Arrays.asList("A+","A-","B+","B-","AB+","AB-","O+","O-");
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (String string : groups) {
            if (value.equals(string)) return true;
        }
        return false;
    }
    
}
