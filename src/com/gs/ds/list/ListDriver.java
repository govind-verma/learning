package com.gs.ds.list;

import java.util.ArrayList;
import java.util.List;

import com.gs.ds.list.CustomLinkedList.Node;

/**
 * 
 * @author govinda.verma
 *
 */
public class ListDriver {
	public static void main(String[] args) {
		CustomLinkedList<Integer> list = new CustomLinkedList<>(100);
		//list.add("1");
		//list.add("2");
		//list.add("3");
		//list.add("4");
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(new Integer(1));
		list1.add(new Integer(4));
		list1.add(new Integer(6));
		//list1.add("2");
		
		//System.out.println(list.createLoop(list1));
		//System.out.println(list.detectLoopWithFloyedCycle(list.createLoop(list1)).getData());
		
		//list.print();
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(new Integer(2));
		list2.add(new Integer(5));
		list2.add(new Integer(7));
		Node h1 = list.createSortedList(list1);
		//list.print(h1);
		
		Node h2 = list.createSortedList(list2);
		
		//list.print(h2);
		list.print(list.mergeSortedList(h1, h2));
		
		
	}
}
