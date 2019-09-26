package com.bridgelabz.TestingPrograms;

import java.util.Scanner;

class Transaction
{
	int tokenNo;
	double amount;
	
	public Transaction(int tokenNo,double amount)
	{
		this.tokenNo=tokenNo;
		this.amount=amount;
	}
}

public class Bank 
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
	
	Node head=new Node(1000.00);  //Initial bank balance 1000
	
	
	boolean add(Transaction data)
	{
		Node n=new Node(data); //Convert reference as Node Data.
		
		if(head.next==null) //No people in queue so add person
		{
			head.next=n;
			Transaction t1=(Transaction)n.data;
			
			if(t1.amount>0)
			{
				 System.out.println("Token No:"+t1.tokenNo+" deposited amount:Rs."+t1.amount);
				 System.out.println(head.data+"  + "+t1.amount);
				 double am=(double)head.data;
				 am=am+t1.amount;
				 head.data=am;
			}
			else
			{
				System.out.println("Token No:"+t1.tokenNo+" withdrawn amount:Rs."+(-1*t1.amount));
				System.out.println(head.data+"  - "+t1.amount);
				double am=(double)head.data;
				am=am+t1.amount;
				head.data=am;
			}
			
			return true;
		}
		
		Node t=head.next;
		while(t.next!=null)
		{
			t=t.next;
		}
		
		t.next=n; //some people exist in queue so add person at queue end
		Transaction t1=(Transaction)n.data;
		if(t1.amount>0)
		{
			System.out.println("Token No:"+t1.tokenNo+" deposited amount:Rs."+t1.amount);
			System.out.println(head.data+"  + "+t1.amount);
			double am=(double)head.data;
			am=am+t1.amount;
			head.data=am;
		}
		else
		{
			System.out.println("Token No:"+t1.tokenNo+" withdrawn amount:Rs."+(-1*t1.amount));
			System.out.println(head.data+"  - "+t1.amount);
			double am=(double)head.data;
			am=am+t1.amount;
			head.data=am;
		}
	
		return true;
	}
	
	double bankBalance()
	{
		return (double)head.data;
	}
	
	void display()
	{
		Bank b= new Bank();
		
		if(head.next==null)
			System.out.println("No people in queue\n Outstanding bank balance: "+b.bankBalance());
		else
		{
			Node t=head.next;
			
			while(t!=null)
			{
				Transaction tr=(Transaction)t.data;
				if(t.next!=null)
				System.out.print("[ "+tr.tokenNo+","+tr.amount+"] --->" );
				else
					System.out.print("[ "+tr.tokenNo+","+tr.amount+"]\n");
					
				t=t.next;
			}
			
		}
	}
	
	boolean dequeue()
	{
		if(head.next==null)
		{
			System.out.println("No people in Queue");
			return false;
			
		}
		Node t=head.next;
		
		while(head.next!=null)
		{
			Transaction tran=(Transaction)head.next.data;
			
			System.out.println("Dequed: "+tran.tokenNo);
			head.next=t.next;
			t=head.next;
		}
			System.out.println("No people in queue");
		
		return true;	
	}
	
	
	public static void main(String[] args) 
	{
			Bank b=new Bank();
			int token=0;
			
			@SuppressWarnings("resource")
			Scanner scanner=new Scanner(System.in);
			
			while(true)
			{
				System.out.println("More people");
				System.out.println("Press y if yess or n if not");
				char c=scanner.next().charAt(0);
				if(c=='n' || c=='N')
					break;
				
				
				System.out.println("Press 1 for deposit:\nPress 2 for withdraw");
				char ch1=scanner.next().charAt(0);
				
					if(ch1=='1')
					{
							token++;
							System.out.println("Enter amount: ");
							double amount=scanner.nextDouble();
							Transaction t1= new Transaction(token,amount);
							
							b.add(t1);
					}
					
					else if(ch1=='2')
					{
						token++;
						System.out.println("Enter amount: ");
						double amount=scanner.nextDouble();
						Transaction t2= new Transaction(token,-(amount));
						b.add(t2);
					}
			}
			
			b.display();
			b.dequeue();
			System.out.println("Outstanding Bank balance: "+b.bankBalance());
	}

}
