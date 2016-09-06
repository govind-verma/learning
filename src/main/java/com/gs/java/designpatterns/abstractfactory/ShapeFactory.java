package com.gs.java.designpatterns.abstractfactory;

public class ShapeFactory extends AbstractFactory {

	@Override
	public IShape getShape(String shape) {
		if (shape != null && !shape.isEmpty()) {
			if ("circle".equals(shape)) {
				return new Circle();
			} else if ("rectangle".equals(shape)) {
				return new Rectangle();
			}
		}
		return null;
	}

}
