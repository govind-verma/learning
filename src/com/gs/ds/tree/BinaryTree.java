package com.gs.ds.tree;

import java.util.List;

/**
 * 
 * @author govinda.verma
 *
 * @param <T>
 */
public class BinaryTree<T> {
	private Node root;
	
	private class Node {
		private T data;
		private Node left;
		private Node right;
		
		public Node(T data, Node left, Node right) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}
	
	/**
	 * 
	 * @param data
	 */
	public void createTree(List<T> data){
		Node l2 = new Node(data.get(3), null, null);
		Node r2 = new Node(data.get(4), null, null);
		Node l1 = new Node(data.get(1), l2, r2);
		Node r1 = new Node(data.get(2), null, null);
		
		root = new Node(data.get(0), l1, r1);
	}
	
	public void inorder(){
		inorder(root);
	}
	
	/**
	 * 
	 * @param root
	 */
	private void inorder(Node root){
		if(root != null && root.left == null && root.right == null){
			System.out.print(root.data);
			return;
		}
		
		if(root.left != null) {
			inorder(root.left);
		}
		System.out.print(root.data);
		
		if(root.right != null) {
			inorder(root.right);
		}
	}
}
