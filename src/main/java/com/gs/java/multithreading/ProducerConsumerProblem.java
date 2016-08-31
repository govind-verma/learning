/**
 * @author govind verma
 */
package com.gs.java.multithreading;

import java.util.UUID;

public class ProducerConsumerProblem {
	public static void main(String[] args) {
		BoundedQueue<String> queue = new BoundedQueue<>();
		new Thread(new ProducerTheread(queue)).start();
		new Thread(new ConumerTheread(queue)).start();
	}
}

class ProducerTheread implements Runnable {
	private BoundedQueue<String> queue;

	public ProducerTheread(BoundedQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				String uuid = UUID.randomUUID().toString();
				queue.add(uuid);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class ConumerTheread implements Runnable {
	private BoundedQueue<String> queue;

	public ConumerTheread(BoundedQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				queue.remove();
				Thread.sleep(10000);
			} catch (Exception e) {

			}
		}
	}
}
