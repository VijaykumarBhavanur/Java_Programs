package com.bridgelabz.datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

	boolean add(String obj) {

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
		while (t != null) 
		{
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

	public static void main(String[] args) throws FileNotFoundException 
	{
		LL link = new LL();

		Scanner scanner = new Scanner( new File("/home/admin1/Desktop/file.txt") );
		
		ArrayList<String> numbers=new ArrayList<String>();
		scanner.useDelimiter(" ");
		
		while(scanner.hasNext())
		{
			String item=scanner.next().trim();
			numbers.add(item);
		}
		
		for (int i = 0; i < numbers.size(); i++)
		{
			link.add(numbers.get(i));
		}
		
		System.out.println("After adding to link list: ");
		
		Scanner sc1=new Scanner(System.in);
		link.display(link);
		System.out.println();

		System.out.println("Enter data to be found: ");
		
		
		String data = sc1.next();

		int search = link.search(link, data);

		if (search != -1) {
			link.deleteData(link, data);
			System.out.println(data+"found @ index: " + search);
			System.out.println("After deleting: " + data);
			link.display(link);
			System.out.println();
		} else {

			link.addLast(data);
			System.out.println(data + " not found in list ");
			System.out.println("After adding: " + data);
			link.display(link);
			System.out.println();

		}
	}
}


