package com.gs.ds.stack;

/**
 * 
 * @author govinda.verma
 *
 * @param <T>
 */
public class CustomStack<T> {
	private int top = -1;
	private T[] data;
	private int maxCapicity = 12;
	
	@SuppressWarnings("unchecked")
	public CustomStack(){
		data = (T[]) new Object[maxCapicity];
	}
	
	/**
	 * 
	 * @param element
	 */
	public void push(T element) {
		if (++top == maxCapicity) {
			maxCapicity = 2 * maxCapicity;
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[maxCapicity];

			System.arraycopy(data, 0, temp, 0, top - 1);
			this.data = temp;
			
		}
		
		data[top] = element;
	}
	
	/**
	 * 
	 * @return
	 */
	public T pop(){
		if(top  == -1) {
			throw  new IllegalStateException("Empty Stack...");
			
		}
		return data[top--];
	}
	
	/**
	 * 
	 * @return
	 */
	public T peek(){
		if(top  == -1) {
			throw  new IllegalStateException("Empty Stack...");
			
		}
		return data[top];
	}
	
	/**
	 * 
	 * @return
	 */
	public int size(){
		return top == -1 ? 0 : top + 1;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty(){
		return top == -1 ? true : false;
	}
	
	/**
	 * 
	 */
	public void clear(){
		while(!this.isEmpty()){
			this.pop();
		}
	}
}
