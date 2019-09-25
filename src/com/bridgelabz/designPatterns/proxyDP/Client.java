package com.bridgelabz.designPatterns.proxyDP;

public class Client 
{ 
    public static void main (String[] args) 
    { 
        Internet internet = new ProxyInternet(); 
      
            try 
            {
				internet.connectTo("google.com");
				internet.connectTo("abc.com"); 
			} 
            catch (Exception e) 
            {
				System.out.println("Access Denied");
			} 
    } 
} 