package com.gs.misc;

import java.io.Serializable;

public class SingletonClass implements Serializable {
	private SingletonClass() {
	}

	private static class SingletonClassHelper {
		private static final SingletonClass INSTANCE = new SingletonClass();
	}

	public static SingletonClass getInstance() {
		return SingletonClassHelper.INSTANCE;
	}

	/**
	 */
	protected Object readResolve() {
		return getInstance();
	}

}
