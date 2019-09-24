package com.bridgelabz.clinique;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Hospital 
{
	/* File containing list of doctors */
	static File doctorFile;

	/* File containing list of patient */
	static File patientFile;

	/* List of doctors */
	static List<Doctor> doctorList;

	/* List of patient */
	static List<Patient> patientList;

	/*
	 * Map with doctor id as key and noumberOfPatientCount as value to maintain
	 * popularDoctor
	 */
	static Map<Integer, Integer> popularDoctor = new TreeMap<Integer, Integer>();

	/*
	 * Map with Specialization as key and noumberOfPatientCount as value to maintain
	 * popular Specialization
	 */
	static Map<String, Integer> popularSpecialization = new TreeMap<String, Integer>();

	/*
	 * Map with doctorId as key and list of patients as value to maintain
	 * appointment data
	 */
	static Map<Integer, ArrayList<Patient>> appointment = new TreeMap<Integer, ArrayList<Patient>>();

	static Scanner scanner = new Scanner(System.in);

	static void displayAllDoctors()
	{
		for (Doctor doctor : doctorList)
		{
			System.out.format("DOCTOR_ID:%2s      Name:%-10s      Speciality:%-10s      Availability:%-1s",doctor.getId(),doctor.getName(),doctor.getSpecialization(),doctor.getAvailability()+"\n\n");
		}
	}
	
	static void displayAllPatients()
	{
		for (Patient patient : patientList) 
		{
			System.out.format("PATIENT_ID:%2s      Name:%-10s      Age:%-2s      Mobile:%-1s    Desease:%-1s",patient.getId(),patient.getName(),patient.getAge(),patient.getMobileNumber(),patient.getDesease()+"\n\n");
		}
	}
	
	static List<Doctor> getAllDoctors() throws JsonParseException, JsonMappingException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		doctorFile = new File("/home/admin1/Desktop/Hospital/doctor.json");

		if (doctorFile.length() == 0) 
		{
			System.out.println("No record found");
		}
		
		//Reading all doctor details from JSON File
		doctorList = new ArrayList<Doctor>(Arrays.asList(mapper.readValue(doctorFile, Doctor[].class)));

		/* Logic used to check popularity */

		for (Doctor doctor : doctorList) 
		{
			popularDoctor.put(doctor.getId(), 0);
			popularSpecialization.put(doctor.getSpecialization(), 0);
		}

		return doctorList;
	}

	static List<Patient> getAllPatients() throws JsonParseException, JsonMappingException, IOException {

		patientFile = new File("/home/admin1/Desktop/Hospital/patient.json");

		if (patientFile.length() == 0) 
		{
			System.out.println("No record found");
		}

		ObjectMapper mapper = new ObjectMapper();
		//Reading all Patients from JSON File
		patientList = new ArrayList<Patient>(Arrays.asList(mapper.readValue(patientFile, Patient[].class)));
		return patientList;
	}

	static List<Doctor> getDoctorByName(String name) 
	{
		List<Doctor> docByname = new ArrayList<Doctor>();

		for (Doctor doctor : doctorList) 
		{
			if (doctor.getName().contains(name)) 
			{
				docByname.add(doctor);
			}
		}
		return docByname;
	}

	static Doctor getDoctorByID(int id) 
	{
		for (Doctor doctor : doctorList) 
		{
			if (doctor.getId() == id) 
			{
				return doctor;
			}
		}
		return null;
	}

	static List<Doctor> getDoctorBySpecialization(String spec) 
	{
		List<Doctor> docBySpec = new ArrayList<Doctor>();
		for (Doctor doctor : doctorList) 
		{
			if (doctor.getSpecialization().equals(spec))
			{
				docBySpec.add(doctor);
			}
		}
		return docBySpec;
	}

	static List<Doctor> getDoctorByAvalibility(String available) 
	{
		List<Doctor> docByavial = new ArrayList<Doctor>();
		for (Doctor doctor : doctorList) 
		{
			if (doctor.getAvailability().equals(available)) 
			{
				docByavial.add(doctor);
			}
		}
		return docByavial;
	}

	static List<Patient> getPatientByName(String name) 
	{
		List<Patient> patientByname = new ArrayList<Patient>();
		for (Patient patient : patientByname) 
		{
			if (patient.getName().contains(name)) 
			{
				patientByname.add(patient);
			}
		}
		return patientByname;
	}

	static Patient getPatientByID(int id) 
	{
		for (Patient patient : patientList) 
		{
			if (patient.getId() == id)
			{
				return patient;
			}
		}
		return null;
	}

	static Patient getPatientByMobile(long mobile) 
	{
		for (Patient patient : patientList)
		{
			if (patient.getMobileNumber() == mobile) 
			{
				return patient;
			}
		}
		return null;
	}

	static void getPopularDoctor() 
	{
		if(popularDoctor.size()==0)
		{
		System.out.println("No popular doctor");
		return;
		}
		int res=Collections.max(popularDoctor.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
		
		System.out.println(doctorList.get(res));
	}

	static void getPopularSpecialization() 
	{
		if(popularSpecialization.size()==0)
		{
			System.out.println("No popular specilization");
			return;
		}
		
		String res=Collections.max(popularSpecialization.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();

		
		System.out.println("Popular Specilization: "+res);
	}

	static void getAppointment() 
	{
		// List of doctors of specialization matched with patient desease
		// Choose doctor based on Id in given list
		// Check if doctor appoint count is zero
		// assign a doctor to a patient and increment doctor appoint count

		// Maintain a map with doctor-Id as key and list of patients as value
		// to display doctor- patient appointment at present

		/* Getting all doctors with specialization matching patient desease */

		 System.out.println("\n\n\n\n\n");
		  
		  while(true) 
		  {
			  System.out.println("More patients???");
			  System.out.println("Press y if yes or n if no");
			  char c=scanner.next().charAt(0); 
			  
			  if(c=='n' || c=='N')
			  break;
			  
			  while(c!='y'&&c!='Y')
			  {
				  System.out.println("Invalid choice\n Enter valid choice");
			  }
				
			System.out.println("Enter patient ID to take appointment: ");
			int pid=scanner.nextInt();
			
			//If patient input greater than max patient id or less than 1
			while(pid>patientList.get(patientList.size()-1).getId() || pid<1)
			{
				System.out.println("Invalid Patient Id \n Enter valid Patient Id: ");
				pid=scanner.nextInt();
			}
		
			Patient patient=getPatientByID(pid);
			
			List<Doctor> doctWithSpec = getDoctorBySpecialization(patient.getDesease());
			for (Doctor doctor : doctWithSpec) 
			{
				System.out.format("DOCTOR_ID:%2s      Name:%-10s      Speciality:%-10s      Availability:%-1s",doctor.getId(),doctor.getName(),doctor.getSpecialization(),doctor.getAvailability()+"\n\n");
			}
	
			System.out.println("\nChoose doctor Id to get appointment: ");
			int dId = scanner.nextInt();
			
			Doctor appDoctor;
		
			//If entered id greater than max doctorId or negative input
			
			while(dId>doctorList.get(doctorList.size()-1).getId()||dId<1)
			{
				System.out.println("Invalid doctorId Enter valid doctor ID: ");
				 dId = scanner.nextInt();
			}
		
			appDoctor = getDoctorByID(dId);
			
			if (appDoctor.getAppointCount() < 5) 
			{
				// incrementing appointment count
				appDoctor.setAppointCount(appDoctor.getAppointCount() + 1);
				
				
				
				
				
				// adding patient to arrayList maintained by doctor
				appDoctor.getAppointPatient().add(patient);
				// adding doctor id and and patient list to maintain appointment data
				appointment.put(appDoctor.getId(), appDoctor.getAppointPatient());
				System.out.println("\n\n patient: "+patient.getName()+"got appointment with doctor: "+appDoctor.getName()+"\n\n");
				
				popularDoctor.put(appDoctor.getId(),popularDoctor.get(appDoctor.getId())+1);
				popularSpecialization.put(appDoctor.getSpecialization(),popularSpecialization.get(appDoctor.getSpecialization())+1);
			} 
			else 
			{
				System.out.println("Doctor is busy!!!!!!!!\n Select some other doctor:");
				getAppointment();
			}
		 }
	}

	public static void showAppointmentDetails()
	{
		  System.out.println("-*-*-*-*-*-*-*-*-*Appointment Report-*-*-*-*-*-*-*\n");
		  
		  if(appointment.size()==0)
		  {
			  System.out.println("No appointments to display");
			  return;
		  }
		  
		  Set<Integer> s=appointment.keySet();
		  
		  for (Integer id : s) 
		  {
			  System.out.println("List of patients appointed for:::::::: "+doctorList.get(id).getName()+":::::::::::::::::::::"); 
			  for (Patient patient : appointment.get(id)) 
			  {
					System.out.format("PATIENT_ID:%2s      Name:%-10s      Age:%-2s      Mobile:%-1s    Desease:%-1s",patient.getId(),patient.getName(),patient.getAge(),patient.getMobileNumber(),patient.getDesease()+"\n\n");
			  } 
		  }
	}
	
	public static void displayDoctor(List<Doctor>doctList)
	{
		for (Doctor doctor : doctList)
		{
			System.out.format("DOCTOR_ID:%2s      Name:%-10s      Speciality:%-10s      Availability:%-1s",doctor.getId(),doctor.getName(),doctor.getSpecialization(),doctor.getAvailability()+"\n\n");
		}
	}
	
	public static void displayPatient(List<Patient>patList)
	{
		for (Patient patient : patList)
		{
			System.out.format("PATIENT_ID:%2s      Name:%-10s      Age:%-2s      Mobile:%-1s    Desease:%-1s",patient.getId(),patient.getName(),patient.getAge(),patient.getMobileNumber(),patient.getDesease()+"\n\n");
		}
	}
	
	public static void menu()
	{
		try
		{
		System.out.println("Enter your choice:\n1.View Doctors\n2.View Patients\n3.Get Appointment\n4.View Appointment Report\n5.Quit");
		char choice=scanner.next().charAt(0);
		
		switch(choice)
		{
		case '1' : displayAllDoctors();
				  System.out.println("Enter your choice: \n1.Search Doctor By Name\n2.Search Doctor By Id\n3.Search Doctor By specialization\n4.Main Menu\n5.Quit");
				  char res=scanner.next().charAt(0);
				  
				  switch(res)
				  {
				    case '1': System.out.println("Enter doctor name: ");
				   			String name=scanner.next();
				   			displayDoctor(getDoctorByName(name));
				   		    System.out.println("Enter your choice:\n1.Main Menu \n2.Quit");	
				   		    char ch1=scanner.next().charAt(0);
				   		    switch(ch1)
				   		    {
				   		    case '1':menu();
				   		    		break;
				   		    case '2': System.exit(0);
				   		    }
				   		    break;
				   		    
				   	   
					 case '2':    System.out.println("Enter doctor id: ");
					   			int did=scanner.nextInt();
					   			System.out.println(getDoctorByID(did));
					   		    System.out.println("Enter your choice:\n1.Main Menu \n2.Quit");	
					   		    char ch2=scanner.next().charAt(0);
					   		    
					   		    switch(ch2)
					   		    {
					   		    case '1':menu();
					   		    		break;
					   		    case '2': System.exit(0);
					   		    }
					   		    break;
					   		    
					   		    
					 case '3':    System.out.println("Enter doctor Specialization: ");
					   			String spec=scanner.next();
					   			displayDoctor(getDoctorBySpecialization(spec));
					   		    System.out.println("Enter your choice:\n1.Main Menu \n2.Quit");	
					   		    char ch3=scanner.next().charAt(0);
					   		    
					   		    switch(ch3)
					   		    {
					   		    case '1':menu();
					   		    		break;
					   		    case '2': System.exit(0);
					   		    }
					   		    break;
					 case '4': menu();
					 		 break;
					 		 
					 case '5': System.exit(0);
					 
					 default: System.out.println("Invalid Input: ");
								 System.out.println("Enter your choice:\n1.Main Menu \n2.Quit");	
						   		    char ch4=scanner.next().charAt(0);
						   		    
						   		    switch(ch4)
						   		    {
						   		    case '1':menu();
						   		    		break;
						   		    case '2': System.exit(0);
						   		    }
						   
				   }
				  break;
		case '2': displayAllPatients();
		  System.out.println("Enter your choice: \n1.Search Patient By Name\n2.Search Patient By Id\n3.Search Patient By mobile\n4.Main Menu\n5.Quit");
		  char res1=scanner.next().charAt(0);
		  
		  switch(res1)
		  {
		    case '1': System.out.println("Enter Patient name: ");
		   			String name=scanner.next();
		   			displayPatient(getPatientByName(name));
		   		    System.out.println("Enter your choice:\n1.Main Menu \n2.Quit");	
		   		    char ch1=scanner.next().charAt(0);
		   		    switch(ch1)
		   		    {
		   		    case '1':menu();
		   		    		break;
		   		    case '2': System.exit(0);
		   		    }
		   		    break;
		   		    
		   	   
			 case '2':    System.out.println("Enter patient id: ");
			   			int pid=scanner.nextInt();
			   			System.out.println(getPatientByID(pid));
			   		    System.out.println("Enter your choice:\n1.Main Menu \n2.Quit");	
			   		    char ch2=scanner.next().charAt(0);
			   		    
			   		    switch(ch2)
			   		    {
			   		    case '1':menu();
			   		    		break;
			   		    case '2': System.exit(0);
			   		    }
			   		    break;
			   		    
			   		    
			 case '3':    System.out.println("Enter Patient Mobile: ");
			   			long mobile=scanner.nextLong();
			   			System.out.println(getPatientByMobile(mobile));
			   		    System.out.println("Enter your choice:\n1.Main Menu \n2.Quit");	
			   		    char ch3=scanner.next().charAt(0);
			   		    
			   		    switch(ch3)
			   		    {
			   		    case '1':menu();
			   		    		break;
			   		    case '2': System.exit(0);
			   		    }
			   		    break;
			 case '4': menu();
			 		 break;
			 		 
			 case '5': System.exit(0);
			 
			 default: System.out.println("Invalid Input: ");
						 System.out.println("Enter your choice:\n1.Main Menu \n2.Quit");	
				   		    char ch4=scanner.next().charAt(0);
				   		    
				   		    switch(ch4)
				   		    {
				   		    case '1':menu();
				   		    		break;
				   		    case '2': System.exit(0);
				   		    }
		   }
		  break;
		case '3': 	displayAllDoctors();
					displayAllPatients();
					getAppointment();
					System.out.println("Enter your choice:\n1.Main Menu \n2.Quit");	
		   		    char ch3=scanner.next().charAt(0);
		   		    
		   		    switch(ch3)
		   		    {
		   		    case '1':menu();
		   		    		break;
		   		    case '2': System.exit(0);
		   		    }
		   		    break;
		   		    
		case '4':  showAppointmentDetails();
				 System.out.println("Enter your choice:\n1.Main Menu \n2.Quit");	
				    char ch4=scanner.next().charAt(0);
				    
				    switch(ch4)
				    {
				    case '1':menu();
				    		break;
				    case '2': System.exit(0);
				    
				    }
				    break;
		case '5':System.exit(0);
		default : System.out.println("Invalid input");
					System.exit(0);
		}		
		}catch (Exception e) 
		{
			System.out.println("Invalid input");
		}
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException 
	{
		
		  getAllDoctors();
		  getAllPatients();
		  
		  menu();
	}
}
