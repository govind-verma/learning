package com.gs.java.multithreading;

/**
 * 
 * @author govinda.verma
 *
 */
public class Consumer implements Runnable {
	private PCData data;

	public Consumer(PCData data) {
		this.data = data;
	}
	@Override
	public void run() {
		while(true){
			try {
				
				Integer i = data.get();
				System.out.println("Consuemed Data : " + i );
				if(i == 9) {
					Thread.sleep(100000);
				}
				//Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
