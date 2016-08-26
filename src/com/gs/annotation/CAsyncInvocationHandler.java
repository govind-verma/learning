package com.gs.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

public class CAsyncInvocationHandler implements InvocationHandler {
	private Object o;
	private Set<Method> methods;

	public CAsyncInvocationHandler(Object o, Set<Method> methods) {
		this.o = o;
		this.methods = methods;
	}

	@Override
	public Object invoke(Object o, Method m, Object[] a) throws Throwable {
		if (methods != null) {
			Runnable task = (Runnable) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
					new Class[] { Runnable.class }, new ThreadInvocationHandler(this.o, m, a));
			new Thread(task).start();
		} else {
			m.invoke(this.o, a);
		}
		return null;
	}

	private static class ThreadInvocationHandler implements InvocationHandler {
		private Object ao;

		private Method am;
		private Object[] aa;

		public ThreadInvocationHandler(Object o, Method m, Object[] a) {
			this.aa = a;
			this.ao = o;
			this.am = m;
		}

		@Override
		public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
			return am.invoke(ao, aa);
		}

	}

}
