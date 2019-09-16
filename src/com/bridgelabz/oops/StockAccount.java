package com.bridgelabz.oops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockAccount 
{
	
	static TreeMap<Integer, Customer>customerList=new TreeMap<Integer, Customer>();
	static TreeMap<Integer, Company> companyData=new TreeMap<Integer, Company>();
	static TreeMap<Integer, Transaction> transactionData=new TreeMap<Integer, Transaction>();
	
	
	int transactionIndex=1;
	/* Method to create stock_account for a customer*/
	public   TreeMap createStockAccount(String file) throws FileNotFoundException, IOException, ParseException
	{
		JSONObject json=(JSONObject) new JSONParser().parse(new FileReader(file));
		JSONArray a=(JSONArray)json.get("CUSTOMER");
		
		int code=1;
		
		for (int i = 0; i < a.size(); i++)
		{
			JSONObject j=(JSONObject)a.get(i);
			String name=(String)j.get("Name");
			double accountBalance=Double.valueOf(j.get("AccountBalance").toString());
			int sharePurchased=Integer.valueOf(j.get("SharePurchased").toString());
			
			Customer customer=new Customer(code++,name, accountBalance, sharePurchased);
			
			
			customerList.put(customer.AccountId,customer);
			System.out.println("New stock account created with details: \n");
			System.out.print("\n AccountId: "+customer.AccountId+"\nName: "+customer.name+" balance: "+customer.accountBalance+"  no.OfShare: "+customer.sharePurchased+"\n");
		}
		return customerList;
	}
	/*Method to create a stock of company*/
	public  TreeMap createCompanyStock(String file) throws FileNotFoundException, IOException, ParseException
	{
		JSONObject json=(JSONObject) new JSONParser().parse(new FileReader(file));
		JSONArray a=(JSONArray)json.get("STOCK");
		
		for (int i = 0; i < a.size(); i++)
		{
			JSONObject j=(JSONObject)a.get(i);
			int serialNo=Integer.valueOf(j.get("serialNo").toString());
			String companyName=(String)j.get("companyName");
			int numberofShareAvailable=Integer.valueOf(j.get("numberofShareAvailable").toString());
			double eachSharePrice=Double.valueOf(j.get("eachSharePrice").toString());
			
			Company company=new Company(serialNo,companyName,numberofShareAvailable,eachSharePrice);
			
			companyData.put(company.serialNo,company);
			System.out.println("\nNew company stock  created with details: \n");
			System.out.print("\nSerial No: "+company.serialNo+" \nCompanyName: "+company.companyName+" \nNo.OfShares: "+company.numberofShareAvailable+"  \nPriceOfEachShare: "+company.eachSharePrice+"\n");
		}
		
		return companyData;
		
	}
	
	/*Method to return account value of a customer*/
	public  double valueOf(Customer customer)
	{
		return customer.getValueOfAccount();
	}
	
	/*Method to purchase share for a customer*/
	public  void buy(TreeMap<Integer, Company> companyList,Customer customer)
	{
		Scanner scanner=new Scanner(System.in);
		displayAvailableCompanyStocks();
		
		System.out.println("Enter company serial number to purchase stock: ");
		int serial=scanner.nextInt();
		
		System.out.println("Enter number of shares to purchase: ");
		int noOfShares=scanner.nextInt();
		
		
		Company company=companyList.get(serial);
		
		if(noOfShares>company.numberofShareAvailable)
		{
				while(noOfShares>company.numberofShareAvailable)
				{
					System.out.println(noOfShares+" shares are not available for company "+company.companyName+"\nNumber of shares available are: "+company.numberofShareAvailable);
					System.out.println("Enter number of shares <= "+company.numberofShareAvailable+"\n");
					noOfShares=scanner.nextInt();
				}
		}
		if(noOfShares*company.eachSharePrice>customer.accountBalance)
		{
			while(noOfShares*company.eachSharePrice>customer.accountBalance)
			{
				System.out.println("Insuffient account balance: ");
				int possibleShare=(int) (customer.accountBalance/company.eachSharePrice);
				System.out.println("You can purchase maximum: "+possibleShare+" shares for this company");
				System.out.println("Enter number of shares <= "+possibleShare+"\n");
				noOfShares=scanner.nextInt();
			}
			
		}
			System.out.println("Before transaction:\n customer account balance: "+customer.accountBalance);
			System.out.println("share purchased: "+customer.sharePurchased+"\n");
			
			
			/* Updating number of Share purchased of customer*/
		
			double updateBal=customer.accountBalance-(noOfShares*company.eachSharePrice);
			customerList.get(customer.AccountId).setAccountBalance(updateBal);
			
			int updateShare=customer.sharePurchased+noOfShares;
			customerList.get(customer.AccountId).setSharePurchased(updateShare);
			
			
			
			/* Updating number of Shares available in company*/
			companyList.get(serial).numberofShareAvailable=companyList.get(serial).numberofShareAvailable-noOfShares;
			
			System.out.println("After transaction:\n customer account balance: "+customer.accountBalance);
			System.out.println("share purchased: "+customer.sharePurchased+"\n\n");
		
			Transaction transaction=new Transaction(company.companyName,customer.name,noOfShares,0,noOfShares*company.eachSharePrice);
			transactionData.put(transactionIndex++, transaction);
	}
	
	public void printTransactionReport()
	{
		Set s=transactionData.keySet();
		System.out.println("Transaction No.           CompanyName              CustomerName            No.OfSharesPurchased            No.OfSharesSold             TotalTransactionValue");
		
		for (Object object : s) 
		{
		System.out.println(object+"                     "+transactionData.get(object).companyName+"                       "+transactionData.get(object).customerName+
				          "                            "+transactionData.get(object).noOfSharesPurchased+"                    "+transactionData.get(object).noOfSharesSold+
				          "                             "+transactionData.get(object).totalTransactionValue);
		}
	}
	
	public void sell(TreeMap<Integer, Company> companyList,Customer customer)
	{
			Scanner scanner=new Scanner(System.in);
			displayAvailableCompanyStocks();
			
			System.out.println("Enter company serial number to sell stock: ");
			int serial=scanner.nextInt();
			
			System.out.println("Enter number of shares to sell: ");
			int noOfShares=scanner.nextInt();
			
			
			Company company=companyList.get(serial);
			
			if(noOfShares>customer.sharePurchased)
			{
					while(noOfShares>customer.sharePurchased)
					{
						System.out.println(noOfShares+" shares are not available in your account \nNumber of shares available are: "+customer.sharePurchased);
						System.out.println("Enter number of shares <= "+customer.sharePurchased+"\n");
						noOfShares=scanner.nextInt();
					}
			}
			
				
			
				System.out.println("Before transaction:\n customer account balance: "+customer.accountBalance);
				System.out.println("share purchased: "+customer.sharePurchased+"\n");
				
				
				/* Updating number of Share purchased of customer*/
			
				double updateBal=customer.accountBalance+(noOfShares*company.eachSharePrice);
				customerList.get(customer.AccountId).setAccountBalance(updateBal);
				
				int updateShare=customer.sharePurchased-noOfShares;
				customerList.get(customer.AccountId).setSharePurchased(updateShare);
				
				
				
				/* Updating number of Shares available in company*/
				companyList.get(serial).numberofShareAvailable=companyList.get(serial).numberofShareAvailable+noOfShares;
				
				System.out.println("After transaction:\n customer account balance: "+customer.accountBalance);
				System.out.println("share purchased: "+customer.sharePurchased+"\n");
				
				
				Transaction transaction=new Transaction(company.companyName,customer.name,0,noOfShares,noOfShares*company.eachSharePrice);
				transactionData.put(transactionIndex++, transaction);
			
		}
	
		public  void displayAvailableCompanyStocks()
	{
		
		System.out.println("Serial-no       Company-name    Number of shares available      Price of eack stock");
		Set s=companyData.keySet();
		
		for (Object object : s)
		{
			Company c=(Company)companyData.get(object);
			System.out.print("   "+c.serialNo+"             "+c.companyName+"                   "+c.numberofShareAvailable+"                 "+c.eachSharePrice+"\n\n");
		}
	}
	
	
	public void displayCustomerData()
	{
		System.out.println("AccountId              Name               SharePurchased            AccountBalance");
		Set s=customerList.keySet();
		
		for (Object object : s)
		{
			Customer c=(Customer)customerList.get(object);
			System.out.print("   "+c.AccountId+"              "+c.name+"                    "+c.sharePurchased+"                  "+c.accountBalance+"\n\n");
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
	{

		String file="/home/admin1/Desktop/customer.json";
		String file1="/home/admin1/Desktop/companyShare.json";
		
		StockAccount stockAccount=new StockAccount();
		
		stockAccount.createStockAccount(file);
		stockAccount.createCompanyStock(file1);
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*Before Transaction*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("                             Company Stock List                                    ");
		stockAccount.displayAvailableCompanyStocks();
		System.out.println("\n\n");
		
		System.out.println("                             Customer Data                                         ");
		stockAccount.displayCustomerData();
		
		System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("\n\n");
		
		
		while(true)
		{
		
			System.out.println("Enter your choice: \n Press P to buy share\n Press S to Sell share");
			char choice=scanner.next().charAt(0);
			
			
			if(choice=='P' || choice=='p')
				stockAccount.buy(companyData,customerList.get(1));
			else if(choice=='S' || choice=='s')
				stockAccount.sell(companyData,customerList.get(1));
			
			System.out.println("Want to do more Transcation? \n press y if Yes or n of Not");
			char res=scanner.next().charAt(0);
				
			if(res=='n' || res=='N')
				break;
		}
		
		
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*After Transactions*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("                             Company Stock List                                    ");
		stockAccount.displayAvailableCompanyStocks();
		System.out.println("\n\n");
		
		System.out.println("                             Customer Data                                         ");
		stockAccount.displayCustomerData();
		
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("\n\n");
		
		
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*Transaction report*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		
		stockAccount.printTransactionReport();
		
		
	}

}
