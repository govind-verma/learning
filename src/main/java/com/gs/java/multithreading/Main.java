package com.gs.java.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		RunnableData d = new RunnableData("start");
		//
		// Thread t1 = new Thread(new RunnableReadTask(d));
		// Thread t2 = new Thread(new RunnableWriteTask(d));
		//
		// t2.start();
		// t1.start();
		CounterThreadData counterThreadData = new CounterThreadData(1);

		Thread t1 = new Thread(new CounterThread(counterThreadData, 1));
		Thread t2 = new Thread(new CounterThread(counterThreadData, 2));
		Thread t3 = new Thread(new CounterThread(counterThreadData, 3));

		t3.start();
		t1.start();
		t2.start();

	}
}

class CounterThreadData {
	private int data;

	public CounterThreadData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

class CounterThread implements Runnable {

	private volatile CounterThreadData counterThreadData;
	private int sec;

	public CounterThread(CounterThreadData counterThreadData, int sec) {
		// TODO Auto-generated constructor stub
		this.counterThreadData = counterThreadData;
		this.sec = sec;
	}

	@Override
	public void run() {
		synchronized (counterThreadData) {
			while (counterThreadData.getData() != sec) {
				try {
					counterThreadData.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println(counterThreadData.getData());
			counterThreadData.setData(counterThreadData.getData() + 1);
			counterThreadData.notifyAll();
		}

	}

}

class Reentrant {
	public synchronized void test1() {
		System.out.println("test1");
		test2();
	}

	public synchronized void test2() {
		System.out.println("test2");
	}

}

class RunnableData {
	private String data;

	public RunnableData(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}

class RunnableWriteTask implements Runnable {
	private RunnableData data;

	public RunnableWriteTask(RunnableData data) {
		this.data = data;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (data) {
				while (data.getData() != null) {
					try {
						System.out.println("Waiting Thread " + Thread.currentThread().getName());
						data.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				String uuid = UUID.randomUUID().toString();
				System.out.println(Thread.currentThread().getName() + " write data : " + uuid);
				data.setData(uuid);
				data.notify();
			}
		}
	}

}

class RunnableReadTask implements Runnable {
	private RunnableData data;

	public RunnableReadTask(RunnableData data) {
		this.data = data;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (data) {
				while (data.getData() == null) {
					try {
						System.out.println("Waiting Thread " + Thread.currentThread().getName());
						data.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + "  Read data : " + data.getData());
				data.setData(null);
				data.notify();
			}
		}
	}

}