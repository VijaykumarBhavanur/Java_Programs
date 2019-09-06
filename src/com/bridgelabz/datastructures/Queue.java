package com.bridgelabz.datastructures;

import java.util.ArrayList;
import java.util.Arrays;

import com.bridgelabz.datastructures.OLL.Node;

public class Queue
{
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
	 boolean addLast(Queue queue,Object num)
	{
		Node n=new Node(num);
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
	
	 boolean deleteFirst(Queue queue)
	{
		Node t=null;//=head.next;
		//System.out.println("Dequeued: "+head.data);
		
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
	
	static boolean isAnagram(int n1,int n2)
	{
		if(digitCount(n1)!=digitCount(n2))
			return false;
		
		if(compare(n1,n2))
				return true;
		else
			return false;	
		
	}
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
	static boolean isPrime(int n)
	{
		for (int i =2; i <=n/2; i++) 
		{
			if(n%i==0)
				return false;
		}
		return true;
	}

	/*
	 * void displayQueue(Queue queue) { Node t=head;
	 * 
	 * while(t!=null) { if(t.next!=null) System.out.println(t.data+"--->"); else
	 * System.out.println(t.data); t=t.next; } }
	 */
	 
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
		
		/*
		 * queue.addLast(queue,"1"); queue.addLast(queue,"2"); queue.addLast(queue,"3");
		 * queue.addLast(queue,"4"); queue.addLast(queue,"5"); queue.display(queue);
		 */
		
		//queue.displayQueue(queue);
		
		
		  ArrayList<Integer> primeList=new ArrayList<Integer>();
		  
		  for (int i = 2; i < 1000; i++)
		  {
			  if (isPrime(i)) 
				  primeList.add(i); 
		  }
		  
		  System.out.println("Prime numbers: \n"+primeList);
		  
		  for (int i =0; i <primeList.size(); i++)
		  { 
			  for (int j = 2; j <1000; j++) 
			  {
				  if(isAnagram((int)primeList.get(i),j)) 
				  {
					  queue.addLast(queue,primeList.get(i)); 
					  break; 
				  } 
		      }
			  queue.display(queue);
			  System.out.println();
			  System.out.println("**************************************");
		  }
		  queue.deleteFirst(queue);
	}
}
