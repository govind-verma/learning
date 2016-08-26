package com.gs.misc;

public class SortByFrequency {
	public static void main(String[] args) {
		int elements[] = new int[] { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
		int indices[] = new int[elements.length];
		sortAndFillIndices(elements, indices);
		int indexWithFrequency[][] = construct2DArrya(elements, indices);
		sortAndPrint(indexWithFrequency);
	}

	private static void sortAndPrint(int[][] indexWithFrequency) {
		// TODO Auto-generated method stub

	}

	private static int[][] construct2DArrya(int[] elements, int[] indices) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void sortAndFillIndices(int[] elements, int[] indices) {
		if (elements != null && elements.length > 0 && indices != null && indices.length > 0 && indices.length == elements.length) {
			for(int i = 0; i< elements.length; i++) {
				for(int j = i; j < elements.length; j ++) {
				}
			}
		
		}

	}
}
