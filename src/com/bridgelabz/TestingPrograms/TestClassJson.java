package com.bridgelabz.TestingPrograms;

import java.io.File;

import java.io.IOException;


//import org.codehaus.jackson.map.ObjectMapper;


import com.bridgelabz.oops.Company;


public class TestClassJson 
{
	public static void main(String[] args) throws IOException
	{


	File file =new File("/home/admin1/Desktop/demo.json");

	com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
	Company com=mapper.readValue(file, Company.class);
	System.out.println(com);
	com.setEachSharePrice(5000);
	mapper.writeValue(file, com);
	
	}

}
