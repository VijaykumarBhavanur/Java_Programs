package com.bridgelabz.utility;
import java.util.Scanner;

public class CommonUtility {
	
	/* Function to count number of digits in a number*/
	
	public  static int getDigitCount(int number)
	{
		int digCount=0;
		while(number>0)
		{
			digCount++;
			number=number/10;
		}
		
		return digCount;
	}
	
	/* Function to convert Celsius to Fahrenheit and vice-versa*/
	public static void TemperatureConversion()
	{
		System.out.println("Enter your choice:\n Press 1 to convert from Celsius to Fahrenheit\n Press 2 to convert Fahrenheit to Celsius");
		Scanner scanner=new Scanner(System.in);
		int choice=scanner.nextInt();
		double celsius,fahrenhiet;
		
		switch(choice)
		{
		case 1: System.out.println("Enter tempertaure in Celsius: ");
				celsius=scanner.nextDouble();
				fahrenhiet=(celsius * 9/5) + 32;
				System.out.println(celsius+"C = "+fahrenhiet+"F");
				break;
				
		case 2: System.out.println("Enter tempertaure in Fahrenheit: ");
				fahrenhiet=scanner.nextDouble();
				celsius=(fahrenhiet-32) * 5/9;
				System.out.println(fahrenhiet+"F= "+celsius+"C");
				break;
		default: System.out.println("Invalid Choice");
		}
		
	}
	
	/* Monthly Payment Calculation*/
	
	public static void monthlyPaymentCalculation()
	{
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Principal amount:");
		double principal=scanner.nextDouble();
		
		System.out.println("Enter Rate of intrest in percentage:");
		double intrest=scanner.nextDouble();
		
		System.out.println("Enter time period in years:");
		double years=scanner.nextDouble();
		
		
		double n=12*years,r=intrest/(12*100);
		
		double emi=(principal*r)/(1-(Math.pow(1+r,-n)));
		
		System.out.println("Monthly payment value: "+emi);
		
		
	}
	
	/* Binary Search method for Integer */
	
	public static int binarySearch(int a[],int n)
	{
		 int low=0,high=a.length-1;
			
			while(low<=high)
			{
				
				int mid=(low+high)/2;
				if(a[mid]==n)
					return mid;
				
				if(a[mid]<n)
					low=mid+1;
				
				else 
					high=mid-1;
			}	
			return -1;
		
		
	}
	
	/* Binary Search method for String */
	public static int binarySearchString(String a[],String s1)
	 {
		 int low=0,high=a.length-1;
			
			while(low<=high)
			{
				
				int mid=(low+high)/2;
				if(a[mid].equals(s1))
					return mid;
				
				if(a[mid].compareTo(s1)<0)
					low=mid+1;
				
				else 
					high=mid-1;
			}	
			return -1;
	 }
	
	/* Insertion Sort method for Integer*/
	
	static int[] insertionSort(int a[])
	{
		for (int i = 1; i < a.length; i++)
		{
			int j=i-1;
			
			int temp=a[i];
			
			while(j>=0 && a[j]>temp)
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
		}
		
		return a;
	}
	
	/* Insertion Sort method for String */
	
	public static String[]insertionSort(String s[])
	{
		for (int i = 1; i < s.length; i++) 
		{
			int j = i - 1;
			String temp = s[i];

			while (j >= 0 && s[j].toLowerCase().compareTo(temp.toLowerCase()) > 0) 
			{
				s[j + 1] = s[j];
				j--;
			}
			
			s[j + 1] = temp;
		}
		return s;
	}
	
	/* Bubble Sort method for Integer*/
	public static int[]bubbleSort(int a[])
	{
		int n=a.length;
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n - i - 1; j++) 
			{
				if (a[j] > a[j + 1]) 
				{
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}

			}

		}
		return a;
	}
	
	/* Bubble Sort method for String*/
	
	public static String[]bubbleSort(String a[])
	{
		int n = a.length;
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n - i - 1; j++) 
			{
				if (a[j].toLowerCase().compareTo(a[j+1].toLowerCase()) >0) 
				{
					String temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}

			}

		}
		return a;
	}
	/* Method to display String in proper Order*/
	
	public static void displayString(String arr[])
	 {
		 String st="{";
			for (int i = 0; i < arr.length; i++)
			{
				if(i!=arr.length-1)
					st=st+arr[i]+",";
				else
					st=st+arr[i]+"}";
			}
		 
		 System.out.println(st);
	 }
	public static void main(String[] args) {
		//TemperatureConversion();
		//monthlyPaymentCalculation();
		int a[]= {3, 6, 1, 8, 4, 5};
		String s1[]={"Refactor","Source","Navigate","Edit","File"};
		
		long beforeTime=0,afterTime=0;
		System.out.println("Binary Search Method for Integer");
		beforeTime=System.nanoTime();
		binarySearch(a,9);
		afterTime=System.nanoTime();
		System.out.println("::::::::::Time elapsed(Nano-seconds) for Binary Search Method for Integer::::::::\n"+(afterTime-beforeTime));
		
		System.out.println("Binary Search Method for String");
		beforeTime=System.nanoTime();
		binarySearchString(s1,"Search");
		afterTime=System.nanoTime();
		System.out.println("::::::::::Time elapsed(Nano-seconds) for Binary Search Method for String::::::::\n"+(afterTime-beforeTime));
		
		
		System.out.println("Insertion method for Integer");
		beforeTime=System.nanoTime();
		insertionSort(a);
		afterTime=System.nanoTime();
		System.out.println("::::::::::Time elapsed(Nano-seconds) for Insertion Method for Integer::::::::\n"+(afterTime-beforeTime));

		System.out.println("Insertion method for String");
		beforeTime=System.nanoTime();
		insertionSort(s1);
		afterTime=System.nanoTime();
		System.out.println("::::::::::Time elapsed(Nano-seconds) for Insertion Method for String::::::::\n"+(afterTime-beforeTime));
		
		
		System.out.println("Insertion method for Integer");
		beforeTime=System.nanoTime();
		bubbleSort(a);
		afterTime=System.nanoTime();
		System.out.println("::::::::::Time elapsed(Nano-seconds) for Bubble Sort Method for Integer::::::::\n"+(afterTime-beforeTime));
		
		
		System.out.println("Insertion method for String");
		beforeTime=System.nanoTime();
		bubbleSort(s1);
		afterTime=System.nanoTime();
		System.out.println("::::::::::Time elapsed(Nano-seconds) for Bubble Sort Method for String::::::::\n"+(afterTime-beforeTime));
	}

}
