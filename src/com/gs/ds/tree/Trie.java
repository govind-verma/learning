package com.gs.ds.tree;

/**
 * 
 * @author govinda.verma
 *
 */
public class Trie {
	private TrieNode root = new TrieNode(false);;

	@SuppressWarnings("unused")
	private class TrieNode {

		private TrieNode[] children = new TrieNode[26];
		private boolean isLeaf;

		public TrieNode(boolean isLeaf) {
			this.isLeaf = isLeaf;
		}

		public boolean isLeaf() {
			return isLeaf;
		}

		public void setLeaf(boolean isLeaf) {
			this.isLeaf = isLeaf;
		}

		public TrieNode[] getChildren() {
			return children;
		}

		public void setChildren(TrieNode[] children) {
			this.children = children;
		}
	}

	/**
	 * 
	 * @param key
	 */
	public void addTrieNode(String key) {
		if (key != null && !key.isEmpty()) {
			int len = key.length();
			TrieNode node = root;

			for (int level = 0; level < len; level++) {
				int index = key.charAt(level) - 'a';

				if (node == null) {
					node = new TrieNode(false);
				} else if (node.getChildren()[index] == null) {

					node.getChildren()[index] = new TrieNode(false);
				}
				if(level  == len - 1) {
					node.setLeaf(true);
				}
				node = node.getChildren()[index];
			}

		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean search(String key) {
		if (key != null && !key.isEmpty()) {
			int len = key.length();
			TrieNode node = root;
			if (root != null) {
				for (int level = 0; level < len; level++) {
					int index = key.charAt(level) - 'a';
					if ((node.getChildren()[index]) == null) {
						return false;
					}
					if(level == len - 1 && !node.isLeaf()) {
						return false;
					}
					node = node.getChildren()[index];
				}
				return true;
			}
		}
		return false;
	}
}
