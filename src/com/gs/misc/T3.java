package com.gs.misc;

public class T3 extends AbstractThread {
	private   Counter num;

	public T3(Counter num) {
		this.num = num;
	}

	public void run() {
		System.out.println("T3 start");
		synchronized (num) {
			System.out.println("Accured T3");
			while (num.getCount() != 3) {
				try {
					System.out.println("Start waiting T3");
					num.wait();
					System.out.println("Thread T3 waking up");
				} catch (InterruptedException e) {
					System.out.println("Erro and checking : " + Thread.currentThread().getName());
				}
			}
			
			System.out.println("Thread T3" + num.getCount());
			num.setCount(num.getCount() + 1);
			num.notifyAll();
		}
	}
}
