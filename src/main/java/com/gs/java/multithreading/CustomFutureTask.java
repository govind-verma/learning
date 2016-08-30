package com.gs.java.multithreading;

import java.util.concurrent.Callable;

public class CustomFutureTask<V> implements Runnable {
	private Callable<V> task;
	private V result;

	private volatile int state;
	private static int NEW = 0;
	private static int COMPLETING = 1;
	private static int NORMAL = 2;
	private static int EXCEPTION = 3;

	public CustomFutureTask(Callable<V> task) {
		this.state = NEW;
		this.task = task;
	}

	public V get() {
		while (state < COMPLETING) {
			
		}
		if (state == NORMAL) {
			return result;
		}
		return null;
	}

	@Override
	public void run() {
		try {
			if (state == NEW) {
				result = task.call();
				state = NORMAL;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			state = EXCEPTION;
		}
	}
	
	public boolean isDone(){
		return state > COMPLETING;
	}

}
