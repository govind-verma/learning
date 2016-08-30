package com.gs.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public class CustomAsyncAnnotation {
	public static void main(String[] args) {
		Class<CAsyncTest> cl = CAsyncTest.class;
		ICAsyncTest c = new CAsyncTest();
		ICAsyncTest cp = null;

		Method[] ms = cl.getMethods();
		Set<Method> methods = new HashSet<>();

		for (Method m : ms) {
			Annotation[] as = m.getAnnotations();
			for (Annotation a : as) {
				if ("@com.gs.annotation.CAsync(ca=true)".equals(a.toString())) {
					methods.add(m);
					System.out.println("find casync on method" + m.getName());
				} else {
					System.out.println("not find casync on method" + m.getName());
				}
			}
		}
		cp = (ICAsyncTest) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				new Class[] { ICAsyncTest.class }, new CAsyncInvocationHandler(c, methods));
		cp.t();
		cp.nt();
		cp.ntt();

	}
}

class CAsyncTest implements ICAsyncTest {
	
	@CAsync
	public void t() {
		System.out.println(Thread.currentThread().getName());
	}

	@CAsync
	public void nt() {
		System.out.println(Thread.currentThread().getName());
	}

	@CAsync
	public void ntt() {
		System.out.println(Thread.currentThread().getName());
	}
}