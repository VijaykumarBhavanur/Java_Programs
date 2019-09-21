package com.bridgelabz.clinique;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Doctor 
{
	@JsonProperty
	int id;
	@JsonProperty
	String name;
	@JsonProperty
	String specialization;
	@JsonProperty
	String availability;
	
	
	@JsonIgnoreProperties
	int appointCount;
	
	public Doctor()
	{
		
	}
	public Doctor(int id, String name, String specialization, String availability, int appointCount) 
	{
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.availability = availability;
		this.appointCount = appointCount;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public int getAppointCount() {
		return appointCount;
	}

	public void setAppointCount(int appointCount) {
		this.appointCount = appointCount;
	}

	@Override
	public String toString() {
		return "Doctor_Id=" + id + "    name=" + name + "    specialization=" + specialization;
	}
	
	
}
