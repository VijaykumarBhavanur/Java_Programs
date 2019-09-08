package com.bridgelabz.datastructures;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OLL 
{
	/*Custom data-type 'Node' with two fields 'data'-->to store data and
	 *'next'-->to hold reference of next node */
	
  class Node      
	{
		Object data;
		Node next;
		
		public Node(Object data)
		{
			this.data = data;
		}
	}
	
	static Node head;
	
	/*Method to add elements to Linked_List*/ 
    boolean add(Object obj) 
	{
		 /* Node n = new Node(obj);
		  * Convert an Object to Node Type 
		  * Example:
		  *      _________________
		  *	   |  25  |   null   |
		  *	   |______|__________|
		  */
		
		Node n = new Node(obj);
		//If head 'null' then  List is empty, add element and make head pointer to refer it
		if (head == null) 
		{
		    head = n;  	
			return true;
		}
			Node t = head;

			/* If head not 'null' then traverse the entire list till end
			 *  i.e next_address='null' and add element */
			
			while (t.next != null) 
			{
				
				t = t.next;      
			}
		
		t.next = n;
		return true;
	}
	
	/*Method to display elements of Linked_List*/
    void display(OLL l) 
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
	
	/*Method to find a number in Linked_List*/
    
    int search(OLL ll, int word) {
		Node t = head;
		int i = 0;

		while (t != null) {
			if ((int)t.data==word)
				return i;
			t = t.next;
			i++;
		}

		return -1;
	}
	
	/*Method to delete a number in Linked_List*/
	void deleteData(OLL link, int data) 
	{
		Node t = head;
		Node move = t.next;
		

		 if ((int)t.data==data && t.next != null)
		{
			head = t.next;
			return;
		}
		while (move != null) 
		{
			if ((int)t.next.data==data) 
			{
				t.next = move.next;
				return;
			}
			t = t.next;
			move = move.next;
		}
	}

	/*Method to add a number at specific position in Linked_List*/
	void insertAtSpecificPosition(OLL oll,int num)
	{
		Node t=head;
		Node move=t.next;
		Node n=new Node(num);
		
		while(t.next!=null)
		{
			// To insert at First
			if(num<(int)t.data)
			{
				n.next=t;
				head=n;
				break;
			}
			// To insert at Specific position
			if(num>(int)t.data && num<(int)move.data )
			{
				n.next=move;
				t.next=n;
				break;
			}
			t=t.next;
			move=move.next;
		}
		
		if((int)t.data<num)	
		{
			t.next=n; //To insert at last 
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		//int arr[] = { 11, 2, 30, 4, 50 };
		
		OLL link = new OLL();

		Scanner scanner = new Scanner( new File("/home/admin1/Desktop/number.txt") );
		
		ArrayList<Integer> numbers=new ArrayList<Integer>();
		scanner.useDelimiter(",");
		
		while(scanner.hasNext())
		{
			String s=scanner.next().trim();
			numbers.add(Integer.parseInt(s.replaceAll("\\uFEFF", "")));
		}
		
		System.out.println("Before sorting: ");
		System.out.println(numbers);
		
		
		Collections.sort(numbers);
		System.out.println("After sorting: ");
		System.out.println(numbers);
		
		for (int i = 0; i <numbers.size(); i++)
		{
			link.add(numbers.get(i));
		}
		
		System.out.println("After adding to link list: ");
		
		
		link.display(link);
		System.out.println();
		
		
		System.out.println("Enter number you want to find: ");
		  Scanner sc=new Scanner(System.in);
		  int findNum=sc.nextInt();
		  
			int search= link.search(link,findNum);
			
			  if(search!=-1)
			  {
				  link.deleteData(link, findNum);
				  System.out.println(findNum+" found at index: "+search);
				  System.out.println("After deleting: "+findNum);
				  link.display(link);
				  System.out.println();
			  }
			  else
			  {
				  link.insertAtSpecificPosition(link,findNum);
				  System.out.println(findNum+" not found in list: ");
				  System.out.println("After adding at specific: "+findNum);
				  link.display(link);
				  System.out.println();
				  
			  }
		  }
			  
	}
