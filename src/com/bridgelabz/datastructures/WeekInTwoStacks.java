package com.bridgelabz.datastructures;
public class WeekInTwoStacks 
{
	public static void main(String[] args)
	{
		Stack firstHalfStack=new Stack();
		Stack secondHalfStack=new Stack();
		
		Queue queue=WeekQueue.getCalendarAsQueue();
		
		for (int i = 0; i <queue.size(); i++) 
		{
			if(i<queue.size()/2)
				firstHalfStack.addLast(firstHalfStack, queue.get(i));
			else
				secondHalfStack.addLast(secondHalfStack, queue.get(i));
		}
		
		firstHalfStack.displayStack(firstHalfStack);
		System.out.println();
		secondHalfStack.displayStack(secondHalfStack);
	}

}
