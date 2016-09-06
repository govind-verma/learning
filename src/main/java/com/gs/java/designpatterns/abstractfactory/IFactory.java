package com.gs.java.designpatterns.abstractfactory;

public interface IFactory {
	public IShape getShape(String shape);
	public IColor getColor(String color);
}
