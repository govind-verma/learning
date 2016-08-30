package com.gs.java.multithreading;

/**
 * 
 * @author govinda.verma
 *
 */
public class PCLock {
	private volatile boolean lock;
	
	/**
	 * 
	 * @throws InterruptedException
	 */
	public synchronized  void readLock() throws InterruptedException{
		while(lock) {
			this.wait();
		}
		
		lock = true;
	}
	
	/**
	 * 
	 * @throws InterruptedException
	 */
	public synchronized  void unlock() throws InterruptedException{
		lock = false;
		this.notify();
	}
}
