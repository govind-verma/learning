package com.gs.ds.designpatterns.singleton;

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
