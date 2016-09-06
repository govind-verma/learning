package com.gs.ds.designpatterns.singleton;

public enum EnumSingleton {
	INSTANCE;
	private EnumSingleton() {

	}

	public String doSomthing() {
		return "doSomthing";
	}
}
