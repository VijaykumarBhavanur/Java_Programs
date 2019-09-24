package com.bridgelabz.TestingPrograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* Node for singly linked list */

class SLLNode

{

	SLLNode next;

	int data;

	/* Constructor */

	public SLLNode(int x)

	{

		data = x;

		next = null;

	}

}

/* Class HashTableChainingSinglyLinkedList */

class HashTableChainingSinglyLinkedList

{

	private SLLNode[] table;

	private int size;

	/* Constructor */

	public HashTableChainingSinglyLinkedList(int tableSize)

	{

		table = new SLLNode[nextPrime(tableSize)];

		size = 0;

	}

	/* Function to check if hash table is empty */

	public boolean isEmpty()

	{

		return size == 0;

	}

	/* Function to clear hash table */

	public void makeEmpty()

	{

		int l = table.length;

		table = new SLLNode[l];

		size = 0;

	}

	/* Function to get size */

	public int getSize()

	{

		return size;

	}

	/* Function to insert an element */

	public void insert(int val)
	{

		size++;

		//int pos = myhash(val);
		int pos=val%11;
		
		SLLNode nptr = new SLLNode(val);

		if (table[pos] == null)

			table[pos] = nptr;

		else

		{

			nptr.next = table[pos];

			table[pos] = nptr;

		}

	}

	/* Function to remove an element */

	public int remove(int val)
	{

		int pos = myhash(val);
		SLLNode start = table[pos];

		SLLNode end = start;

		if (start.data == val)
		{
			size--;

			table[pos] = start.next;

			return 1;

		}

		while (end.next != null && end.next.data != val)

			end = end.next;

		if (end.next == null)

		{

			System.out.println("\nElement not found\n");

			return 0;

		}

		size--;

		if (end.next.next == null)
		{

			end.next = null;

			return 1;

		}

		end.next = end.next.next;

		table[pos] = start;
		return 0;
	}

	/* Function myhash */

	private int myhash(Integer x)
	{

		return x%11;
		/*
		 * int hashVal = 0; //x.hashCode();
		 * 
		 * hashVal = hashVal%table.length;
		 * 
		 * if (hashVal < 0)
		 * 
		 * hashVal += table.length;
		 * 
		 * 
		 * return hashVal;
		 * 
		 */
	}

	/* Function to generate next prime number >= n */

	private static int nextPrime(int n)

	{

		if (n % 2 == 0)

			n++;

		for (; !isPrime(n); n += 2)
			;

		return n;

	}

	/* Function to check if given number is prime */

	private static boolean isPrime(int n)

	{

		if (n == 2 || n == 3)

			return true;

		if (n == 1 || n % 2 == 0)

			return false;

		for (int i = 3; i * i <= n; i += 2)

			if (n % i == 0)

				return false;

		return true;

	}

	public void printHashTable()

	{

		System.out.println();

		for (int i = 0; i < table.length; i++)

		{

			System.out.print("Bucket " + i + ":  ");

			SLLNode start = table[i];

			while (start != null)

			{

				System.out.print(start.data + " ");

				start = start.next;

			}

			System.out.println();

		}

	}

}

/* Class HashTableChainingSinglyLinkedListTest */

public class HashTableChainingSinglyLinkedListTest
{
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("Hash Table Test\n\n");

		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size");
		  
		HashTableChainingSinglyLinkedList htcsll = new
		HashTableChainingSinglyLinkedList(sc.nextInt() );
		  
		
		Scanner scanner = new Scanner(new File("/home/admin1/Desktop/number.txt"));

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		scanner.useDelimiter(",");

		while (scanner.hasNext())
		{
			String s=scanner.next().trim();
			numbers.add(Integer.parseInt(s.replaceAll("\\uFEFF", "")));
		}

		System.out.println(numbers);
		
		
		for (int i = 0; i <numbers.size(); i++)
		{
			 htcsll.insert(numbers.get(i));
		}
		 
		htcsll.printHashTable();
		
		System.out.println("Enter the number to search: ");
		int n=sc.nextInt();
		
		if(htcsll.remove(n)==0)
			htcsll.insert(n);
		
		System.out.println("\n\n");
		htcsll.printHashTable();
		
		
		
		
		
		
		
		
		
		
		
		
		
		  
		  

		/*
		 * 
		 * char ch;
		 * 
		 * 
		 * do
		 * 
		 * {
		 * 
		 * System.out.println("\nHash Table Operations\n");
		 * 
		 * System.out.println("1. insert ");
		 * 
		 * System.out.println("2. remove");
		 * 
		 * System.out.println("3. clear");
		 * 
		 * System.out.println("4. size");
		 * 
		 * System.out.println("5. check empty");
		 * 
		 * 
		 * 
		 * int choice = sc.nextInt();
		 * 
		 * switch (choice)
		 * 
		 * {
		 * 
		 * case 1 :
		 * 
		 * System.out.println("Enter integer element to insert");
		 * 
		 * htcsll.insert( sc.nextInt() );
		 * 
		 * break;
		 * 
		 * case 2 :
		 * 
		 * System.out.println("Enter integer element to delete");
		 * 
		 * htcsll.remove( sc.nextInt() );
		 * 
		 * break;
		 * 
		 * case 3 :
		 * 
		 * htcsll.makeEmpty();
		 * 
		 * System.out.println("Hash Table Cleared\n");
		 * 
		 * break;
		 * 
		 * case 4 :
		 * 
		 * System.out.println("Size = "+ htcsll.getSize() );
		 * 
		 * break;
		 * 
		 * case 5 :
		 * 
		 * System.out.println("Empty status = "+ htcsll.isEmpty() );
		 * 
		 * break;
		 * 
		 * default :
		 * 
		 * System.out.println("Wrong Entry \n ");
		 * 
		 * break;
		 * 
		 * }
		 * 
		 * 
		 * htcsll.printHashTable();
		 * 
		 * 
		 * 
		 * System.out.println("\nDo you want to continue (Type y or n) \n");
		 * 
		 * ch = sc.next().charAt(0);
		 * 
		 * } while (ch == 'Y'|| ch == 'y');
		 */

	}

}