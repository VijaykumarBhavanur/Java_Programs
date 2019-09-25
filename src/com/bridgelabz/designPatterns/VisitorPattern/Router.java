package com.bridgelabz.designPatterns.VisitorPattern;

//https://howtodoinjava.com/design-patterns/behavioral/visitor-design-pattern-example-tutorial/
	public interface Router
	{
	    public void sendData(char[] data);
	    public void acceptData(char[] data);
	    public void accept(RouterVisitor v);
	}
