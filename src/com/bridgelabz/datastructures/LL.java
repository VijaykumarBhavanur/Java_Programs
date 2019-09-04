package com.bridgelabz.datastructures;

import java.util.LinkedList;
import java.util.Scanner;

public class LL {
	class Node {
		Object data;
		Node next;

		public Node(Object data) {
			this.data = data;
		}
	}

	Node head;

	boolean add(Object obj) {

		Node n = new Node(obj);

		if (head == null) {
			head = n;
			return true;
		}

		Node t = head;

		while (t.next != null) {

			t = t.next;

		}
		t.next = n;
		return true;

	}

	boolean addFirst(Object obj) {
		Node temp = head;
		Node newNode = new Node(obj);

		if (head != null) {
			newNode.next = temp;
			head = newNode;
			return true;
		}

		head = newNode;
		return true;
	}

	boolean addLast(Object obj) {
		Node newNode = new Node(obj);
		Node t = head;

		while (t.next != null) {
			t = t.next;
		}

		t.next = newNode;
		return true;
	}

	void display(LL l) {
		Node t = head;
		if (head == null) {
			System.out.println("No elements to display");
			return;
		}
		while (t != null) {
			if (t.next != null)
				System.out.print(t.data + "-->");
			else
				System.out.print(t.data);

			t = t.next;
		}
	}

	boolean addAtIndex(Object obj, int index) {
		Node temp = head;
		Node newNode = new Node(obj);
		int i = 0;

		while (i < index) {
			temp = temp.next;
			i++;
		}

		Node t = temp.next;
		temp.next = newNode;
		newNode.next = t;

		return true;

	}

	int search(LL ll, String word) {
		Node t = head;
		int i = 0;

		while (t != null) {
			if (t.data.toString().equalsIgnoreCase(word))
				return i;
			t = t.next;
			i++;
		}

		return -1;
	}

	void deleteLast(LL link) {

		Node t = head;

		while (t.next.next != null) {
			t = t.next;
		}

		t.next = null;
	}

	void deleteFirst(LL link) {
		Node t = head.next;
		head = t;
	}

	void deleteData(LL link, String data) {
		Node t = head;
		Node move = t.next;

		if (t.data.toString().equalsIgnoreCase(data) && t.next != null) {
			head = t.next;

			return;
		} else if (t.data.toString().equalsIgnoreCase(data) && t.next == null) {
			head = null;
			return;
		}

		while (move != null) {
			if (t.next.data.toString().equalsIgnoreCase(data)) {
				t.next = move.next;
				return;
			}
			t = t.next;
			move = move.next;
		}
	}

	public static void main(String[] args) 
	{
		LL link = new LL();
		link.add(1);
		link.add(2);
		link.add(3);
		link.add(4);
		link.add(5);
		link.add(6);
		link.add(7);
		link.add(8);
		link.add(9);
		link.add(10);

		link.display(link);
		System.out.println();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter data to be found: ");
		String data=scanner.next();
		
		int search=link.search(link, data);
		
		if(search!=-1)
		{
			link.deleteData(link, data);
			System.out.println("data found @ index: "+search);
			System.out.println("After deleting: "+data);
			link.display(link);
			System.out.println();
		}
		else
		{
			
		link.addLast(data);	
		System.out.println(data+" not found in list ");
		System.out.println("After adding: "+data);
		link.display(link);
		System.out.println();
			
		}
		
		/*
		 * link.deleteLast(link); System.out.println("After deleting @ last: ");
		 * link.display(link); System.out.println(); link.deleteFirst(link);
		 * 
		 * System.out.println("After deleting @ first: "); link.display(link);
		 * System.out.println();
		 * 
		 * Scanner scanner=new Scanner(System.in); while(true) {
		 * System.out.println("Enter data to be deleted: "); String data=scanner.next();
		 * link.deleteData(link,data);
		 * 
		 * System.out.println("After deleting "+data); link.display(link);
		 * 
		 * System.out.println();
		 * 
		 * if(link.head==null) break; }
		 * 
		 * 
		 * Scanner scanner=new Scanner(System.in);
		 * System.out.println("Enter number of words: "); int n=scanner.nextInt();
		 * 
		 * for (int i = 0; i <n; i++) { System.out.println("Enter word: "); String
		 * word=scanner.next(); link.add(word); }
		 * 
		 * link.display(link); System.out.println();
		 * System.out.println("Enter word you want to find: ");
		 * 
		 * String findWord=scanner.next();
		 * 
		 * int found=link.search(link,findWord);
		 * 
		 * 
		 * if(found==0) { link.add(findWord);
		 * System.out.println(findWord+" not found in list, after adding new word: ");
		 * link.display(link); System.out.println(); } else {
		 * System.out.println(findWord+" found at index: "+found); link.display(link);
		 * 
		 * System.out.println(); }
		 */
	}

}
