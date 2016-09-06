package com.ds.java.designpatterns;

import com.gs.ds.designpatterns.singleton.EnumSingleton;

public class SingletonDemo {
	public static void main(String[] args) {
		System.out.println(EnumSingleton.INSTANCE.doSomthing());
	}
}
