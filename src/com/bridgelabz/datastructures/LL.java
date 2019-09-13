package com.bridgelabz.datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.bridgelabz.datastructures.OLL.Node;

public class LL<T>
{
	
	/* Custom class to create node in linked list*/
	class Node
	{
		Object data;
		Node next;

		public Node(Object data)
		{
			this.data = data;
		}
	}

	 Node head;

	/* Method to add new-node to Linked List*/
	boolean add(String obj) 
	{

		Node n = new Node(obj); ////Creating new-node with given data

		if (head == null)  //Nod nodes in linked-list
		{ 
			head = n;    //adding new-node 
			return true;
		}

		Node t = head;

		while (t.next != null) 
		{

			t = t.next; //Traversing linked-list till end

		}
		t.next = n; //adding new-node 
		return true;

	}

	/* Method to add new-node at the beginning of Linked List*/
	boolean addFirst(Object obj)
	{
		Node temp = head;
		Node newNode = new Node(obj); //Creating new-node with given data

		if (head != null) 
		{
			newNode.next = temp;
			head = newNode;
			return true;
		}

		head = newNode;
		return true;
	}
	/* Method to add new-node at the end of Linked List*/
	boolean addLast(Object obj)
	{
		Node newNode = new Node(obj);   //Creating new-node with given data
		Node t = head;

		while (t.next != null) 
		{
			t = t.next;
		}

		t.next = newNode;
		return true;
	}
/*Method to display data of linked-list*/
	void display(LL<String>  l) 
	{
		Node t = head;
		if (head == null) 
		{
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
	/* Method to  new-node at specific of Linked List*/
	boolean addAtIndex(Object obj, int index) 
	{
		Node temp = head;
		Node newNode = new Node(obj);
		int i = 0;

		while (i < index) 
		{
			temp = temp.next;
			i++;
		}

		Node t = temp.next;
		temp.next = newNode;
		newNode.next = t;

		return true;
	}
	
/*Method to find word in linked-list*/
	int search(LL<String>  ll, String word)
	{
		Node t = head;
		int i = 0;

		while (t != null) 
		{
			if (t.data.toString().equalsIgnoreCase(word))  //Comparing search word with node data
				return i;  //returning index of search word
			t = t.next;
			i++;
		}

		return -1;  //If  word not found
	}

	/*Method to remove node from at the linked list */
	void deleteLast(LL<String>  link) 
	{

		Node t = head;

		while (t.next.next != null) 
		{
			t = t.next;
		}

		t.next = null;
	}

	/* Method to remove first node of linked-list*/
	void deleteFirst(LL<String>  link)
	{
		Node t = head.next;
		head = t;
	}

	/*Method to remove node with specific data*/
	void deleteData(LL<String>  link, String data) 
	{
		Node t = head;
		Node move = t.next;

		if (t.data.toString().equalsIgnoreCase(data) && t.next != null) 
		{
			head = t.next; //delete first node if search data found in first node

			return;
		} 
		else if (t.data.toString().equalsIgnoreCase(data) && t.next == null)
		{
			head = null;  //delete first node if search data found in first node and only one node exist in linked-list
			return;
		}

		while (move != null) 
		{
			if (t.next.data.toString().equalsIgnoreCase(data)) 
			{
				t.next = move.next;  //Traversing linked-list and comparing node with search data
				return;
			}
			t = t.next;
			move = move.next;
		}
	}

	/*Method to add words to file*/
	 void writeListToFile(FileWriter file,LL<String>  link) throws IOException
	{
		if(head==null)
		{
			System.out.println("No content to write in file");
			return;
		}
		Node t=head;
		while(t!=null)
		{
			if(t.next!=null)
				file.write(String.valueOf(t.data)+" ");
			else
				file.write(String.valueOf(t.data));
			
			t=t.next;
		}
		file.close();
	}
	
	
	public static void main(String[] args) throws IOException   
	{
		LL<String> link= new LL<String>();

		Scanner scanner = new Scanner( new File("/home/admin1/Desktop/file.txt") );
		
		ArrayList<String> numbers=new ArrayList<String>();
		scanner.useDelimiter(" ");
		
		while(scanner.hasNext())
		{
			String item=scanner.next().trim(); //Reading file and adding content to arrayList
			numbers.add(item);
		}
		
		for (int i = 0; i < numbers.size(); i++)
		{
			link.add(numbers.get(i)); //adding array-list data to linked-list
		}
		
		System.out.println("After adding to link list: ");
		
		Scanner sc1=new Scanner(System.in);
		link.display(link);   //displaying linked-list data
		System.out.println();

		System.out.println("Enter data to be found: ");
		
		String data = sc1.next();

		int search = link.search(link, data);

		/*Data found so removing it from linked-list*/
		if (search != -1) 
		{
			link.deleteData(link, data);
			System.out.println(data+"found @ index: " + search);
			System.out.println("After deleting: " + data);
			link.display(link);
			System.out.println();
		} 
		/*Data not found so adding it to linked-list*/
		else 
		{
			link.addLast(data);
			System.out.println(data + " not found in list ");
			System.out.println("After adding: " + data);
			link.display(link);
			System.out.println();

		}
		
		  FileWriter fw=new FileWriter("/home/admin1/Desktop/String.txt");  
		   //Writing words to file
		   link.writeListToFile(fw, link);
		   
	}
	
}


