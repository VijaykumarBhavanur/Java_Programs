package com.bridgelabz.designPatterns.AdapterDP;

public class CelciusReporter 
{
	double temperatureInC;
	
	public CelciusReporter()
	{
		
	}
	public void setTemperature(double temperatureInC)
	{
		this.temperatureInC = temperatureInC;
	}
	public double getTemperature() 
	{
		return temperatureInC;
	}
}