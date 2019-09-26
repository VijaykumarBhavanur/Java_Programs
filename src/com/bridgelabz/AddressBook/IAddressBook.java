package com.bridgelabz.AddressBook;

public interface IAddressBook {

	
	void addContact();
	void updateContact();
	void updateId();
	void saveAddressBook();
	void deleteContact();
	void quit();
	void  showOptions();
	void mainMenu();
	void showAddressBook(String book);
	void saveAddressBookAs();
	void sortByFirstName();
	void sortByZipCode();
	
	
}
