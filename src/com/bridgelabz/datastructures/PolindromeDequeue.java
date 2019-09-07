package com.bridgelabz.datastructures;

import java.util.Scanner;

public class PolindromeDequeue 
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
	
	void display()
	{
		if(head==null)
		{
			System.out.println("No elements to display");
			return;
		}
		Node t=head;
		while(t!=null)
		{
			if(t.next!=null)
				System.out.print(t.data+"-->");
			else
				System.out.print(t.data+"\n");
			
			t=t.next;
		}
		
	}
	boolean add(Object data)
	{
		Node n=new Node(data);
		
		if(head==null)
		{
			head=n;
			return true;
		}
		Node t=head;
		while(t.next!=null)
		{
			t=t.next;
		}
		t.next=n;
		return true;
	}
	
	char deleteFirst()
	{
		Node t=head;
		char data=' ';
		
		if(head==null)
		{
			System.out.println("No elements to delete");
			return data;
		}
		
		if(t.next==null)
		{
			data=(char)t.data;
			head=null;
		}
		data=(char)t.data;
		head=t.next;
		return data;
	}
	
	char deleteLast()
	{
		Node t=head;
		
		char data=' ';
		
		if(head==null)
		{
			//System.out.println("No elements to delete");
			return data;
		}
		
		while(t.next!=null)
		{
			if(t.next.next==null)
			{
				data=(char)t.next.data;
				t.next=null;
				return data;
			}
			t=t.next;
		}
		
		data=(char)head.data;
		head=null;
		return data;
	}
	
	
	
	int size()
	{
		int count=0;
		Node t=head;
		while(t!=null)
		{
			count++;
			t=t.next;
		}
		return count;
	}
	
	boolean isPolindrome(PolindromeDequeue deque)
	{
		Node t=head;
		boolean polindrome=true;
		
		
		if(deque.size()%2==0 && deque.size()!=0)
		{
			while(t!=null&&deque.size()!=0)
			{
				char first=deque.deleteFirst();
				System.out.println("fetching: "+first+" from front end");
				char last=deque.deleteLast();
				System.out.println("fetching: "+last+" from rear end");
				System.out.println("Comparing "+first+" & "+last+"\n");
				
					if(first!=last)
					{
						polindrome=false;
						System.out.println(first+" & "+last+" are not same\n");
						break;
					}
					else
						System.out.println(first+" & "+last+" are same\n");
				t=t.next;
			}
		}
		else
		{
			int index=deque.size()/2;
			
			int i=0;
			
			while(i<index && deque.size()!=0)
			{
				char first=deque.deleteFirst();
				System.out.println("fetching: "+first+" from front end");
				char last=deque.deleteLast();
				System.out.println("fetching: "+last+" from rear end");
				System.out.println("Comparing "+first+" & "+last+"\n");
				
					if(first!=last)
					{
						System.out.println(first+" & "+last+" are not same\n");
						polindrome=false;
						break;
						//return polindrome;
					}
					else
						System.out.println(first+" & "+last+" are same\n");
				i++;
			}
			
		}
		return polindrome;
		
	}
	public static void main(String[] args) 
	{
			PolindromeDequeue deque=new PolindromeDequeue();
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the string to check if Polindrome: ");
			String string=scanner.next();
			
			char data[]=string.toCharArray();
			
			for (int i = 0; i < data.length; i++) 
			{
				deque.add(data[i]);
			}
		/*
		 * deque.add('m'); deque.add('a'); deque.add('d'); deque.add('a');
		 * deque.add('m');
		 */
			
			deque.display();
			
		/*
		 * while(deque.size()!=0) System.out.println(deque.deleteLast()+" deleted");
		 */
			
		
		  System.out.println("No of elements in dequeue :"+deque.size());
		  
		  boolean check=deque.isPolindrome(deque);
		  
		  if(check)
			  System.out.println(string+" Polindrome"); 
		  else
		  System.out.println(string+" Not Polindrome");
		 
			
		
		/*
		 * deque.deleteLast(); deque.display();
		 * System.out.println("******************");
		 * 
		 * deque.deleteLast(); deque.display();
		 * 
		 * System.out.println("******************");
		 * 
		 * deque.deleteLast(); deque.display();
		 * 
		 * System.out.println("******************");
		 * 
		 * deque.deleteLast(); deque.display();
		 * 
		 * System.out.println("******************");
		 * 
		 * deque.deleteLast(); deque.display();
		 * 
		 * System.out.println("******************");
		 * 
		 * deque.deleteLast(); deque.display();
		 */
		 
	}
}
