package com.gs.java.designpatterns;

import com.gs.java.designpatterns.singleton.EnumSingleton;

public class SingletonDemo {
	public static void main(String[] args) {
		System.out.println(EnumSingleton.INSTANCE.doSomthing());
	}
}
