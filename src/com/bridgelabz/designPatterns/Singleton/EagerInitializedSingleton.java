package com.bridgelabz.designPatterns.Singleton;

public class EagerInitializedSingleton 
{
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
		    
		    private EagerInitializedSingleton(){}

		    public static EagerInitializedSingleton getInstance()
		    {
		        return instance;
		    }

}
