package com.bridgelabz.AddressBook;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddressBook  implements IAddressBook
{
	static Scanner scanner=new Scanner(System.in);
	static java.util.List<Contact> contact;
	static File file;
	static String currentAddressBook;

	/* Method to add new contact to address-book*/
	
	public  void addContact() 
	{
		try
		{
		System.out.println("Adding contact........");
		System.out.println("Enter first name: ");
		String fname=scanner.next();
		
		while(!Pattern.compile("^[a-zA-Z]{1,15}$").matcher(fname).matches())
		{
			System.out.println("Invalid firstname\n Enter valid firstname: ");
			fname=scanner.next();
		}
		
		
		System.out.println("Enter last name: ");
		String lname=scanner.next();
		
		while(!Pattern.compile("^[a-zA-Z]{1,15}$").matcher(lname).matches())
		{
			System.out.println("Invalid lastname\n Enter valid lastname: ");
			lname=scanner.next();
		}
		
		
		
		System.out.println("Enter city: ");
		String city=scanner.next();
		
		while(!Pattern.compile("^[a-zA-Z]{1,15}$").matcher(city).matches())
		{
			System.out.println("Invalid city\n Enter valid city: ");
			city=scanner.next();
		}
		
		
		
		
		
		System.out.println("Enter zipcode: ");
		String zip=scanner.next();
		
		while(!Pattern.compile("^[1-9][0-9]{5}$").matcher(String.valueOf(zip)).matches())
		{
			System.out.println("Invalid ZIPCode\n Enter valid ZipCode with 6 digits: ");
			zip=zip=scanner.next();
		}
		
		
		
		System.out.println("Enter Mobile number: ");
		String mobile=scanner.next();
		
		while(!Pattern.compile("^[7-9][0-9]{9}$").matcher(String.valueOf(mobile)).matches())
		{
			System.out.println("Invalid Mobile number\n Enter valid mobile number with 10 digits: ");
			mobile=scanner.next();
		}
		
		
		Contact newContact=new Contact(contact.size()+1,fname,lname,city,zip,mobile);
		contact.add(newContact);
		System.out.println("After adding new Contact.........");
		System.out.println("Do you wish to save changes?\nPress 'Y' if yes or 'N' if not");
		
		char res=scanner.next().charAt(0);
		while(res!='Y' && res!='y' && res!='N' && res!='n')
		{
			System.out.println("Invalid choice\nEnter valid choice: ");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
		}
		if(res=='Y'||res=='y')
		saveAddressBook();
		}
		catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
	
	/* Method to edit an existing contact of address-book*/
	public  void updateContact() 
	{
		try
		{
		if(file.length()==0)
		{
			System.out.println("Address-Book Empty! No contacts to update");
			mainMenu();
		}
		
		System.out.println("Updating contact........");
		System.out.println("Enter contact-Id to update: ");
		int id=scanner.nextInt();
		 while(id>contact.size())
			{
			System.out.println("Invalid contact-Id");
			System.out.println("Enter valid contact-Id");
			id=scanner.nextInt();
			}
		 
		 Contact upContact=contact.get(id-1);
		 
		 char res;
			System.out.println("Do you wish to edit firstName of contact?");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
			
			while(res!='Y' && res!='y' && res!='N' && res!='n')
			{
				System.out.println("Invalid choice\nEnter valid choice: ");
				System.out.println("Press 'Y' if Yes or 'N' if not");
				res=scanner.next().charAt(0);
			}
			
			if(res=='Y'||res=='y')
			{
				
				System.out.println("Enter new value for firstName: ");
				String fName=scanner.next();
				
				while(!Pattern.compile("^[a-zA-Z]{1,15}$").matcher(fName).matches())
				{
					System.out.println("Invalid firstname\n Enter valid firstname: ");
					fName=scanner.next();
				}
				upContact.setFirstName(fName);
			}
			
			System.out.println("Do you wish to edit lastName of contact?");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
			

			while(res!='Y' && res!='y' && res!='N' && res!='n')
			{
				System.out.println("Invalid choice\nEnter valid choice: ");
				System.out.println("Press 'Y' if Yes or 'N' if not");
				res=scanner.next().charAt(0);
			}
			
			if(res=='Y'||res=='y')
			{
				System.out.println("Enter new value for lastName: ");
				String lName=scanner.next();
				
				while(!Pattern.compile("^[a-zA-Z]{1,15}$").matcher(lName).matches())
				{
					System.out.println("Invalid last name\n Enter valid last name: ");
					lName=scanner.next();
				}
				upContact.setLastName(lName);
			
			}
				
			System.out.println("Do you wish to edit city field of contact?");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
			

			while(res!='Y' && res!='y' && res!='N' && res!='n')
			{
				System.out.println("Invalid choice\nEnter valid choice: ");
				System.out.println("Press 'Y' if Yes or 'N' if not");
				res=scanner.next().charAt(0);
			}
			
			if(res=='Y'||res=='y')
			{
				System.out.println("Enter new value for city: ");
				String city=scanner.next();
				
				while(!Pattern.compile("^[a-zA-Z]{1,15}$").matcher(city).matches())
				{
					System.out.println("Invalid city\n Enter valid city  name: ");
					city=scanner.next();
				}
				upContact.setCity(city);
			}
			
			
			
			System.out.println("Do you wish to edit zipCode of contact?");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
			

			while(res!='Y' && res!='y' && res!='N' && res!='n')
			{
				System.out.println("Invalid choice\nEnter valid choice: ");
				System.out.println("Press 'Y' if Yes or 'N' if not");
				res=scanner.next().charAt(0);
			}
			
			if(res=='Y'||res=='y')
			{	
				System.out.println("Enter zipcode: ");
				String zip=scanner.next();
				
				while(!Pattern.compile("^[1-9][0-9]{5}$").matcher(String.valueOf(zip)).matches())
				{
					System.out.println("Invalid ZIPCode\n Enter valid ZipCode with 6 digits: ");
					zip=scanner.next();
				}
				
				upContact.setZipCode(zip);
			
			}
			
			System.out.println("Do you wish to edit mobileNumber of contact?");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
			

			while(res!='Y' && res!='y' && res!='N' && res!='n')
			{
				System.out.println("Invalid choice\nEnter valid choice: ");
				System.out.println("Press 'Y' if Yes or 'N' if not");
				res=scanner.next().charAt(0);
			}
			
			if(res=='Y'||res=='y')
			{
				System.out.println("Enter Mobile number: ");
				String mobile=scanner.next();
				
				while(!Pattern.compile("^[7-9][0-9]{9}$").matcher(String.valueOf(mobile)).matches())
				{
					System.out.println("Invalid Mobile number\n Enter valid mobile number with 10 digits: ");
					mobile=scanner.next();
				}
			}
		
		contact.set(id-1,upContact);
			
		updateId();
		System.out.println("Do you wish to save changes?\nPress 'Y' if yes or 'N' if not");
		while(res!='Y' && res!='y' && res!='N' && res!='n')
		{
			System.out.println("Invalid choice\nEnter valid choice: ");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
		}
		if(res=='Y'||res=='y')
		saveAddressBook();
		System.out.println("After updation: ");
		showAddressBook(currentAddressBook);
		}catch (Exception e) {
		System.out.println("Invalid operation");
		}
		
	}
	
	
	/* Method to maintain sequence of Id after deletion of contact from address-book*/
	public  void updateId() 
	{
		int id=1;
		for (Contact contact2 : contact) 
		{
			contact2.setId(id);
			id++;
		}
	}
	
	
	/* Method to save address-book to json file*/
	public  void saveAddressBook()
	{
		ObjectMapper mapper=new ObjectMapper();
		try
		{
		mapper.writeValue(file, contact);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*method to delete a contact from address-book*/
	public  void deleteContact()
	{
		try
		{

		if(file.length()==0)
		{
			System.out.println("Address-Book Empty! No contacts to delete");
			mainMenu();
		}
		
		System.out.println("Deleting contact........");
		System.out.println("Enter contact-Id to be deleted: ");
		int id=scanner.nextInt();
		 while(id>contact.size())
			{
			System.out.println("Invalid contact-Id");
			System.out.println("Enter valid contact-Id");
			id=scanner.nextInt();
			}
		 contact.remove(id-1);
		updateId();
		
		System.out.println("Do you wish to save changes?\nPress 'Y' if yes or 'N' if not");
		
		char res=scanner.next().charAt(0);
		while(res!='Y' && res!='y' && res!='N' && res!='n')
		{
			System.out.println("Invalid choice\nEnter valid choice: ");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
		}
		
		if(res=='Y'||res=='y')
		saveAddressBook();
	
		System.out.println("deleting.......");
		showAddressBook(currentAddressBook);
		}
		catch (Exception e) {
			System.out.println("Invalid operation");
		}
	}
	
	/*Method to terminate program*/
    public  void quit()
	{
		System.exit(0);
	}
	
    /*Method to Show available Options*/
    public  void  showOptions() 
	{
    	try {
    	
		System.out.println("\nEnter your choice: ");
		System.out.println("1.Add Contact\n2.Update Contact\n3.Delete Contact\n4.Sort Contacts By First name\n5.Sort Contacts By Zip code\n6.Save Address Book\n7.Save Address Book As\n8.Main Menu\n9.Quit");
		int choice=scanner.nextInt();
		
		while(choice==0||choice>9)
		{
			System.out.println("Invalid choice\n Enter valid choice: ");
			choice=scanner.nextInt();
		}
		switch(choice)
		{
		case 1: addContact();
				  mainMenu();
				break;
				
		case 2: updateContact();
				  mainMenu();
				break;
				
		case 3: deleteContact();
				 mainMenu();
				break;
		
		case 4: sortByFirstName();
					mainMenu();
				  break;
				  
		case 5: sortByZipCode();
				  mainMenu();
				  break;
				  
		case 6: saveAddressBook();
				  mainMenu();
				 break;
				 
		case 7: saveAddressBookAs();
				mainMenu();
				 break;
				 
		case 8: mainMenu();
				  break;
				  
		case 9: quit();
					break;
		default: System.out.println("Invalid output");
		}
    	}catch (Exception e) {
			e.getMessage();
		}
	}
	
    /*Method to display main-menu*/
	public void mainMenu() 
	{
		try {
		System.out.println("\n=+=+=+=+=+=+=+=+=+=Welcome to Address Book Management System=+=+=+=+=+=+=+=+=+=\n\n");
		System.out.println("Enter your choice: ");
		
		System.out.println("1.Create new Address Book\n2.Open Existing Address Book\n3.Quit");
		String c=scanner.next();
		
		while(!Pattern.compile("[1-3]{1}").matcher(c).matches())
		{
			System.out.println("Invalid choice\n Enter valid choice: ");
			c=scanner.next();
		}
			switch (c)
			{
			
			case "1": System.out.println("Enter name for new AddressBook: ");
					  String name=scanner.next();
					  
					  file =new File("/home/admin1/Desktop/ContactList/"+name+".json");
			/*
			 * while(!file.createNewFile()) {
			 * System.out.println(name+" Address-Book already exist! choose some-other Name"
			 * ); name=scanner.next(); file =new
			 * File("/home/admin1/Desktop/ContactList/"+name+".json"); }
			 */
					  System.out.println("New Address-book created: "+name+".json");
					  contact=new ArrayList<Contact>();
					  currentAddressBook=name+".json";
					  showOptions();
					
					  break;
		
			case "2": System.out.println("Enter your choice: ");
					  File file1 =new File("/home/admin1/Desktop/ContactList");	
					  
					  String[]list=file1.list((contacts,fileName) -> fileName.endsWith(".json"));
						
					  for (int i = 0; i < list.length; i++)
					  {
						System.out.println(i+1+"."+list[i]);	
					  }
					  
					 int choice=scanner.nextInt();
					 System.out.println("Opening address-book: "+list[choice-1]);
					 currentAddressBook=list[choice-1];
					 showAddressBook(currentAddressBook);
					 showOptions();
					 break;
			case "3": quit();
				default: System.out.println("Invalid Input");
				     break;
			}
		}catch (Exception e)
		{
			System.out.println("Invalid input");
			}
		
	}
	
	/*Method to display all contacts available in address-book*/
	public  void showAddressBook(String book)
	{
		try
		{
		ObjectMapper mapper=new ObjectMapper();
		file =new File("/home/admin1/Desktop/ContactList/"+book);
		
		if(file.length()==0)
		{
			System.out.println("Address-Book Empty No contacts to display");
			showOptions();
			
		}
	    contact=new ArrayList<Contact>(Arrays.asList(mapper.readValue(file,Contact[].class)));
	    
	    for (Contact contact2 : contact)
	    {
	     System.out.print("ID: "+contact2.getId()+"  FIRSTNAME: "+contact2.getFirstName()+"  LASTNAME: "+contact2.getLastName()+
	    		 "  CITY: "+contact2.getCity()+"  MOBILE: "+contact2.getMobileNumber()+"  ZIPCODE: "+contact2.getZipCode()+"\n");
		}
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	/*Method to save address-book to a different file*/
	public  void saveAddressBookAs() 
	{
		try
		{
		System.out.println("Enter file-name: ");
		String newName=scanner.next();
		if(currentAddressBook.equals(newName))
			saveAddressBook();
		else
		{
			File file=new File("/home/admin1/Desktop/ContactList/"+newName+".json");
			ObjectMapper map=new ObjectMapper();
			map.writeValue(file, contact);
		}
		}catch (Exception e) {
			e.getMessage();
		}
			
	}
	
	/*Method to sort contacts of address-book by first-name*/
	public  void sortByFirstName()
	{
		Comparator<Contact> compareByFname = (Contact o1, Contact o2) -> o1.getFirstName().compareTo( o2.getFirstName() );
		 
		Collections.sort(contact, compareByFname);
		
		System.out.println("Sorting address book by firstName::::::::::::::::::::::::::::");
		for (int i = 0; i < contact.size(); i++)
		{
			Contact con1=(Contact)contact.get(i);
			System.out.print(con1.getFirstName()+"    "+con1.getLastName()+"    "+con1.getMobileNumber()+"    "+con1.getZipCode()+"    "+con1.getCity()+"\n");
		}
	}
	
	/*Method to sort contacts of address-book by zipCode*/
	public  void sortByZipCode()
	{
		Comparator<Contact> compareByZip = (Contact o1, Contact o2) -> new Integer(o1.getZipCode()).compareTo(new Integer(o2.getZipCode()));
		 
		Collections.sort(contact, compareByZip);
		
		System.out.println("Sorting address book by ZipCode::::::::::::::::::::::::::::");
		for (int i = 0; i < contact.size(); i++)
		{
			Contact con1=(Contact)contact.get(i);
			System.out.print(con1.getFirstName()+"    "+con1.getLastName()+"    "+con1.getMobileNumber()+"    "+con1.getZipCode()+"    "+con1.getCity()+"\n");
		}
	}
	
	/*Starting point of Application*/
	public static void main(String[] args) throws IOException
	{
		try {
			AddressBook address=new AddressBook();
			address.mainMenu();
		
		}catch (Exception e) {
		e.getMessage();
		}
	}
}
