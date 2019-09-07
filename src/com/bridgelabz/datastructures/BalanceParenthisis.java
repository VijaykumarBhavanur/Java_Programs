package com.bridgelabz.datastructures;

public class BalanceParenthisis 
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
	static Node head;
	boolean addLast(Object obj)
	{
		Node n=new Node(obj);
		if(head==null)
		{
			head=n;
			System.out.println("Pushed: "+n.data);
			System.out.println();
			return true;
		}
		
		Node t=head;
		
		while(t.next!=null)
		{
			t=t.next;
		}
		t.next=n;
		System.out.println("Pushed: "+n.data);
		System.out.println();
		return true;
	}
	
	boolean deleteLast()
	{
		Node t=head;
		
		if(t==null)
		{
			System.out.println("Stack empty");
			System.out.println();
			return false;
		}
		if(t.next==null)
		{
			System.out.println("Popped: "+t.data);
			System.out.println();
			head=null;
			return true;
		}
		
		while(t.next.next!=null)
		{
			t=t.next;
		}
		t.next=null;
		return true;
	}
	public static void main(String[] args) 
	{
		BalanceParenthisis stack=new BalanceParenthisis();
		
		String exp="(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
		//String exp="(a+b)+)";
		char re[]=exp.toCharArray();
		
		for (int i = 0; i < re.length; i++)
		{
			if(re[i]=='(')
				stack.addLast(re[i]);
			else
				if(re[i]==')')
				{
					System.out.println("Found ')'");
					System.out.println();
					boolean pop=stack.deleteLast();	
					if(!pop)
					{
						System.out.println("Expression Not Balanced");
						return;
					}
				}
		}
		
		if(head==null)
			System.out.println("Expression Balanced with parenthisis");
		else
			System.out.println("Expression Not Balanced");
		
	}
}
