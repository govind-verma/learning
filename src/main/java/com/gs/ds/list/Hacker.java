package com.gs.ds.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author govinda.verma
 *
 */
public class Hacker {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		String sizeStr = s.readLine();
		int size = Integer.valueOf(sizeStr);
		int a[] = new int[size];

		int i = 0;
		String str = null;
		String strK = null;
		while (i <= size) {
			str = s.readLine();
			if(i == size){
				strK = str;
			} else {
				a[i] = Integer.valueOf(str);
			}
			i++;
		}
		
		int k = Integer.valueOf(strK);

		System.out.println(numberOfPairs(a, k));

	}

	static int numberOfPairs(int[] a, long k) {
		sort(a);
		int l = 0;
		int r = a.length - 1;
		int count = 0;

		while (r > l) {
			if (a[r] + a[l] == k) {
				count++;
			} else if ((a[r] + a[l]) > k) {
				r--;
			} else {
				l++;
			}
		}
		return count;
	}

	private static void sort(int arr[]) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	private static void heapify(int arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}
}
