package com.gs.java.designpatterns.singleton;

public class ThreadSafeLazySingleton {
	private static ThreadSafeLazySingleton INSTANCE = null;

	private ThreadSafeLazySingleton() {
	}

	public synchronized static ThreadSafeLazySingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ThreadSafeLazySingleton();
		}
		return INSTANCE;
	}
}
