package com.gs.java.multithreading;

public class PCData {
	private PCLock lock = new PCLock();
	private  Data data = new Data(); 
	
	public int get() throws InterruptedException{
		Data data = null;
		lock.readLock();
		data = this.data;
		lock.unlock();
		
		return data.getData();
	}
	
	public void put(int data) throws InterruptedException{
		lock.readLock();
		this.data.setData(data);;
		lock.unlock();
	}
}
