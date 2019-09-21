package com.bridgelabz.clinique;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Doctor 
{
	@JsonProperty
	private int id;
	@JsonProperty
	private String name;
	@JsonProperty
	private  String specialization;
	@JsonProperty
	private String availability;
	
	
	@JsonIgnoreProperties
	private int appointCount=0;
	
	@JsonIgnoreProperties
	private ArrayList<Patient>appointPatient=new ArrayList<Patient>();
	
	public Doctor()
	{
		
	}
	public Doctor(int id, String name, String specialization, String availability, int appointCount,ArrayList<Patient>appointPatient) 
	{
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.availability = availability;
		this.appointCount = appointCount;
		this.appointPatient=appointPatient;
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
		return "Doctor_Id=" + id + "    name=" + name + "    specialization=" + specialization+ "    availability=" + availability;
	}
	public ArrayList<Patient> getAppointPatient() {
		return appointPatient;
	}
	public void setAppointPatient(ArrayList<Patient> appointPatient) {
		this.appointPatient = appointPatient;
	}
	
	
}
