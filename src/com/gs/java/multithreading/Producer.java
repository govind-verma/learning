package com.gs.java.multithreading;

/**
 * 
 * @author govinda.verma
 *
 */
public class Producer implements Runnable {
	private PCData data;

	public Producer(PCData data) {
		this.data = data;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				data.put(i);
				System.out.println("Produced Data : " + i);
				Thread.sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) {

			}
		}
	}

}
