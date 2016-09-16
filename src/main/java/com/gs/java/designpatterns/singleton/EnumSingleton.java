package com.gs.java.designpatterns.singleton;

public enum EnumSingleton {
	INSTANCE;
	private EnumSingleton() {

	}

	public String doSomthing() {
		return "doSomthing";
	}
}
