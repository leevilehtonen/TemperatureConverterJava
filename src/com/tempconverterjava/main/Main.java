package com.tempconverterjava.main;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		//Create TemperatureConverter class 
		TemperatureConverter mTemperatureConverter = new TemperatureConverter();
		
		//TemperatureConverter class implements runnable -> invokeLater 
		SwingUtilities.invokeLater(mTemperatureConverter);
	}

}
