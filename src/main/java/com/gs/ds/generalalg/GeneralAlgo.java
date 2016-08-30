package com.gs.ds.generalalg;

/**
 * 
 * @author govinda.verma
 *
 */
public class GeneralAlgo {
	
	public void printPowerSet(int[] a) {
		int size = a.length;
		int powSetSize = (int) Math.pow(2, size);
		
		for(int i = 0; i < powSetSize; i++) {
			for(int j = 0; j < size; j++){
				if((i & (1 << j)) > 0){
					System.out.print(a[j]);
				}
			}
			
			System.out.println();
		}
	}
}
