package com.gs.ds.sorting.searching;

/**
 * 
 * @author govinda.verma
 *
 */
public class SearchingAlgo {
	
	public int binarySearchRec(int a[], int k) {
		return binarySearchRec(0,  a.length - 1, a, k);
		
	}
	/**
	 * 
	 * @param l
	 * @param h
	 * @param a
	 * @param k
	 * @return
	 */
	private int binarySearchRec(int l, int h, int[] a, int k) {
		if(l > h) {
			return -1;
		}
		
		int mid = (l + h) / 2;
		if(a[mid] ==  k) {
			return mid;
		} else if(k > a[mid]) {
			return binarySearchRec(mid + 1,  h, a, k);
		} else {
			return binarySearchRec(l,  mid - 1, a, k);
		}
	}
	
	public int binarySearchIterative(int a[], int k){
		return binarySearchIterative(0,  a.length - 1, a, k);
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @param a
	 * @param k
	 * @return
	 */
	private int binarySearchIterative(int l, int h, int[] a, int k) {
		while(l <= h) {
			int mid = (l + h) / 2;
			if(a[mid] == k) {
				return mid;
			} else if(k > a[mid]) {
				l = mid + 1;
			}else {
				h = mid - 1;
			}
		}
		return -1;
	}
	
}
