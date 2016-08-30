package com.gs.ds.stack;

/**
 * 
 * @author govinda.verma
 *
 * @param <T>
 */
public class TwoStack<T> {
	private int top1 = -1;
	private int top2 = 11;
	
	private T[] data;
	private int maxCapicity = 12;
	
	public TwoStack() {
		data = (T[]) new Object[maxCapicity];
	}
	
	public void push1(T data) {
		if(top1++ >= top2) {
			return;
		}
		
		this.data[top1] = data;
	}
	
	/**
	 * 
	 * @param data
	 */
	public void push2(T data) {
		if(top1 >= top2--) {
			return;
		}
		
		this.data[top2] = data;
	}
	
	/**
	 * 
	 * @return
	 */
	public T pop1(){
		if(top1 < 0) {
			throw new IllegalStateException("Empty stack1...");
		}
		
		return data[top1--];
	}
	
	public T pop2(){
		if(top2 >= maxCapicity - 1) {
			throw new IllegalStateException("Empty stack1...");
		}
		
		return data[top2++];
	}
}
