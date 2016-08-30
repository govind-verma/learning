package com.gs.misc;

public class LeaderElement {
	public static void main(String[] args) {
		int[] elements = new int[] {16, 17, 4, 3, 5, 2};
		printLeaderElement(elements);
	}
	/**
	 * 
	 * @param elements
	 */
	private static void printLeaderElement(int[] elements) {
		if(elements != null && elements.length > 0) {
			int len  = elements.length - 1;
			int leader = Integer.MIN_VALUE;
			for(int i = len; i > 0; i--) {
				if(elements[i] > leader) {
					leader = elements[i];
					System.out.println(leader);
				}
			}
		}
	}
}
