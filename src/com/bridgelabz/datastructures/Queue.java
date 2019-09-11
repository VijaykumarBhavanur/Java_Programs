package com.bridgelabz.datastructures;

import java.util.ArrayList;
import java.util.Arrays;


public class Queue
{
	/* Custom class to create node in linked list*/
	class Node
	{
		Node next;
		Object data;
		
		public Node(Object data)
		{
			this.data=data;
		}
		
	}
	
	 Node head;
	 /* Method to add new-node at the end of Linked List*/
	 boolean addLast(Queue queue,Object num)
	{
		Node n=new Node(num); //creating new-node from data
		Node t=head;
		
		
		if(head==null)
		{
			head=n;
			System.out.println("EnQueued: "+n.data);
			return true;
		}
		else
		{
			while(t.next!=null)
			{
				t=t.next;
			}
			
			t.next=n;
			System.out.println("EnQueued: "+n.data);
			return true;
		}
	}
	 /* Method to delete first-node of Linked List*/
	 boolean deleteFirst(Queue queue)
	{
		Node t=null;
		
		while(head!=null)
		{
			t=head.next;
			System.out.println("Dequeued: "+head.data);
			head=t;
			queue.display(queue);
			System.out.println();
			System.out.println("**************************************");
		}
		return true;
	}
	
	 /* Method to check if two numbers are anagram*/
	static boolean isAnagram(int n1,int n2)
	{
		if(digitCount(n1)!=digitCount(n2))
			return false;
		
		if(compare(n1,n2))
				return true;
		else
			return false;	
		
	}
	 /* Method to compare two integer arrays*/
	static boolean compare(int n1,int n2)
	{
		int arr1[]=new int[digitCount(n1)];
		int arr2[]=new int[digitCount(n2)];
		int i=0;
		
		while(n1!=0 && n2!=0)
		{
			int rem1=n1%10;
			int rem2=n2%10;
			
			arr1[i]=rem1;
			arr2[i]=rem2;
			
			n1=n1/10;
			n2=n2/10;
			i++;
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		return Arrays.equals(arr1, arr2);
		
	}
	
	/*Method to count number of digits in a number*/
	static int digitCount(int number)
	{
		int digCount=0;
		while(number>0)
		{
			digCount++;
			number=number/10;
		}
		
		return digCount;
	}	
	/*Method to check if a number is prime*/
	static boolean isPrime(int n)
	{
		for (int i =2; i <=n/2; i++) 
		{
			if(n%i==0)
				return false;
		}
		return true;
	}

	
	 /*Method to display queue elements*/
	void display(Queue l) 
	{
		Node t = head;
		//If head 'null' then  List is empty
		if (head == null)    
		{
			System.out.println("No elements to display");
			return;
		}
		
		
		/*If head not 'null' then traverse the entire list till end
		 *  i.e next_address='null' and display list_data */
		while (t != null)      
		{
			if (t.next != null)
			{
				System.out.print(t.data + "-->");
			}else
				{
					System.out.print(t.data);
				}
				t = t.next;
		}
	}
	
	public static void main(String[] args)
	{
		Queue queue=new Queue();
		
		  ArrayList<Integer> primeList=new ArrayList<Integer>();
		  
		  for (int i = 2; i < 1000; i++)
		  {
			  if (isPrime(i)) 
				  primeList.add(i);  //Adding prime numbers to arrayList
		  }
		  
		  System.out.println("Prime numbers: \n"+primeList);
		  
		  for (int i =0; i <primeList.size(); i++)
		  { 
			  for (int j = 2; j <1000; j++) 
			  {
				  if(isAnagram((int)primeList.get(i),j)) 
				  {
					  queue.addLast(queue,primeList.get(i));  //Adding prime & anagram numbers to queue
					  break; 
				  } 
		      }
			  queue.display(queue);
			  System.out.println();
			  System.out.println("**************************************");
		  }
		  queue.deleteFirst(queue); //Removing prime & anagram numbers from queue
	}
}
