package com.gs.ds.sorting.searching;

/**
 * 
 * @author govinda.verma
 *
 */
public class SearchingDriver {
	public static void main(String[] args) {
	 int a[] = new int[] {2,3,5,6,7,8};
	 SearchingAlgo s = new SearchingAlgo();
	 
	 System.out.println(s.binarySearchIterative(a, 2));
	}
}
