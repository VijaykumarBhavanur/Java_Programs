package com.bridgelabz.clinique;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Hospital 
{
	static File doctorFile;
	static File patientFile;
	static List<Doctor>doctorList;
	static List<Patient>patientList;
	
	static Map<String, Integer>popularDoctor=new TreeMap<String, Integer>();
	static Map<String, Integer>popularSpecialization=new TreeMap<String, Integer>();
	
	static List<Doctor> getAllDoctors() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		doctorFile=new File("/home/admin1/Desktop/Hospital/doctor.json");
		
		if(doctorFile.length()==0)
		{
			System.out.println("No record found");
		}
		
		
		doctorList=new ArrayList<Doctor>(Arrays.asList(mapper.readValue(doctorFile, Doctor[].class)));
		
		for (Doctor doctor : doctorList)
		{
			System.out.println(doctor);
		}
		
		
		/*Logic used to check popularity*/
		
		for (Doctor doctor : doctorList) 
		{
			popularDoctor.put(doctor.getName(), 0);
			popularSpecialization.put(doctor.getSpecialization(), 0);
		}
		
		
		
		return doctorList;
	}
	
	static List<Patient> getAllPatients() throws JsonParseException, JsonMappingException, IOException
	{
	
		patientFile=new File("/home/admin1/Desktop/Hospital/patient.json");
		
		if(patientFile.length()==0)
		{
			System.out.println("No record found");
		}
		
		 ObjectMapper mapper=new ObjectMapper();
         patientList=new ArrayList<Patient>(Arrays.asList(mapper.readValue(patientFile,Patient[].class)));
		
		for (Patient patient : patientList) 
		{
				System.out.println(patient);
		}
		return patientList;
	}
	
	static List<Doctor> getDoctorByName(String name)
	{
		System.out.println("searching name:::::"+name);
		List<Doctor>docByname=new ArrayList<Doctor>();
		
		for (Doctor doctor : doctorList)
		{
			if(doctor.getName().contains(name))
			{
				System.out.println("found doctor::::: with name:::::"+doctor.getName());
				docByname.add(doctor);
			}
		}
		return docByname;
	}
	
	static int getDoctorByID(int id)
	{
		System.out.println("searching ID:::::"+id);
		
		for (Doctor doctor : doctorList)
		{
			
			if(doctor.getId()==id)
			{
				System.out.println("found doctor:::with ID:::::::"+doctor.getId());
				return doctor.id;
			}
		}
		return 0;
	}

	static List<Doctor> getDoctorBySpecialization(String spec)
	{
		System.out.println("searching Specialization:::::"+spec);
		
		List<Doctor>docBySpec=new ArrayList<Doctor>();
		for (Doctor doctor : doctorList)
		{
			
			if(doctor.getSpecialization().equals(spec))
			{
				System.out.println("found doctor with Specialization::::::::::"+doctor.getSpecialization());
				docBySpec.add(doctor);
			}
		}
		return docBySpec;
	}
	
	static List<Doctor> getDoctorByAvalibility(String available)
	{
		System.out.println("searching availability:::::"+available);
		List<Doctor>docByavial=new ArrayList<Doctor>();
		for (Doctor doctor : doctorList)
		{
			System.out.println(doctor.getName());
			
			if(doctor.getAvailability().equals(available))
			{
				System.out.println("found doctor::::with availability::::::"+doctor.getAvailability());
				docByavial.add(doctor);
			}
		}
		return docByavial;
	}
	
	static List<Patient> getPatientByName(String name)
	{
		List<Patient>patientByname=new ArrayList<Patient>();
		System.out.println("Searching patient by name::::::::"+name);
		for (Patient patient : patientByname)
		{
				if(patient.getName().contains(name))
				{
					patientByname.add(patient);
					System.out.println("Found patient ::::::::::"+patient.getName());
				}
		}
		return patientByname;
	}
	
	static int getPatientByID(int id)
	{
		System.out.println("searching patient by ID:::::"+id);
		
		for (Patient patient : patientList)
		{
			if(patient.getId()==id)
			{
				System.out.println("found patient:::with ID:::::::"+patient.getId());
				return patient.id;
			}
		}
		return 0;
	}
	
	static int getPatientByMobile(long mobile)
	{
		System.out.println("searching mobile:::::"+mobile);
		
		for (Patient patient : patientList)
		{
			if(patient.mobileNumber==mobile)
			{
				System.out.println("found patient::::: with mobile:::::"+patient.getMobileNumber());
				return patient.getId();
			}
		}
		return 0;
	}
	
	static String getPopularDoctor()
	{
		return "";
	}
	
	static String getPopularSpecialization()
	{
		return "";
	}
	
	
	static void getAppointment()
	{
		//System.out.println(patientList.get(0).getDesease());
		String spec=patientList.get(0).getDesease();
		List<Doctor>doc=getDoctorBySpecialization(spec);
		//System.out.println(doc);
		
		int docId=doc.get(0).getId();
		Doctor freeDoctor=doctorList.get(docId);
		
		int i=0;
		System.out.println("\n\n----------------Getting appointment-------------------\n\n");
		while(doctorList.get(docId).appointCount<5)
		{
			freeDoctor.setAppointCount(freeDoctor.getAppointCount()+1);
			System.out.println(freeDoctor.name+" appointed to: "+patientList.get(i).getName()+"\n");
			//popularDoctor.put(freeDoctor.name,);
			i++;
		}
		System.out.println("Sorry doctor is busy!!!!! visit after some time");
		
	}
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		
		//search Doctor by name, id, Specialization or Availability.
		//search patient by name, mobile number or id.
		
		
		getAllDoctors();
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		getAllPatients();
		System.out.println("\n\n\n\n\n");
		getAppointment();
		
	}

}
