package com.gs.ds.array;

public class LeftAndRightSum {
	public static void main(String[] args) {
		int arr[] = {6, -2, 3, 2, 3};
		System.out.println(divideArray(arr));
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
}
