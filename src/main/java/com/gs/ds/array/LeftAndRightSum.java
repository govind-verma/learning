package com.gs.ds.array;

public class LeftAndRightSum {
	public static void main(String[] args) {
		int arr1[] = {1, 3, 4, 5};
		System.out.println(findSmallest(arr1, arr1.length));
	}

	private static boolean divideArray(int a[]) {
		int l = 0;
		int r = a.length - 1;

		int leftSum = 0;
		int rightSum = 0;

		while (r >= l) {
			if (leftSum + a[l]  > rightSum + a[r]) {
				rightSum += a[r--];
			} else if (leftSum + a[l] < rightSum + a[r]) {
				leftSum += a[l++];
			} else if (leftSum + a[l] == rightSum + a[r]) {
				if (l +1 == r -1) {
					return true;
				}
				l++;
				r--;
			}
		}

		if (leftSum == 0 || rightSum == 0) {
			return true;
		}

		return false;
	}
	
	static int  findSmallest(int arr[], int n)
	{	
		//int arr1[] = {1,2, 3, 4};
	   int res = 1; // Initialize result
	 
	   // Traverse the array and increment 'res' if arr[i] is
	   // smaller than or equal to 'res'.
	   for (int i = 0; i < n && arr[i] <= res; i++)
	       res = res + arr[i];
	 
	   return res;
	}
}
