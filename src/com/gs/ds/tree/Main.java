package com.gs.ds.tree;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

import sun.misc.Unsafe;

public class Main {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
//		Trie t = new Trie();
//		t.addTrieNode("abc");
//		t.addTrieNode("bcd");
//		t.addTrieNode("aef");
//		
//		
//		Field f = Unsafe.class.getDeclaredField("theUnsafe");
//		f.setAccessible(true);
//		String str = "nuklksakjhkahskjahsgajhgsjahgsjhgasjagjg";
//				
//		Unsafe unsafe = (Unsafe) f.get(null);
//		
		
		
		
	}
	
	
	public static long sizeOf(Unsafe u, Object o) {
	    
	    HashSet<Field> fields = new HashSet<Field>();
	    Class c = o.getClass();
	    while (c != Object.class) {
	        for (Field f : c.getDeclaredFields()) {
	            if ((f.getModifiers() & Modifier.STATIC) == 0) {
	                fields.add(f);
	            }
	        }
	        c = c.getSuperclass();
	    }

	    // get offset
	    long maxSize = 0;
	    for (Field f : fields) {
	        long offset = u.objectFieldOffset(f);
	        if (offset > maxSize) {
	            maxSize = offset;
	        }
	    }

	    return ((maxSize/8) + 1) * 8;   // padding
	}
}
class A{
	private int i;
	
	public A(){
		this.i = 5;
		System.out.println("Fuck");
	}
	
	public int getI(){
		return i;
	}
	
	
}
