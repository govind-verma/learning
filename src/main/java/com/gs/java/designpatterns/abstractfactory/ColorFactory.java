package com.gs.java.designpatterns.abstractfactory;

public class ColorFactory  extends AbstractFactory{
	@Override
	public IColor getColor(String color) {
		if (color != null && !color.isEmpty()) {
			if ("red".equals(color)) {
				return new Red();
			} else if ("black".equals(color)) {
				return new Black();
			}
		}
		return null;
	}
}
