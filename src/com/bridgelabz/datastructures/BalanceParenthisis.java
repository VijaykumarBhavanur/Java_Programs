package com.bridgelabz.datastructures;

public class BalanceParenthisis 
{
	/* Custom class to create node in linked list*/
	class Node
	{
		Object data;
		Node next;
		
		public Node(Object data)
		{
			this.data=data;
		}
	}
	
	
	static Node head;
	
	/* Method to add new-node at the end of Linked List*/
	boolean addLast(Object obj)
	{
		Node n=new Node(obj); //Creating new-node with given data
	
		if(head==null)
		{
			head=n;    //head null so add new-node as first-node 
			System.out.println("Pushed: "+n.data);
			System.out.println();
			return true;
		}
		
		Node t=head;
		
		while(t.next!=null)
		{
			t=t.next;  //Traversing linked-list till end
		}
		t.next=n;     // adding new-node at end of linked-list 
		System.out.println("Pushed: "+n.data);
		System.out.println();
		return true;
	}
	
	
	/* Method to remove node at the end of Linked List*/
	boolean deleteLast()
	{
		Node t=head;
		
		if(t==null)
		{
			System.out.println("Stack empty");  //head null so linked-list has no data
			System.out.println();
			return false;
		}
		if(t.next==null)
		{
			System.out.println("Popped: "+t.data); //head.next=null means only one element exist so remove it
			System.out.println();
			head=null;
			return true;
		}
		
		while(t.next.next!=null)
		{
			t=t.next; //Traversing linked-list till end
		}
		t.next=null; //Removing last node
		return true;
	}
	
	public static void main(String[] args) 
	{
		BalanceParenthisis stack=new BalanceParenthisis();
		
		String exp="(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
		char re[]=exp.toCharArray();
		
		for (int i = 0; i < re.length; i++)
		{
			if(re[i]=='(')
				stack.addLast(re[i]);  //pushing "(" to stack
			else
				if(re[i]==')')
				{
					System.out.println("Found ')'");
					System.out.println();
					
					boolean pop=stack.deleteLast();	 //Popping ")" from stack
					
					if(!pop) //If no element to pop i.e no "(" in stack
					{
						System.out.println("Expression Not Balanced");
						return;
					}
				}
		}
		
		if(head==null) //Matched ")" for every "("
			System.out.println("Expression Balanced with parenthisis");
		else
			System.out.println("Expression Not Balanced");
		
	}
}
