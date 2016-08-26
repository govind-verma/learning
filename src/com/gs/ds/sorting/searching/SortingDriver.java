package com.gs.ds.sorting.searching;

/**
 * 
 * @author govinda.verma
 *
 */
public class SortingDriver {
	public static void main(String[] args) {
		int a[] = {170, 45, 75, 90, 802, 24, 2, 66};
		SortingAlgo sort = new SortingAlgo();
		sort.redixSort(a);
		sort.print(a);
	}
}
