package com.bridgelabz.clinique;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Patient 
{
	@JsonProperty
	private int id;
	@JsonProperty
	private String name; 
	@JsonProperty
	private long mobileNumber;
	@JsonProperty
	private int age;
	@JsonProperty
	private String desease;
	
	public Patient()
	{
		
	}
	public int getId() {
		return id;
	}
	public Patient(int id, String name, long mobileNumber, int age,String desease) 
	{
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getDesease() {
		return desease;
	}
	public void setDesease(String desease) {
		this.desease = desease;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString()
	{
		return "Patient_Id=" + id + "    Name=" + name + "    mobileNumber=" + mobileNumber + "    Age=" + age + "    desease="
				+ desease;
	}
	
}
