package com.gs.misc;

public class LockThread  extends Thread{
	private CustomLock lock;
	private  Counter c;
	
	public LockThread(CustomLock lock, Counter c) {
		this.lock = lock;
		this.c = c;
	}
	
	public void run(){
		lock.lock();
		System.out.println(c.getCount());
		c.setCount(c.getCount() + 1);
		lock.unlock();
	}
}
