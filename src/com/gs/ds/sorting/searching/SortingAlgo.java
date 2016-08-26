package com.gs.ds.sorting.searching;

/**
 * 
 * @author govinda.verma
 *
 */
public class SortingAlgo {
	/**
	 * 
	 * @param a
	 * @return
	 */
	public int[] selectionSortRec(int[] a) {

		return selectionSortRec(-1, a, 0, a.length - 1);

	}

	private int[] selectionSortRec(int si, int[] a, int s, int e) {
		if (s == e) {
			return a;
		}
		int i = findMinElement(a, s, e);
		int t = a[++si];
		a[si] = a[i];
		a[i] = t;

		return selectionSortRec(si, a, s + 1, e);
	}

	/**
	 * 
	 * @param a
	 * @param s
	 * @param e
	 * @return
	 */
	private int findMinElement(int[] a, int s, int e) {
		int min = s;

		for (int i = s; i <= e; i++) {
			if (a[i] <= a[min]) {
				min = i;
			}
		}
		return min;
	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	public int[] selectionSortIterative(int[] a) {
		int si = -1;
		int l = a.length - 1;

		for (int i = 0; i <= l; i++) {
			int mi = findMinElement(a, i, l);
			int t = a[++si];
			a[si] = a[mi];
			a[mi] = t;
		}

		return a;

	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	public int[] bubbleSortIterative(int[] a) {
		for (int i = 0; i <= a.length - 1; i++) {
			for (int j = 0; j <= a.length - 2 - i; j++) {
				if (a[j] > a[j + 1]) {
					int t = a[j + 1];
					a[j + 1] = a[j];
					a[j] = t;
				}
			}
		}

		return a;
	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	public int[] bubbleSortRec(int[] a) {
		return bubbleSortRec(a, 0, a.length - 1);
	}

	/**
	 * 
	 * @param a
	 * @param s
	 * @param e
	 * @return
	 */
	private int[] bubbleSortRec(int[] a, int s, int e) {
		if (s == e) {
			return a;
		}
		a = moveMaxElementToEnd(a, 0, e - s - 1);
		return bubbleSortRec(a, s + 1, e);
	}

	/**
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	private int[] moveMaxElementToEnd(int[] a, int s, int e) {
		if (s == e) {
			return a;
		}

		if (a[s] > a[s + 1]) {
			int t = a[s + 1];
			a[s + 1] = a[s];
			a[s] = t;
		}

		return moveMaxElementToEnd(a, s + 1, e);

	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	public int[] insertionSortIterative(int a[]) {
		int sai = 0;
		for (int i = 1; i <= a.length - 1; i++) {
			int t = a[i];
			int fi = findIndex(sai, a, a[i]);
			shiftAllByOne(fi, ++sai, a);
			a[fi] = t;
		}

		return a;
	}

	/**
	 * 
	 * @param s
	 * @param e
	 * @param a
	 */
	private void shiftAllByOne(int s, int e, int[] a) {
		for (int i = e; i > s; i--) {
			a[i] = a[i - 1];
		}

	}

	/**
	 * 
	 * @param sai
	 * @param a
	 * @param k
	 * @return
	 */
	private int findIndex(int sai, int[] a, int k) {
		for (int i = 0; i <= sai; i++) {
			if (a[i] > k) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	public void mergeSortRec(int a[]) {
		mergerSortRec(a, 0, a.length - 1);
	}

	private void mergerSortRec(int[] a, int s, int e) {

		if (s > e) {
			return;
		}

		int m = (s + e) / 2;

		mergerSortRec(a, s, m);
		mergerSortRec(a, m + 1, e);
		mergerRec(a, s, m, e);
	}

	private void mergerRec(int[] a, int s, int m, int e) {
		int l1 = s - m + 1;
		int l2 = e - m;
		int k = 0, l = 0;
		;

		int a1[] = new int[l1];
		int a2[] = new int[l2];

		/**
		 * Copying
		 */
		for (int i = s; i <= m; i++) {
			a1[k++] = a[i];
		}

		for (int i = m + 1; i <= e; i++) {
			a2[l++] = a[i];
		}

		k = 0;
		
		l = 0;
		while (k <= l1 && l <= l2) {
			if (a1[k] == a2[l]) {

			}
		}

	}

	public void redixSort(int[] a) {
		int m = max(a);

		for (int i = 1; (m / i) > 0; i *= 10) {
			redixSort(a, i);
		}
	}

	private void redixSort(int[] a, int i) {
		int[] t = new int[10];

		for (int j = 0; j < a.length; j++) {
			t[(a[j] / i) % 10]++;
		}

		for (int j = 1; j < t.length; j++) {
			t[j] += t[j - 1];
		}

		int[] f = new int[a.length];

		for (int j = a.length - 1; j >= 0; j--) {
			f[t[(a[j] / i) % 10] - 1] = a[j];
			t[(a[j] / i) % 10]--;
		}

		for (int j = 0; j < f.length; j++) {
			a[j] = f[j];
		}

	}

	private int max(int[] a) {
		int m = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > m)
				m = a[i];
		}
		return m;
	}

	/**
	 * 
	 * @param a
	 */
	public void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	private  void heapSort(int arr[]) {
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

	private  void heapify(int arr[], int n, int i) {
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
