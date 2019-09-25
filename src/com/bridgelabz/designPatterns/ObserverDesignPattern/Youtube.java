package com.bridgelabz.designPatterns.ObserverDesignPattern;

public class Youtube 
{
	public static void main(String[] args) 
	{
		Channel geeks=new Channel();
		Subscriber s1=new Subscriber("Maithili");
		Subscriber s2=new Subscriber("Aryan");
		
		geeks.subscribe(s1);
		geeks.subscribe(s2);
		
		s1.subcribed(geeks);
		s2.subcribed(geeks);
		
		geeks.upload("Design patterns");

	}
}
