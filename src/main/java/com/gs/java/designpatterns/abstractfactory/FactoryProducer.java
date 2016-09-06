package com.gs.java.designpatterns.abstractfactory;

public class FactoryProducer {
	public static IFactory getFactory(String factoryName) {
		if ("shape".equals(factoryName)) {
			return new ShapeFactory();
		} else if ("color".equals(factoryName)) {
			return new ColorFactory();
		}

		return null;
	}
}
