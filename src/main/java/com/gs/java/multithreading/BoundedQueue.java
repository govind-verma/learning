package com.gs.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue<T> {
	private volatile List<T> list;
	private Lock lock = new ReentrantLock();

	private Condition isEmpty = lock.newCondition();
	private Condition isFull = lock.newCondition();

	private final int CAPICITY = 10;

	public BoundedQueue() {
		list = new ArrayList<>(CAPICITY);
	}

	public void add(T data) {
		try {
			lock.lock();
			while (list.size() == CAPICITY) {
				System.out.println("Producer Waiting");
				isFull.await();
				System.out.println("Waking up Producer");
			}
			list.add(data);
			System.out.println("produce : " + data);
			isEmpty.signalAll();
		} catch (InterruptedException e) {
		} finally {
			lock.unlock();
		}
	}

	public void remove() {
		try {
			lock.lock();
			while (list.size() == 0) {
				System.out.println("Consumer Waiting");
				isEmpty.await();
				System.out.println("Waking up Consumer");
			}
			T data = list.remove(list.size() - 1);
			System.out.println("Consume : " + data);
			isFull.signal();
		} catch (InterruptedException e) {

		} finally {
			lock.unlock();
		}
	}
}
