package com.gs.misc;

public class TThread extends Thread {
	
	private Counter counter;
	private int whatToAdd;
	public  TThread(Counter counter, int whatToAdd) {
		this.counter = counter;
		this.whatToAdd = whatToAdd;
	}
	
	@Override
	public void run() {
		for(int i = 0; i <= 10; i++) {
			/*try {
				counter.add(whatToAdd);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
}
