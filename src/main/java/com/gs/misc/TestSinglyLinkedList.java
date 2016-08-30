package com.gs.misc;

class TestArrayLisT<T> {
	private int size;
	private TestNode<T> head;
	private int capicity;

	public TestArrayLisT() {
		this.capicity = Integer.MAX_VALUE;
	}

	public TestArrayLisT(int capicity) {
		this.capicity = capicity;
	}

	class TestNode<T> {
		private T data;
		private TestNode<T> next;

		public TestNode(T data, TestNode<T> next) {
			super();
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * 
	 * @param data
	 */
	public void add(T data) {
		if (size == capicity) {
			throw new RuntimeException("Array List Exchuted..");
		}
		TestNode<T> node = new TestNode<>(data, null);
		if (head == null) {
			head = node;
		} else {
			TestNode<T> tempNode = head;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}

			tempNode.next = node;
		}
		size++;
	}

	public boolean remove(T data) {
		if (size == 0) {
			throw new IllegalArgumentException("ArrayList is empty");
		}

		TestNode<T> tempNode = head;
		TestNode<T> previousNode = head;
		while (tempNode != null) {
			if ((data == null && data == tempNode.data) || (data.equals(tempNode.data))) {
				break;
			}
			previousNode = tempNode;
			tempNode = tempNode.next;
		}
		if (tempNode != null) {
			if (tempNode == head) {
				head = tempNode.next;
				tempNode.next = null;
			} else {
				if (tempNode.next != null) {
					previousNode.next = tempNode.next;
					tempNode.next = null;
				} else {
					previousNode.next = null;
				}
			}
			size--;
			return true;
		}
		return false;
	}
	/**
	 * Size of 
	 * @return
	 */
	public int size(){
		return this.size;
	}
}

public class TestSinglyLinkedList {
	public static void main(String[] args) {
		TestArrayLisT<String> list = new TestArrayLisT<>();
		list.add("Test");
	}

}
