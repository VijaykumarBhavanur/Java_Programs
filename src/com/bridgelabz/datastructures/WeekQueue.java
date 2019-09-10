package com.bridgelabz.datastructures;
class WeekDay
{
	String day;
	String date;
	
	public WeekDay(String day,String date)
	{
		this.day=day;
		this.date=date;
	}
}

public class WeekQueue 
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

	
	  void display() 
	  {
		  	Node t=head;
	  
		  while(t!=null) 
		  { 
			  WeekDay day=(WeekDay)t.data;
		  
			  if(t.next!=null)
				  System.out.print(day.day+"----->"+day.date);
		  
			  else
				  System.out.print(day.day+"----->"+day.date+"\n");
			  t=t.next; 
			}
	  
	  }
	 
	void displayCalender()
	{
		Node t=head;
		
		while(t!=null)
		{
			WeekDay w=(WeekDay)t.data;
			System.out.print(w.day+"  ");
			if(w.date.compareTo("07")==0)
				break;
			t=t.next;
		}
		
		t=head;
		System.out.println();
		while(t!=null)
		{
			WeekDay w=(WeekDay)t.data;
			if(w.day.equalsIgnoreCase("Sa"))
				System.out.println(w.date);
			else
				System.out.print(w.date+"  ");
			
			t=t.next;
		}
	}
	
	public static void main(String[] args) 
	{
		int i=1;
		int index=0;
		
		String weeks[]= {"Su","Mo","Tu","We","Th","Fr","Sa"};
		int in=0;
		WeekQueue wq=new WeekQueue();
		while(i<=30)
		{
			if(i<10)
			{
			WeekDay w=	new WeekDay(weeks[index],"0"+String.valueOf(i));
			wq.add(w);
			}
			else
			{
				WeekDay w=	new WeekDay(weeks[index],String.valueOf(i));
				wq.add(w);
			}
			in++;
			index++;
			if(index==7)
			{
				index=0;
			}
			i++;
		}
		
		
		System.out.println("List of WeekDay Objects: ");
		wq.display();
		System.out.println();
		wq.displayCalender();
		
		
	}

}
