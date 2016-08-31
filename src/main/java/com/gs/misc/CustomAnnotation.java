package com.gs.misc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



//@Constraint(validatedBy = TestValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface CAnnotation {
	String value() default "";
}

public class CustomAnnotation {

	// @Valid
	@CAnnotation
	private String nmae;

	public static void main(String[] args) {
		System.out.println("Success");
	}

}



