package com.gs.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author govinda.verma
 *
 */
public class CustomThreadPollExecutor<V> implements CustomExecutorService<V>{
	private  int capacity;
	private AtomicInteger c;
	
	public CustomThreadPollExecutor(int cap) {
		this.capacity = cap;
	}
	@Override
	public void execute(Runnable command) {
		if(capacity > c.get()) {
			
		}
		
	}
	
	
	@Override
	public CustomFutureTask<V> submit(Callable<V> task) {
		CustomFutureTask<V> ftask = new CustomFutureTask<V>(task);
		execute(ftask);
		
		return ftask;
	}
}
