package com.bridgelabz.designPatterns.proxyDP;

public class RealInternet implements Internet {

	@Override
	public void connectTo(String serverhost) {
		System.out.println("Connecting....."+serverhost);
		
	}

}
