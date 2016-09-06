package com.gs.java.designpatterns;

import com.gs.java.designpatterns.abstractfactory.FactoryProducer;
import com.gs.java.designpatterns.abstractfactory.IFactory;

public class AbstractFactoryDemo {
	public static void main(String[] args) {

		IFactory iF = FactoryProducer.getFactory("shape");
		System.out.println(iF.getShape("circle"));

	}

}
