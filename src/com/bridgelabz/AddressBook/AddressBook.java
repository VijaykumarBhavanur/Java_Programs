package com.bridgelabz.AddressBook;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddressBook 
{
	static Scanner scanner=new Scanner(System.in);
	static java.util.List<Contact> contact;
	static File file;
	static String currentAddressBook;

	/* Method to add new contact to address-book*/
	
	public static void addContact() throws JsonParseException, JsonMappingException, IOException
	{
		System.out.println("Adding contact........");
		System.out.println("Enter first name: ");
		String fname=scanner.next();
		
		System.out.println("Enter last name: ");
		String lname=scanner.next();
		
		System.out.println("Enter city: ");
		String city=scanner.next();
		
		System.out.println("Enter zipcode: ");
		int zip=scanner.nextInt();
		
		System.out.println("Enter Mobile number: ");
		long mobile=scanner.nextLong();
		
		Contact newContact=new Contact(contact.size()+1,fname,lname,city,zip,mobile);
		contact.add(newContact);
		System.out.println("After adding new Contact.........");
		System.out.println("Saving address book.......");
		saveAddressBook();
		
	}
	
	/* Method to edit an existing contact of address-book*/
	public static void updateContact() throws JsonGenerationException, JsonMappingException, IOException
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
			
			if(res!='Y' && res!='y' && res!='N' && res!='n')
				throw new InputMismatchException();
			
			if(res=='Y'||res=='y')
			{
				System.out.println("Enter new value for firstName: ");
				String fName=scanner.next();
				upContact.setFirstName(fName);
			}
			
			System.out.println("Do you wish to edit lastName of contact?");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
			

			if(res!='Y' && res!='y' && res!='N' && res!='n')
				throw new InputMismatchException();
			
			if(res=='Y'||res=='y')
			{
				System.out.println("Enter new value for lastName: ");
				String lName=scanner.next();
				upContact.setLastName(lName);
			}
			
			
			System.out.println("Do you wish to edit city field of contact?");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
			

			if(res!='Y' && res!='y' && res!='N' && res!='n')
				throw new InputMismatchException();
			if(res=='Y'||res=='y')
			{
				System.out.println("Enter new value for city: ");
				String city=scanner.next();
				upContact.setCity(city);
			}
			
			System.out.println("Do you wish to edit zipCode of contact?");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
			

			if(res!='Y' && res!='y' && res!='N' && res!='n')
				throw new InputMismatchException();
			if(res=='Y'||res=='y')
			{
				System.out.println("Enter new value for zipCode: ");
				int zipCode=scanner.nextInt();
				upContact.setZipCode(zipCode);
			}
			
			System.out.println("Do you wish to edit mobileNumber of contact?");
			System.out.println("Press 'Y' if Yes or 'N' if not");
			res=scanner.next().charAt(0);
			

			if(res!='Y' && res!='y' && res!='N' && res!='n')
				throw new InputMismatchException();
			if(res=='Y'||res=='y')
			{
				System.out.println("Enter new value for mobileNumber: ");
				long mobileNumber=scanner.nextLong();
				upContact.setMobileNumber(mobileNumber);
			}
		
		contact.set(id-1,upContact);
			
		updateId();
		saveAddressBook();
		System.out.println("After updation: ");
		showAddressBook(currentAddressBook);
		
	}
	
	
	/* Method to maintain sequence of Id after deletion of contact from address-book*/
	public static void updateId() 
	{
		int id=1;
		for (Contact contact2 : contact) 
		{
			contact2.setId(id);
			id++;
		}
	}
	
	
	/* Method to save address-book to json file*/
	public static void saveAddressBook() throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(file, contact);
	}
	
	/*method to delete a contact from address-book*/
	public static void deleteContact() throws JsonGenerationException, JsonMappingException, IOException
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
		saveAddressBook();
		System.out.println("deleting.......");
		showAddressBook(currentAddressBook);
	}
	
	/*Method to terminate program*/
    public static void quit()
	{
		System.exit(0);
	}
	
    /*Method to Show available Options*/
    public static void  showOptions() throws IOException
	{
		System.out.println("\nEnter your choice: ");
		System.out.println("1.Add Contact\n2.Update Contact\n3.Delete Contact\n4.Sort Contacts By First name\n5.Sort Contacts By Zip code\n6.Save Address Book\n7.Save Address Book As\n8.Main Menu\n9.Quit");
		char choice=scanner.next().charAt(0);
		
		switch(choice)
		{
		case '1': addContact();
				break;
				
		case '2': updateContact();
				break;
				
		case '3': deleteContact();
				break;
		
		case '4': sortByFirstName();
				  break;
				  
		case '5': sortByZipCode();
				  break;
				  
		case '6': saveAddressBook();
				 break;
				 
		case '7': saveAddressBookAs();
				 break;
				 
		case '8': mainMenu();
				  break;
				  
		case '9': quit();
					break;
		default: System.out.println("Invalid output");
		}
	}
	
    /*Method to display main-menu*/
	static void mainMenu() throws IOException
	{
		System.out.println("\n=+=+=+=+=+=+=+=+=+=Welcome to Address Book Management System=+=+=+=+=+=+=+=+=+=\n\n");
		System.out.println("Enter your choice: ");
		
		System.out.println("1.Create new Address Book\n2.Open Existing Address Book\n3.Quit");
		char c=scanner.next().charAt(0);
			switch (c)
			{
			
			case '1': System.out.println("Enter name for new AddressBook: ");
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
		
			case '2': System.out.println("Enter your choice: ");
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
			case '3': quit();
				default: System.out.println("Invalid Input");
				     break;
			}
	}
	
	/*Method to display all contacts available in address-book*/
	public static void showAddressBook(String book) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		file =new File("/home/admin1/Desktop/ContactList/"+book);
		
		if(file.length()==0)
		{
			System.out.println("Address-Book Empty No contacts to display");
			mainMenu();
		}
	    contact=new ArrayList<Contact>(Arrays.asList(mapper.readValue(file,Contact[].class)));
	    
	    for (Contact contact2 : contact)
	    {
	     System.out.print("ID: "+contact2.getId()+"  FIRSTNAME: "+contact2.getFirstName()+"  LASTNAME: "+contact2.getLastName()+
	    		 "  CITY: "+contact2.getCity()+"  MOBILE: "+contact2.getMobileNumber()+"  ZIPCODE: "+contact2.getZipCode()+"\n");
		}
	}
	
	/*Method to save address-book to a different file*/
	public static void saveAddressBookAs() throws JsonGenerationException, JsonMappingException, IOException
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
			
	}
	
	/*Method to sort contacts of address-book by first-name*/
	public static void sortByFirstName()
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
	public static void sortByZipCode()
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
		mainMenu();
	}
}
