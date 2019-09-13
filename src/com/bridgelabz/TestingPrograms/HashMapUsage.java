package com.bridgelabz.TestingPrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapUsage 
{
	public static void main(String[] args)
	{
			
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(1,"abc");
		map.put(2,"xyz");
		
		Set<Integer>set=map.keySet();
		for (Integer i : set)
		{
			System.out.println("Key: "+i+"Value: "+map.get(i));
		}
		
		}

}
