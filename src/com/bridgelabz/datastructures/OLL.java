package com.bridgelabz.datastructures;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OLL<T>
{
	/* Custom class to create node in linked list*/
	
  class Node      
	{
		Object data;
		Node next;
		
		public Node(Object data)
		{
			this.data = data;
		}
	}
	
	 Node head;
	
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
    void display(OLL<Integer> l) 
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
					System.out.print(t.data+"\n");
				}
				t = t.next;
		}
	}
	
	/*Method to find a number in Linked_List*/
    
    int search(OLL<Integer> ll, int word) {
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
	void deleteData(OLL<Integer> link, int data) 
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
	void insertAtSpecificPosition(OLL<Integer> oll,int num)
	{
		Node n=new Node(num);
		if(head==null)
		{
			head=n;   //List is empty add newNode 
			return ;
		}
		
		Node t=head;
		Node move=t.next;
	
		if(t.next==null && (int)t.data>num)
		{
			n.next=t;
			head=n;      //If number less than head.data add it first
			return;
		}
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
	
	/*Method to add numbers to file*/
	 void writeListToFile(FileWriter file,OLL<Integer> link) throws IOException
	{
		if(head==null)
		{
			System.out.println("No content to write in file");
			return;
		}
		Node t=head;
		while(t!=null)
		{
			if(t.next!=null)
				file.write(String.valueOf(t.data)+",");
			else
				file.write(String.valueOf(t.data));
			
			t=t.next;
		}
		file.close();
	}
	public static void main(String[] args) throws IOException 
	{
		
		OLL<Integer>  link = new OLL<Integer> ();

		Scanner scanner = new Scanner( new File("/home/admin1/Desktop/number.txt") );
		
		ArrayList<Integer> numbers=new ArrayList<Integer>();
		scanner.useDelimiter(",");
		
		while(scanner.hasNext())
		{
			String s=scanner.next().trim();
			numbers.add(Integer.parseInt(s.replaceAll("\\uFEFF", "")));
		}
		
		System.out.println("Contents of file: ");
		System.out.println(numbers+"\n");
		
		
		for (int i = 0; i <numbers.size(); i++)
		{
			link.insertAtSpecificPosition(link,numbers.get(i));
		}
		
		System.out.println("After sorting and adding to link list: ");
		link.display(link);
		
		System.out.println();

		System.out.println("Enter number you want to find: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int findNum = sc.nextInt();

		int search = link.search(link, findNum);

		if (search != -1) 
		{
			link.deleteData(link, findNum);
			System.out.println(findNum + " found at index: " + search);
			System.out.println("After deleting: " + findNum);
			link.display(link);
			System.out.println();
		} 
		else 
		{
			link.insertAtSpecificPosition(link, findNum);
			System.out.println(findNum + " not found in list: ");
			System.out.println("After adding "+findNum+" at specific position: ");
			link.display(link);
			System.out.println();
		  }
		
		
		   FileWriter fw=new FileWriter("/home/admin1/Desktop/sortedNumber.txt");  
		   //adding numbers to file
		   link.writeListToFile(fw, link);
		
	}
}
