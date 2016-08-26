package com.gs.misc;

public class CustomLock {
	private boolean isLocked = false;
	private Thread lockThread = null;

	public synchronized void lock() {
		while (isLocked) {
			try {
				this.wait();
			} catch (InterruptedException e) {

			}
		}
		isLocked = true;
		lockThread = Thread.currentThread();
	}

	public synchronized void unlock() {
		if (Thread.currentThread() != lockThread) {
			throw new IllegalMonitorStateException();
		}
		lockThread = null;
		isLocked = false;
		this.notifyAll();
	}
}
