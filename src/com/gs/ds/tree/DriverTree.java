package com.gs.ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author govinda.verma
 *
 */
public class DriverTree {
	public static void main(String[] args) {
		/*int a = 1;
		int b = 4;
		int c = 5;
		int d = 9;
		System.out.println(isPossible(a, b, c, d));
		*/
		List<Integer> i = new ArrayList<>();
		i.add(1);
		i.add(2);
		i.add(3);
		i.add(4);
		i.add(5);
		BinaryTree<Integer> b = new BinaryTree<>();
		b.createTree(i);
		b.inorder();
	}
	
	static boolean isPossible(int a,int b,int c, int d){
		SimpleTree s = new SimpleTree();
		
		return s.isPossible(null, a, b, c, d);
	}
}
