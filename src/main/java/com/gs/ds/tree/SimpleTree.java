package com.gs.ds.tree;

/**
 * 
 * @author govinda.verma
 *
 */
public class SimpleTree {
	private TreeNode root;
	
	private class TreeNode {
		private int a;
		private int b;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int a, int b, TreeNode leftNode, TreeNode rightNode){
			this.a = a;
			this.b = b;
			this.left = leftNode;
			this.right = rightNode;
		}
	}
	
	public boolean isPossible(TreeNode node, int a, int b, int c, int d){
		
		TreeNode lNode = null;
		TreeNode rNode = null;
		
		int la = a + b;
		int lb = b;
		
		int ra = a;
		int rb = a + b;
		
		
		if((la == c && lb == d) || (ra == c  && rb == d)) {
			return true;
		}
		
		if(c >= la && d >= lb) {
			lNode = new TreeNode(la, lb, null, null);
		} 
		
		if(c >= ra && d >= rb) {
			rNode = new TreeNode(la, lb, null, null);
		}
		
		if(root == null) {
			root = new TreeNode(a, b, lNode, rNode);
		} else {
			node.left = lNode;
			node.right = rNode;
		}
		
		boolean result = false;
		
		if(lNode != null) {
			result = isPossible(lNode, la, lb, c, d);
		}
		if(rNode != null && !result) {
			result = isPossible(rNode, ra, rb, c, d);
		}
		return result;
	}
}
