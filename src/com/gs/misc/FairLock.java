package com.gs.misc;

import java.util.ArrayList;
import java.util.List;

public class FairLock {
	private boolean isLocked = false;
	private List<Lock> waitingThreads = new ArrayList<>();
	private Thread currentThread = null;

	public void lock() {
		boolean isCurrentThreadLocked = true;
		Lock l = new Lock();
		synchronized (this) {
			waitingThreads.add(l);
		}
		while (isCurrentThreadLocked) {
			synchronized (this) {
				isCurrentThreadLocked = isLocked || waitingThreads.get(0) != l;
				if (!isCurrentThreadLocked) {
					isLocked = true;
					waitingThreads.remove(l);
					currentThread = Thread.currentThread();
					return;
				}
			}
			try {
				l.doWait();
			} catch (InterruptedException e) {
				synchronized (this) {
					waitingThreads.remove(l);
				}
			}
		}

	}

	public synchronized void unlock() {
		if(Thread.currentThread() != currentThread) {
			throw new IllegalMonitorStateException();
		}
		isLocked = false;
		if(waitingThreads.size() > 0) {
			waitingThreads.get(0).doNotify();
		}
	}

}

class Lock {
	private boolean isLocked = false;

	public synchronized void doWait() throws InterruptedException {
		while (isLocked) {
			this.wait();

		}
		isLocked = true;
	}

	public synchronized void doNotify() {
		this.isLocked = false;
		this.notify();
	}
}
