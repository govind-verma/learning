package com.gs.java.designpatterns.singleton;
/**
 * 
 * @author govinda.verma
 *
 */
public class DoubleCheckSingleton {
	private static DoubleCheckSingleton INSTANCE = null;

	private DoubleCheckSingleton() {
	}

	public static DoubleCheckSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new DoubleCheckSingleton();
				}
			}
		}
		return INSTANCE;
	}
}
