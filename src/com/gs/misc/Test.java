package com.gs.misc;

import java.io.IOException;
import java.lang.reflect.Constructor;

import org.apache.http.client.ClientProtocolException;

public class Test {
	public static void main(String[] args) throws ClientProtocolException, IOException, ClassNotFoundException {
		/*ByteArrayOutputStream b = new ByteArrayOutputStream(10);
		ObjectOutput out = new ObjectOutputStream(b);
		SingletonClass ss = SingletonClass.getInstance();
		out.writeObject(ss);
		
		ByteArrayInputStream i = new ByteArrayInputStream(b.toByteArray());
		ObjectInput oi = new ObjectInputStream(i);
		SingletonClass sc = (SingletonClass)oi.readObject();
		System.out.println(sc.hashCode());
		System.out.println(ss.hashCode());
		*/
		
		SingletonClass instanceOne = SingletonClass.getInstance();
		SingletonClass instanceTwo = null;
	        try {
	            Constructor[] constructors = SingletonClass.class.getDeclaredConstructors();
	            for (Constructor constructor : constructors) {
	                //Below code will destroy the singleton pattern
	                constructor.setAccessible(true);
	                instanceTwo = (SingletonClass) constructor.newInstance();
	                break;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.out.println(instanceOne.hashCode());
	        System.out.println(instanceTwo.hashCode());
		
		
	}
}
