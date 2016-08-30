package com.gs.misc;

/**
 * 
 * @author govinda.verma
 *
 */
public abstract class AbstractThread extends Thread {

	public Object lock = new Object();
	
	public volatile int count = 1;

}
