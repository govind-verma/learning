package com.gs.ds.string;

import java.io.IOException;

public class LCS {
	public static void main(String[] args) throws IOException {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		System.out.println(lcs(str1, str2, str1.length(), str2.length()));
	}

	private static int lcs(String str1, String str2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			return 1 + lcs(str1, str2, m - 1, n - 1);
		}
		return max(lcs(str1, str2, m - 1, n), lcs(str1, str2, m, n - 1));
	}

	private static int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}

}
