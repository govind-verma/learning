package com.gs.java.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author govinda.verma
 *
 */
public class DriverPCProblem {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		queue.put("Govind");
		queue.put("verma");
		
		System.out.println(queue.take());
		System.out.println(queue.take());
		
	}
}
