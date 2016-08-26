package com.gs.java.multithreading;


public class CustomWorker<V> implements Runnable{
	private Thread worker;
	private Runnable task;
	
	public CustomWorker(Runnable task){
		this.task = task;
			
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
