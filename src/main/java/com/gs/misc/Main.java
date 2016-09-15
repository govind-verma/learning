package com.gs.misc;

public class Main {
	public static void main(String[] args) {
		int a = 4;
		int b = 4;
		//System.out.println(b - (((b - a) >> 31) & 0x1) * (b-a));
		/*towerOfHinoi(16, "A", "C", "B");*/
		//
		Integer i = Integer.valueOf("189");
		Integer j = Integer.valueOf("189");
		
		System.out.println(i != j);
		
	}
	
	private static void towerOfHinoi(int disk, String source, String destination, String aux){
		if(disk == 0) {
			return ;
		}
		
		towerOfHinoi(disk - 1, source, aux, destination);
		System.out.println("Moving from source : " + source + " to destination : " + destination);
		towerOfHinoi(disk - 1, aux, destination, source);
	}
}
