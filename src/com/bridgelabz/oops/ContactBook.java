package com.bridgelabz.oops;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bridgelabz.AddressBook.Contact;
public class ContactBook 
{
	
	TreeMap<Integer, Contact>contactList=new TreeMap<Integer, Contact>();
	File file =new File("/home/admin1/Desktop/contact.json");
	Contact[]contacts;
    static	ContactBook contactBook=new ContactBook();
	
	public void writeContact() throws JsonGenerationException, JsonMappingException, IOException
	{
		Set s=contactList.keySet();
		int i=0;
		Contact[] c=new Contact[contactList.size()];
		int index=1;
		
		for (Object object : s) 
		{
			c[i]=contactList.get(object);
			c[i].setId(index);
			index++;
			i++;
		}
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(file, c);
	
	}
	
	public void displayContacts()
	{
		Set<Integer> keys=contactList.keySet();
		for (Integer integer : keys)
		{
			System.out.print("id:"+contactList.get(integer).getId()+"\t"+"firstName:"+contactList.get(integer).getFirstName()+"\t"
					         +"lastName:"+contactList.get(integer).getLastName()+"\t"+"city:"+contactList.get(integer).getCity()+"\t"
					         +"zipCode:"+contactList.get(integer).getZipCode()+"\t"+"mobileNumber:"+contactList.get(integer).getMobileNumber()+"\t"+"\n\n");
		}
		System.out.println();
	}
	
	public void readContacts() throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper mapper=new ObjectMapper();
		
	    //contacts=mapper.readValue(file,Contact[].class);
	    
	    java.util.List<Contact> contact=Arrays.asList(mapper.readValue(file,Contact[].class));
	    
	    
	    System.out.println(contact.get(0).getCity());
	    contact.get(0).setCity("Pune");
	    System.out.println(contact.get(0).getCity());
	    
		/*
		 * for (int i = 0; i < contacts.length; i++) {
		 * contactList.put(contacts[i].id,contacts[i]); }
		 */
	    
	}
	
	public void addContact() throws JsonGenerationException, JsonMappingException, IOException
	{
		Contact contact=new Contact(contactList.lastKey()+1,"Ramesh","Jain","AP","500003","8784947832");
		contactList.put(contactList.lastKey()+1,contact);
		contactBook.writeContact();
	
	}
	
	public void deleteContact(int id) throws JsonGenerationException, JsonMappingException, IOException
	{
		contactList.remove(id);
		contactBook.writeContact();
	}
	
	public void updateContact() throws JsonGenerationException, JsonMappingException, IOException
	{
		System.out.println("Enter contact-Id to update contact: ");
		Scanner scanner=new Scanner(System.in);
		int id=scanner.nextInt();
		
		while(!contactList.containsKey(id))
		{
			System.out.println("contact with id: "+id+" doesn't exist: \n enter valid Contact-Id");
			id=scanner.nextInt();
		}
		
		char res;
		Contact contact=contactList.get(id);
		
		System.out.println("Do you wish to edit firstName of contact?");
		System.out.println("Press 'Y' if Yes or 'N' if not");
		res=scanner.next().charAt(0);
		
		if(res!='Y' && res!='y' && res!='N' && res!='n')
			throw new InputMismatchException();
		
		if(res=='Y'||res=='y')
		{
			System.out.println("Enter new value for firstName: ");
			String fName=scanner.next();
			contact.setFirstName(fName);
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
			contact.setLastName(lName);
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
			contact.setCity(city);
		}
		
		System.out.println("Do you wish to edit zipCode of contact?");
		System.out.println("Press 'Y' if Yes or 'N' if not");
		res=scanner.next().charAt(0);
		

		if(res!='Y' && res!='y' && res!='N' && res!='n')
			throw new InputMismatchException();
		if(res=='Y'||res=='y')
		{
			System.out.println("Enter new value for zipCode: ");
			String zipCode=scanner.next();
			contact.setZipCode(zipCode);
		}
		
		System.out.println("Do you wish to edit mobileNumber of contact?");
		System.out.println("Press 'Y' if Yes or 'N' if not");
		res=scanner.next().charAt(0);
		

		if(res!='Y' && res!='y' && res!='N' && res!='n')
			throw new InputMismatchException();
		if(res=='Y'||res=='y')
		{
			System.out.println("Enter new value for mobileNumber: ");
			String mobileNumber=scanner.next();
			contact.setMobileNumber(mobileNumber);
		}
		
		contactList.put(id,contact);
		contactBook.writeContact();
	}
	
	public static void main(String[] args)
	{
		try
		{
		contactBook.readContacts();
		//contactBook.displayContacts();
		//contactBook.addContact();
		//contactBook.deleteContact(1);
		//contactBook.updateContact();
		//System.out.println("Contact-List after updation: ");
		//contactBook.displayContacts();
		
		}
		catch (InputMismatchException e)
		{
			System.out.println("Invalid input");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}	
}
