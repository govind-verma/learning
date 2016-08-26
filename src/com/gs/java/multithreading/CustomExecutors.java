package com.gs.java.multithreading;

/**
 * Its Factory of Executors
 * @author govinda.verma
 *
 */
public class CustomExecutors {
	public static CustomExecutorService getFixedThreadPoll(int cap) {
		if (cap > 0) {
			return new CustomThreadPollExecutor(cap);
		}

		return null;
	}
}
