package com.gs.ds.matrix;

public class MatrixRotation {
	private static int ROW = 5;
	private static int COLUMN = 5;

	public static void main(String[] args) {
		int mat[][] = new int[ROW][COLUMN];
		/**
		 * Prepare matrix
		 */
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				mat[i][j] = i + j;
			}
		}

		/**
		 * Before rotation a matrix
		 */
		printMat(mat);
		System.out.println();
		/**
		 * After rotate matrix
		 */
		rotate(mat);
		System.out.println();
		printMat(mat);
	}

	private static int[][] rotate(int[][] mat) {
		int r = ROW;
		int c = COLUMN;
		int rm = 0;
		int cm = 0;

		int loop = ROW/2 - 1;
	
		while (loop >= 0) {
			int prev = mat[rm][cm];

			for (int i = rm + 1; i < c - rm; i++) {
				int cur = mat[rm][i];
				mat[rm][i] = prev;
				prev = cur;
			}
			for (int i = rm + 1; i < r - rm; i++) {
				int cur = mat[i][c - cm - 1];
				mat[i][c - cm - 1] = prev;
				prev = cur;
			}
			for (int i = c - rm - 2; i >= rm; i--) {
				int cur = mat[r - rm - 1][i];
				mat[r - rm - 1][i] = prev;
				prev = cur;
			}
			for (int i = r - rm - 2; i >= rm; i--) {
				int cur = mat[i][rm];
				mat[i][rm] = prev;
				prev = cur;
			}
			rm++;
			cm++;
			loop--;
		}
		System.out.println();
		return mat;
	}

	private static void printMat(int mat[][]) {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
