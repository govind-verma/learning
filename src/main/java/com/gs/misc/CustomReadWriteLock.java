package com.gs.misc;

public class CustomReadWriteLock {
	private int readers;
	private int writers;
	private int writeRequest;
	
	public synchronized void  readLock() throws InterruptedException{
		while(writers > 0 || writeRequest > 0) {
			this.wait();
		}
		readers++;
	}
	
	public synchronized void readUnlock(){
		readers--;
		this.notifyAll();
	}
	
	public synchronized void writeLock() throws InterruptedException{
		writeRequest++;
		while(readers > 0 || writers > 0) {
			this.wait();
		}
		writeRequest--;
		writers++;
	}
	
	public synchronized void writeUnLock() throws InterruptedException{
		writers--;
		this.notifyAll();
	}
}
