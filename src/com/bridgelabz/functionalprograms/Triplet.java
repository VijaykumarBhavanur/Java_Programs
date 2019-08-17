package com.bridgelabz.functionalprograms;

public class Triplet {

	public static void main(String[] args) {
	    int a[]= {-2,3,-1,5,4,-9,8,-6,11,-3,1,7,14,45,-15,-30};
	    int tripletCount=0;
	    
	    for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				for (int k = j+1; k < a.length; k++) {
					if(a[i]+a[j]+a[k]==0)
					{
						System.out.println("["+a[i]+","+a[j]+","+a[k]+"]");
						tripletCount++;
					}
				}
			}
		}
	    System.out.println("Number of Triplets whose value is Zero: "+tripletCount);
	}

}
