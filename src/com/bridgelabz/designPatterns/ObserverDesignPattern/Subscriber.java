package com.bridgelabz.designPatterns.ObserverDesignPattern;

public class Subscriber
{
	String name;
	Channel channel=new Channel();
	
	public Subscriber(String name) 
	{
		this.name=name;
	}
	
	public void subcribed(Channel ch)
	{
		channel=ch;
	}
	
	public void update()
	{
		System.out.println("Hey,"+name+" video "+channel.title+" Uploaded ");
	}
}
