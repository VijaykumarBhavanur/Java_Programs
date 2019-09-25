package com.bridgelabz.designPatterns.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Channel 
{

	String title;
	List<Subscriber>subList=new ArrayList<Subscriber>();
	
	
	public void subscribe(Subscriber s)
	{
		subList.add(s);
	}
	
	public void unsubscribe(Subscriber s)
	{
		subList.remove(s);
	}
	
	
	public void notifySubscriber()
	{
		for (Subscriber subscriber : subList)
		{
			subscriber.update();
		}
	}
	
	public void upload(String title)
	{
		this.title=title;
		notifySubscriber();
	}
}
