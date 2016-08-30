package com.gs.misc;

public class T2 extends AbstractThread {
	private   Counter num;
	public T2(Counter num) {
		this.num = num;
	}
	public void run() {
		System.out.println("T2 start");
		synchronized (num) {
			System.out.println("Accured T2");
			while (num.getCount() != 2) {
				try {
					System.out.println("Start waiting T2");
					num.wait();
					System.out.println("Thread T2 waking up");
				} catch (InterruptedException e) {
					System.out.println("Erro and checking : " + Thread.currentThread().getName());
				}
			}
			
			System.out.println("Thread T2" + num.getCount());
			num.setCount(num.getCount() + 1);
			num.notifyAll();
		}
	}
}
