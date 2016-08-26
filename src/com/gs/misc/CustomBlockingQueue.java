package com.gs.misc;

import java.util.ArrayList;
import java.util.List;

public class CustomBlockingQueue {
	private List<Counter> blockingQueue = new ArrayList<>();
	private int maxLimit = 10;
	
	public CustomBlockingQueue(int maxLimit) {
		this.maxLimit = maxLimit;
	}
	
	
	public synchronized void enqueue(Counter c) throws InterruptedException{
		while(blockingQueue.size() == this.maxLimit) {
			this.wait();
		}
			
		if(this.blockingQueue.size() == 0) {
			notifyAll();
		}
		blockingQueue.add(c);
	}
	
	public synchronized void dequeue() throws InterruptedException{
		while(blockingQueue.size() == 0) {
			this.wait();
		}
		
		blockingQueue.remove(0);
	}
}
