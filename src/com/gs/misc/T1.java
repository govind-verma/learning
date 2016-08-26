package com.gs.misc;

public class T1 extends AbstractThread {
	private  Counter num;
	
	public T1(Counter num) {
		this.num = num;
	}
	public void run() {
		System.out.println("T1 start");
		synchronized (num) {
			System.out.println("Accured T1");
			while (num.getCount() != 1) {
				try {
					System.out.println("Start waiting T1");
					num.wait();
					System.out.println("Thread T1 waking up");
				} catch (InterruptedException e) {
					System.out.println("Erro and checking : " + Thread.currentThread().getName());
				}
			}
			
			System.out.println("Thread T1" + num.getCount());
			num.setCount(num.getCount() + 1);
			num.notifyAll();
		}
	}

}
