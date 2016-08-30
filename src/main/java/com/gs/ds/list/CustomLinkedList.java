package com.gs.ds.list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author govinda.verma
 *
 * @param <T>
 */
public class CustomLinkedList<T extends Comparable<T>> {
	private Node head;
	private int size;
	private int CAPACITY = 10;

	public CustomLinkedList(int capacity) {
		this.CAPACITY = capacity;
	}

	class Node {
		private Node next;
		private T data;

		public Node(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public boolean add(T data) {
		if (size == CAPACITY) {
			throw new IllegalStateException("Capicity excede...");
		}

		size++;

		Node node = new Node(data);
		if (head == null) {
			head = node;
			return true;
		}
		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;

		return true;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public boolean delete(T data) {
		if (size == 0) {
			throw new IllegalStateException("Empty list...");
		}

		Node node = head;

		if (node.data.equals(data)) {
			size--;
			head = head.next;

			return true;
		}
		/**
		 * 1->2->3
		 */
		while (node != null) {
			if (node.next != null && node.next.data.equals(data)) {
				node.next = node.next.next;
				size--;

				return true;
			}
			node = node.next;
		}
		return false;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		if (!isValidRequestOperation(index)) {
			throw new IllegalStateException("Invalid Index...");
		}

		int counter = 0;
		Node node = head;

		while (node != null) {
			if (counter == index) {
				return node.data;
			}
			node = node.next;
			counter++;
		}

		return null;
	}

	public boolean delete(int index) {
		if (!isValidRequestOperation(index)) {
			throw new IllegalStateException("Invalid Index...");
		}

		Node node = head;

		int counter = 0;
		if (index == 0) {
			head = head.next;
			size--;
			return true;
		}

		/**
		 * 0->1->2->3->4
		 */
		while (counter + 1 < index) {
			node = node.next;
			counter++;
		}
		node.next = node.next.next;
		size--;

		return true;
	}

	/**
	 * 
	 * @param data
	 * @param index
	 * @return
	 */
	public boolean delete(T data, int index) {
		if (!isValidRequestOperation(index)) {
			return false;
		}

		int counter = 0;
		if (index == 0 && head.data.equals(data)) {
			head = head.next;
			size--;
			return true;
		}
		Node node = head;

		while (counter + 1 < index) {
			counter++;
			node = node.next;
		}
		if (node.next.data.equals(data)) {
			node.next = node.next.next;
			size--;
			return true;
		}

		return false;

	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	private boolean isValidRequestOperation(int index) {
		if (size == 0 || index > size || index < 0) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @return
	 */
	public int length() {
		return findSize(head);
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	private int findSize(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + findSize(node.next);
	}

	/**
	 * Swap to nodes in linked list
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public boolean swap(T source, T destination) {
		if (size == 0) {
			throw new IllegalStateException("Empty list");
		}
		Node sourcePrev = null;
		Node destinationPrev = null;
		Node node = head;
		boolean isSourceHead = false;

		while (node != null) {
			if (sourcePrev == null && node.data.equals(source)) {
				sourcePrev = node;
				isSourceHead = true;
			}
			if (sourcePrev == null && node.next != null && node.next.data.equals(source)) {
				sourcePrev = node;
			}
			if (destinationPrev == null && node.next != null && node.next.data.equals(destination)) {
				destinationPrev = node;
			}

			node = node.next;
		}

		if (sourcePrev == null) {
			throw new IllegalStateException("invalid source");
		}

		if (destinationPrev == null) {
			throw new IllegalStateException("invalid Destination");
		}

		Node sourceNode = null;

		/**
		 * set source node
		 */
		if (isSourceHead) {
			sourceNode = sourcePrev;
		} else {
			sourceNode = sourcePrev.next;
		}
		Node destinationNode = destinationPrev.next;

		Node sourceNodeNext = sourceNode.next;
		Node destinationNodeNext = destinationNode.next;

		/**
		 * Two case we need to handle if Source is head then we need to change head If Source and Destination nodes are consicutives
		 */
		if (sourceNode == head) {
			head = destinationNode;
		} else {
			sourcePrev.next = destinationNode;
		}
		if (destinationNode == sourceNodeNext) {
			destinationNode.next = sourceNode;
			sourceNode.next = destinationNodeNext;
		} else {
			destinationNode.next = sourceNodeNext;
			destinationPrev.next = sourceNode;
			sourceNode.next = destinationNodeNext;
		}
		return true;
	}

	/**
	 * Recursive version of reverse a linked list
	 * 
	 */
	public void reverseRec() {
		head = reverseRec(head, null);
	}

	/**
	 * Recursive version of reverse a linked list
	 * 
	 * @param node
	 */
	private Node reverseRec(Node node, Node reverseListHead) {
		Node nodeNext = null;
		if (node == null) {
			return reverseListHead;
		} else {
			nodeNext = node.next;
			node.next = reverseListHead;
			reverseListHead = node;
		}
		return reverseRec(nodeNext, reverseListHead);
	}

	public void reverse() {
		Node node = head;
		Node reverseList = null;
		Node nodeNext = null;

		while (node != null) {
			nodeNext = node.next;
			node.next = reverseList;
			reverseList = node;
			node = nodeNext;
		}

		head = reverseList;
	}

	/**
	 * 
	 * 1->2->3->4->2 Time complexity : o(n) Space complexity : o(n)
	 * 
	 * @return
	 */
	public Node detectLoop(Node node) {
		Set<Node> referenceSet = new HashSet<>();
		while (node != null) {
			if (findAndAddInLoop(referenceSet, node)) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	public Node detectLoopWithFloyedCycle(Node node) {
		Node slowPointer = node;
		Node fastPointer = node;
		if (node != null && node == node.next) {
			return node;
		}
		while (slowPointer != null && fastPointer != null && slowPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				return slowPointer;
			}
		}

		return null;
	}

	public Node createLoop(List<T> data) {
		Node a1 = new Node(data.get(0));
		Node a2 = new Node(data.get(1));
		Node a3 = new Node(data.get(2));
		Node a4 = new Node(data.get(3));

		a1.next = a1;
		a2.next = a3;
		a3.next = a4;
		a4.next = a2;

		return a1;

	}

	/**
	 * 
	 * @param data
	 * 
	 *            1->2->3->4
	 * @return
	 */
	public Node createSortedList(List<T> data) {
		Node node = null;
		Node lastNode = null;

		if (data != null) {
			for (T d : data) {
				if (node == null) {
					node = new Node(d);
					lastNode = node;
				} else {
					lastNode = lastNode.next = new Node(d);
				}

			}
		}
		lastNode.next = null;
		return node;
	}

	public Node mergeSortedList(Node list1, Node list2) {
		Node mergedList = null;
		Node lastNodeOfMergedList = null;

		if (list1 != null && list2 == null) {
			mergedList = list1;
		}

		if (list1 == null && list2 != null) {
			mergedList = list2;
		}

		if (list1 != null && list2 != null) {
			while (list1 != null && list2 != null) {
				if (list1.data.compareTo(list2.data) == 0) {
					if (lastNodeOfMergedList == null) {
						mergedList = list1;
						mergedList.next = null;
						lastNodeOfMergedList = mergedList;
						list1 = list1.next;
					} else {
						lastNodeOfMergedList.next = list1;
						Node list1Next = list1.next;
						list1.next = null;
						lastNodeOfMergedList = list1;

						list1 = list1Next;
					}

					list2 = list2.next;
				} else if (list1.data.compareTo(list2.data) < 0) {
					if (lastNodeOfMergedList == null) {
						mergedList = list1;
						mergedList.next = null;
						lastNodeOfMergedList = mergedList;
						list1 = list1.next;
					} else {
						lastNodeOfMergedList.next = list1;
						Node list1Next = list1.next;
						list1.next = null;
						lastNodeOfMergedList = list1;

						list1 = list1Next;
					}
				} else {
					if (lastNodeOfMergedList == null) {
						mergedList = list2;
						mergedList.next = null;
						lastNodeOfMergedList = mergedList;
						list2 = list2.next;
					} else {
						lastNodeOfMergedList.next = list2;
						Node list1Next = list2.next;
						list2.next = null;
						lastNodeOfMergedList = list2;

						list2 = list1Next;
					}
				}
			}
		}

		return mergedList;
	}

	private boolean findAndAddInLoop(Set<Node> referenceSet, Node key) {
		if (referenceSet.contains(key)) {
			return true;
		}
		referenceSet.add(key);
		return false;
	}

	/**
	 * 
	 */
	public void print() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
	}

	/**
	 * 
	 */
	public void print(Node node) {
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
	}
}
