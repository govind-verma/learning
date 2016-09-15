package com.gs.java.multithreading;

public class SequenceThreadLocal {
	private static ThreadLocal<Integer> sequence = new ThreadLocal<>();

	public static Integer get() {
		return sequence.get();
	}

	public static void set(Integer value) {
		sequence.set(value);
	}
}
