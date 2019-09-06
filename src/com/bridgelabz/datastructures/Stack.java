package com.bridgelabz.datastructures;

import java.util.ArrayList;

public class Stack 
{
	class Node
	{
		Node next;
		Object data;
		
		public Node(Object data) 
		{
			this.data = data;
		}
	}
	
	Node head;
	boolean addLast(Stack stack,Object num)
	{
		Node n=new Node(num);
		Node t=head;
		
		if(head==null)
		{
			head=n;
			System.out.println("Pushed: "+n.data);
			stack.displayStack(stack);
			System.out.println();
			return true;
		}
		
		while(t.next!=null)
		{
			t=t.next;
		}
		t.next=n;
		System.out.println("Pushed: "+n.data);
		stack.displayStack(stack);
		System.out.println();
		return true;
	}
	
	boolean deleteLast(Stack stack)
	{
		if(head.next==null)
		{
			System.out.println("Popped: "+head.data);
			head=null;
			return true;
		}
		Node t=head;
		
		while(t.next.next!=null)
		{		
			t=t.next;
		}
		System.out.println("Popped: "+t.next.data);
		t.next=null;
		return true;
	}
	void displayStack(Stack stack)
	{
		if(head==null)
		{
			System.out.println("No elements to display ");
			return;
		}
		Node t=head;
		while(t!=null)
		{
			if(t.next!=null)
				System.out.print(t.data+"-->");
			else
				System.out.print(t.data);
			t=t.next;
		}
	}
	Node t=head;
	
	void pop(Stack stack)
	{
		t=head;
		if(t==null)
		{
			System.out.println("No elements to pop");
			return;
		}
		if(t.next==null)
		{
			System.out.println("Popped: "+t.data);
			head=null;
			stack.displayStack(stack);
			System.out.println();
			return;
		}
		
		while(t.next.next!=null)
		{
			t=t.next;
		}
		System.out.println("Popped: "+t.next.data);
		t.next=null;
		stack.displayStack(stack);
		System.out.println();
		pop(stack);
	}
	public static void main(String[] args) 
	{
		
		  ArrayList<Integer> primeList=new ArrayList<Integer>();
		  Stack stack=new Stack();
		  for (int i = 2; i <1000; i++)
		  { 
			  if(Queue.isPrime(i)) 
				  primeList.add(i);
		  }
		  
		 for (int i = 0; i <primeList.size(); i++) 
		 {
			for (int j = 0; j <1000; j++)
			{
				if(Queue.isAnagram(primeList.get(i),j))
				{
					stack.addLast(stack,primeList.get(i));
					break;
				}
			}
		}
		System.out.println();
		stack.pop(stack);
	}

}
