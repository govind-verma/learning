package com.gs.misc;

public class Queue{
     
    private static final int capacity = 5;
    private Integer[] Q;
    private final int N; // capacity
    private int f = 0;
    private int r = 0;
 
     
    public Queue(){
        this(capacity);
    }
     
    public Queue(int capacity){
        N = capacity;
        Q = new Integer[N];
    }
 
    public int size() {
        if(r > f)
            return r - f;
        return N - f + r;
    }
 
    public boolean isEmpty() {
        return (r == f) ? true : false;
    }
 
    public boolean isFull() {
        int diff = r - f; 
        if(diff == -1 || diff == (N -1))
            return true;
        return false;
    }
 
    public void enqueue(Integer obj) {
    	if((r+1) % N != f)
    	{
    	r = (r+1)%N;
    	Q[r] = obj;
    	}
    	
    	if(isFull()){
           System.out.println("Full");
        }else{
            Q[r] = obj;
            r = (r + 1) % N;
            System.out.println("Addedd " + obj);
        }
        
    }
 
    public Object dequeue() {
        Object item = null; 
        if(isEmpty()){
        	System.out.println("Empty");
        }else{
            item = Q[f];
            Q[f] = null;
            f = (f + 1) % N;
        }
       return item;
    }
 
}