package com.gs.misc;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;

@Constraint(validatedBy = TestValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface CAnnotation {
	String value() default "";
}

public class CustomAnnotation {
	
	@Valid
	@CAnnotation
	private String nmae;
	
	
	public static void main(String[] args) {
		System.out.println("Success");
	}
	
}

class TestValidator implements ConstraintValidator<Annotation, String> {

	@Override
	public void initialize(Annotation constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("coming");
		if(value == null || value.isEmpty()){
			return false;
		}
		
		if(value.equals("Govind")) {
			return true;
		}
		
		return false;
	}
	
}
