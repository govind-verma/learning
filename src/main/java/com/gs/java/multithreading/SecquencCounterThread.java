package com.gs.java.multithreading;

public class SecquencCounterThread implements Runnable {
	private CDataSeq data;

	public SecquencCounterThread(CDataSeq data) {
		this.data = data;
	}

	@Override
	public void run() {
		while (data.getCounter() <= 100) {
			synchronized (data) {
				if (SequenceThreadLocal.get() != null) {
					while (SequenceThreadLocal.get() != data.getSeq()) {
						try {
							data.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				SequenceThreadLocal.set(data.getSeq());
				
				if (data.getCounter() == 100) {
					break;
				}
				System.out.println(Thread.currentThread().getName() + " : " + (data.getCounter() + 1));

				data.setCounter(data.getCounter() + 1);

				if (data.getSeq() == 2) {
					data.setSeq(0);
				} else {
					data.setSeq(data.getSeq() + 1);
				}
				data.notifyAll();
			}
		}
	}
}