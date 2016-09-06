package com.gs.ds.designpatterns.singleton;

/**
 * If single threaded application. Which is not possible :)
 * 
 * @author govinda.verma
 *
 */
public class LazySingleton {
	private static LazySingleton INSTANCE = null;

	private LazySingleton() {
	}

	public static LazySingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LazySingleton();
		}
		return INSTANCE;
	}
}
