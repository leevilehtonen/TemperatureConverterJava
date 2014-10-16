package com.tempconverterjava.main;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TemperatureConverter implements Runnable {

	// Define variables
	private JFrame mJFrame;
	private TemperatureFormulas mTemperatureFormulas;
	private static final int WINDOW_WIDTH = 300;
	private static final int WINDOW_HEIGHT = 500;

	public TemperatureConverter() {

		// Create the class, holding math formulas
		mTemperatureFormulas = new TemperatureFormulas();
	}

	@Override
	public void run() {

		// Create JFrame and assign a title
		mJFrame = new JFrame("Temperature Converter V1.0");

		// Set the close operation
		mJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Set the window size
		mJFrame.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

		// Create the components to show in JFrame
		createComponents(mJFrame.getContentPane());

		// Pack the JFrame
		mJFrame.pack();

		// Set the JFrame visible
		mJFrame.setVisible(true);

		// Center the JFrame using relative location to null
		mJFrame.setLocationRelativeTo(null);

	}

	private void createComponents(Container container) {

	}

}
