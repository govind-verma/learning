package com.gs.java.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * This will expose how soft, weak, Phantom reference work.
 * 
 * @author govinda.verma
 *
 */
public class ReferenceDriver {
	private static ReferenceQueue<CReference> rq = new ReferenceQueue<>();

	public static void main(String[] args) throws InterruptedException {
		checkWeakRefrence();
	}
	/**
	 * Will be wait for  garbage collected until outOfMemory exception does not throw
	 * @throws InterruptedException
	 */
	private static void checkSoftRefrence() throws InterruptedException {
		CReference c = new CReference("Govind");
		Reference<CReference> wR = new SoftReference<>(c, rq);
		c = null;
		new Thread(new Runnable() {

			@Override
			public void run() {
				List<CReference> l = new ArrayList<>();
				while (true) {
					l.add(new CReference("name"));
				}

			}
		}).start();
		while (true) {
			System.out.println(wR.get().getName());
			Thread.sleep(1200);
		}
	}
	/**
	 * Will be eagerly garbage collected if an object have  only week reference
	 * @throws InterruptedException
	 */
	private static void checkWeakRefrence() throws InterruptedException {
		CReference c = new CReference("Govind");
		Reference<CReference> wR = new WeakReference<>(c, rq);
		c = null;
		new Thread(new Runnable() {

			@Override
			public void run() {
				List<CReference> l = new ArrayList<>();
				while (true) {
					l.add(new CReference("name"));
				}

			}
		}).start();
		while (true) {
			System.out.println(wR.get().getName());
			Thread.sleep(1200);
		}
	}
	/**
	 * Phantom use if you want to do clean up the object which gc can not do.
	 * Phantom reference objects, which are enqueued after the collector 
	 * determines that their referents may otherwise be reclaimed. Phantom references are most often 
	 * used for scheduling pre-mortem cleanup actions in a more flexible way than is possible with the Java finalization mechanism.
	 * 
	 * Unlike soft and weak references, phantom references are not automatically cleared by the garbage collector as they are enqueued. 
	 * An object that is reachable via phantom references will remain so until all such references are cleared or themselves become unreachable.
	 * @throws InterruptedException
	 */
	private static void checkPhantomRefrence() throws InterruptedException {
		CReference c = new CReference("Govind");
		Reference<CReference> wR = new PhantomReference<>(c, rq);
		c = null;
		new Thread(new Runnable() {
			@Override
			public void run() {
				List<CReference> l = new ArrayList<>();
				while (true) {
					l.add(new CReference("name"));
				}

			}
		}).start();
		while (true) {
			rq.poll().clear();
		}
	}
}
