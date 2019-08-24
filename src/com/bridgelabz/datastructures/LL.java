package com.bridgelabz.datastructures;

public class LL 
{
	class Node
	{
			Object data;
			Node next;
			
			public Node(Object data)
			{
				this.data=data;
			}
	}
	
	Node head;
	
	boolean add(Object obj)
	{
		
		Node n=new Node(obj);
		
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
	
	boolean addFirst(Object obj)
	{
		Node temp=head;
		Node newNode=new Node(obj);
		
		if(head!=null)
		{
		newNode.next=temp;
		head=newNode;
		return true;
		}
		
		head=newNode;
		return true;
	}
	
	boolean addLast(Object obj)
	{
		Node newNode=new Node(obj);
		Node t=head;
		
		while(t.next!=null)
		{
			t=t.next;	
		}
		
		t.next=newNode;
		return true;
	}
	
	void display(LL l)
 {
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
	
	boolean addAtIndex(Object obj,int index)
	{
		Node temp=head;
		Node newNode=new Node(obj);
		int i=0;
		
		while(i<index)
		{
			temp=temp.next;	
			i++;
		}
		
		Node t=temp.next;
		temp.next=newNode;
		newNode.next=t;
		
		return true;
		
	}
	public static void main(String[] args) 
	{
		LL link=new LL();
		link.add(9);
		link.add(1);
		link.add(6);
		link.add(4);
		link.add(4);
		link.add(8);
		link.add(0);
		link.add(8);
		link.add(3);
		link.add(2);
		System.out.println("Before addition: ");
		link.display(link);
		link.addFirst(0);
		System.out.println("After adding @ first: ");
		link.display(link);
		link.addLast(0);
		System.out.println("After adding @ last: ");
		link.display(link);
		
		link.addAtIndex(0,4);
		
		System.out.println("After adding @ index 4: ");
		link.display(link);
		
	}

}
