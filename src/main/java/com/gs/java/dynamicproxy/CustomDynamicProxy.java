package com.gs.java.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

public class CustomDynamicProxy {
	public static void main(String[] args) {
		Test t = new TestImpl();
		InvocationHandler in = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return method.invoke(t, args);
			}
		};

		Test o = (Test) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				new Class[] { Test.class }, in);
		Data d = new Data();
		o.a(d);
	}
}

class Data {
	private int a;
	private String b;
}

class TestImpl implements Test {

	@Override
	public void a(Data d) {
		System.out.println("A");

	}

}

interface Test {
	public void a(Data d);
}
