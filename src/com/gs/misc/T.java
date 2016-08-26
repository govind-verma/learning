package com.gs.misc;

public class T extends Thread {
	private ThreadIndicator ti;

	public T(ThreadIndicator ti) {
		this.ti = ti;
	}

	public void run() {
		synchronized (ti) {
			while (!ti.isHasDone()) {
				try {
					ti.wait();
				} catch (InterruptedException e) {
				}
			}
			
			System.out.println(ti.getVal());
			ti.setVal(ti.getVal() + 1);
			ti.setHasDone(true);
			ti.notifyAll();
		}
	}

}
