package com.gs.java.multithreading;

import java.util.concurrent.Callable;

/**
 * 
 * @author govinda.verma
 *
 */
public interface CustomExecutorService<V> {
	public void execute(Runnable command);
	CustomFutureTask<V> submit(Callable<V> task);
	
}
