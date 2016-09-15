package com.gs.java.generic;

public class GenericDriver {
	public static void main(String[] args) {
		IntegerOperation<Double> str = new IntegerOperation<>();
		System.out.println(str.add(2D, 3D));
		ITest<? extends Number> i = new Test<>();
		i = new Test<Float>();
	}
}

class IntegerOperation<T extends Number> {
	public int add(T a, T b) {
		return (a.intValue() + b.intValue());
	}
}

interface ITest<T> {
	public void t(T t);
}

class Test<T extends Number> implements ITest<T> {

	@Override
	public void t(T t) {

	}
}