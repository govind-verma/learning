package com.gs.ds.designpatterns.singleton;

public class EagerSingleton {
	private EagerSingleton() {

	}

	private static final EagerSingleton INSTANCE = new EagerSingleton();

	public static EagerSingleton getInstance() {
		return INSTANCE;
	}
}

class StaticBlockEagerSingleton {
	private static final StaticBlockEagerSingleton INSTANCE;
	static {
		INSTANCE = new StaticBlockEagerSingleton();
	}

	private StaticBlockEagerSingleton() {

	}

	public static StaticBlockEagerSingleton getInstance() {
		return INSTANCE;
	}
}
