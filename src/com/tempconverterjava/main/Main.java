package com.tempconverterjava.main;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		TemperatureConverter mTemperatureConverter = new TemperatureConverter();
		SwingUtilities.invokeLater(mTemperatureConverter);
	}

}
