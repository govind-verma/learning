package com.gs.misc;

public class WaitNotifyDemo extends Thread {
	 int val;
	 boolean isFree = false;
	 public WaitNotifyDemo next;

	 public void setNext(WaitNotifyDemo next) {
	  this.next = next;
	 }

	 public WaitNotifyDemo(int val) {
	  this.val = val;
	 }

	 public void setFree(boolean isFree) {
	  this.isFree = isFree;
	 }

	 @Override
	 public void run() {
	  printData();
	 }

	 private void printData() {
	  synchronized (this) {
	   try {
	    while (!isFree) {
	    	System.out.println("isss");
	     //notifyAll();
	    }
	    System.out.println(val);
	    setFree(false);
	    if (next != null) {
	     next.setFree(true);
	    }
	    
	   } catch (Exception e) {
	    System.err.println(e);
	   }
	  }
	 }

	 public static void main(String[] args) {
	  WaitNotifyDemo wnd1 = new WaitNotifyDemo(1);
	  WaitNotifyDemo wnd2 = new WaitNotifyDemo(2);
	  WaitNotifyDemo wnd3 = new WaitNotifyDemo(3);
	  WaitNotifyDemo wnd4 = new WaitNotifyDemo(4);

	  try {
	   wnd1.setNext(wnd2);
	   wnd2.setNext(wnd3);
	   wnd3.setNext(wnd4);

	   wnd2.start();
	   wnd3.start();
	   wnd4.start();
	   wnd1.start();
	
	   wnd1.setFree(true);
	  } catch (Exception e) {
	   System.err.println(e);
	  }
	 }
	}