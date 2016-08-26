package com.gs.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MainThread {
	static ThreadLocal<String> str = new ThreadLocal<>();
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		/*
		 * Counter counter = new Counter(); counter.setCount(1);
		 * 
		 * T1 t1 = new T1(counter); T2 t2 = new T2(counter); T3 t3 = new T3(counter);
		 * 
		 * 
		 * t2.start(); t3.start(); t1.start();
		 */

		/*
		 * ThreadIndicator ti = new ThreadIndicator();
		 * 
		 * T t1 = new T(ti); T t2 = new T(ti); T t3 = new T(ti); T t4 = new T(ti); T t5 = new T(ti);
		 * 
		 * t4.start(); t5.start(); t1.start(); t2.start(); t3.start();
		 */
		/*
		 * CustomLock lock = new CustomLock(); Counter c = new Counter(); LockThread t1 = new LockThread(lock, c); LockThread t2 = new LockThread(lock, c); LockThread t3 = new LockThread(lock, c);
		 * 
		 * 
		 * t2.start(); t3.start(); t1.start();
		 */

		/*
		 * Exchanger<String> ex = new Exchanger<>();
		 * 
		 * new EXT1(ex, "EXT1", "Test1").start();
		 * 
		 * new EXT2(ex, "EXT2", "Test2").start();
		 * 
		 * new EXT2(ex, "EXT3", "Test3").start();
		 */
		/*
		 * ForkJoinPool fjp = new ForkJoinPool(4); ForkRA fra = new ForkRA(); fjp.invoke(fra);
		 */
		/*CyclicBarrier c = new CyclicBarrier(3);
		new CT1(c).start();
		new CT2(c).start();*/
		
		System.out.println(Sub.class.getGenericSuperclass());

	}

}

enum TestEnum{
	
	
}
interface I extends Cloneable{
	
}

abstract class To{
	
}
class Super {
	static{
		System.out.println("Super class static block");
	}
	
	public static void test(int i){
		
	}
	
	public static void test(){
		
	}
	
}

class Sub extends Super {
	static {
		System.out.println("Sub class static block");
	}
}
class CT1 extends Thread {
	
	private CyclicBarrier cb;
	public CT1(CyclicBarrier cb) {
		this.cb = cb;
	}
	public void run() {
		try {
			System.out.println("Start waiting : " + Thread.currentThread().getName());
			this.cb.await();
			Thread.sleep(1000);
			System.out.println("Waking up : " + Thread.currentThread().getName());
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class CT2 extends Thread {
	private CyclicBarrier cb;
	public CT2(CyclicBarrier cb) {
		this.cb = cb;
	}
	public void run() {
		try {
			System.out.println("Start waiting : " + Thread.currentThread().getName());
			this.cb.await();
			System.out.println("Waking up : " + Thread.currentThread().getName());
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ForkRA extends RecursiveAction {

	@Override
	protected void compute() {
		List<RecursiveAction> forkTasks = new ArrayList<>();
		forkTasks.add(new ForkRA1());
		forkTasks.add(new ForkRA2());
		forkTasks.add(new ForkRA3());

		for (RecursiveAction fork : forkTasks) {
			fork.fork();
		}

	}

}

class ForkRA1 extends RecursiveAction {

	@Override
	protected void compute() {
		System.out.println("ForkRA1");

	}

}

class ForkRA2 extends RecursiveAction {

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		System.out.println("ForkRA2");
	}

}

class ForkRA3 extends RecursiveAction {

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		System.out.println("ForkRA3");
	}

}

class EXT1 extends Thread {
	private Exchanger<String> ex;
	private String obj1;
	private String test;

	public EXT1(Exchanger<String> ex, String obj1, String obj2) {
		this.ex = ex;
		this.obj1 = obj1;
		this.test = obj2;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " : " + test);
		String exObj = null;
		try {
			exObj = ex.exchange(test);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + exObj);
	}
}

class EXT2 extends Thread {
	private Exchanger<String> ex;
	private String obj1;
	private String test;

	public EXT2(Exchanger<String> ex, String obj1, String obj2) {
		this.ex = ex;
		this.obj1 = obj1;
		this.test = obj2;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " : " + test);
		String exObj = null;
		try {
			exObj = ex.exchange(test);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + exObj);
	}
}

class EXT3 extends Thread {
	private Exchanger<String> ex;
	private String obj1;
	private String test;

	public EXT3(Exchanger<String> ex, String obj1, String obj2) {
		this.ex = ex;
		this.obj1 = obj1;
		this.test = obj2;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " : " + test);
		String exObj = null;
		try {
			exObj = ex.exchange(test);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + exObj);
	}
}