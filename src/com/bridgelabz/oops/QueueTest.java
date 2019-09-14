package com.bridgelabz.oops;

import com.bridgelabz.datastructures.Queue;
import com.bridgelabz.datastructures.Queue.Node;

public class QueueTest
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
	 void addLast(Player player)
	{
		
		 for (int i = 0; i <player.deckOfCards.length; i++)
		 {
			 Node n=new Node(player.deckOfCards[i]); //creating new-node from data
			 Node t=head;
				
				if(head==null)
				{
					head=new Node(player.playername);
					//System.out.println("EnQueued: "+n.data);
				}
				else
				{
					while(t.next!=null)
					{
						t=t.next;
					}
					
					t.next=n;
					//System.out.println("EnQueued: "+n.data);
				}
		 }
	}

	
	 /*Method to display queue elements*/
	void display() 
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
	
	 boolean deleteFirst(Queue queue)
		{
			Node t=null;
			
			while(head!=null)
			{
				t=head.next;
				System.out.println("Dequeued: "+head.data);
				head=t;
				System.out.println();
			}
			return true;
		}
	
	public static void main(String[] args)
	{
		
	}
}
