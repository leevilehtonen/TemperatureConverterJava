package com.tempconverterjava.main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class TemperatureConverter implements Runnable {

	// Define variables
	private JFrame mJFrame;
	private TemperatureFormulas mTemperatureFormulas;
	private static final String APP_NAME = "Temperature Converter V1.0";
	private static final int WINDOW_WIDTH = 300;
	private static final int WINDOW_HEIGHT = 300;

	public TemperatureConverter() {

		// Create the class, holding math formulas
		mTemperatureFormulas = new TemperatureFormulas();
	}

	@Override
	public void run() {

		// Create JFrame and assign a title
		mJFrame = new JFrame(APP_NAME);

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

		// Create and set GridBagLayout to container
		GridBagLayout mGridBagLayout = new GridBagLayout();
		container.setLayout(mGridBagLayout);

		// Create constraints to control the layout and adjust them
		GridBagConstraints mConstraints = new GridBagConstraints();
		mConstraints.fill = GridBagConstraints.HORIZONTAL;
		mConstraints.insets = new Insets(10, 10, 10, 10);

		// Create units column header and adjust constraints
		JLabel units = new JLabel("Unit");
		mConstraints.gridx = 0;
		mConstraints.gridy = 0;
		container.add(units, mConstraints);

		// Create values column header and adjust constraints
		JLabel values = new JLabel("Value (xxx.xxx)");
		mConstraints.gridx = 1;
		mConstraints.gridy = 0;
		container.add(values, mConstraints);

		// Create Kelvin row header and adjust constraints
		JLabel kelvin = new JLabel("Kelvin [K]");
		mConstraints.gridx = 0;
		mConstraints.gridy = 1;
		container.add(kelvin, mConstraints);

		// Create Kelvin input and adjust constraints
		JTextField kelvinValue = new JTextField();
		mConstraints.gridx = 1;
		mConstraints.gridy = 1;
		container.add(kelvinValue, mConstraints);

		// Create Celsius row header and adjust constraints
		JLabel celsius = new JLabel("Celsius [°C]");
		mConstraints.gridx = 0;
		mConstraints.gridy = 2;
		container.add(celsius, mConstraints);

		// Create Celsius input and adjust constraints
		JTextField celsiusValue = new JTextField();
		mConstraints.gridx = 1;
		mConstraints.gridy = 2;
		container.add(celsiusValue, mConstraints);

		// Create Fahrenheit row header and adjust constraints
		JLabel fahrenheit = new JLabel("Fahrenheit [°F]");
		mConstraints.gridx = 0;
		mConstraints.gridy = 3;
		container.add(fahrenheit, mConstraints);

		// Create Fahrenheit input and adjust constraints
		JTextField fahrenheitValue = new JTextField();
		mConstraints.gridx = 1;
		mConstraints.gridy = 3;
		container.add(fahrenheitValue, mConstraints);

		// Create reset button and adjust constraints
		JButton reset = new JButton("Reset");
		mConstraints.gridx = 0;
		mConstraints.gridy = 4;
		container.add(reset, mConstraints);

		// Create calculate button and adjust constraints
		JButton calculate = new JButton("Calculate");
		mConstraints.gridx = 1;
		mConstraints.gridy = 4;
		container.add(calculate, mConstraints);

		// Listen to Kelvin value input
		kelvinValue.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {

				if (kelvinValue.getText().isEmpty()) {

					// Allow inputs back to all sections (Read else statement)
					celsiusValue.setEditable(true);
					fahrenheitValue.setEditable(true);

				} else {

					// Disallow double inputs by setting other inputs false
					celsiusValue.setEditable(false);
					fahrenheitValue.setEditable(false);
				}

			}
		});

		// Listen to Celsius value input
		celsiusValue.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {

				// Allow inputs back to all sections (Read else statement)
				if (celsiusValue.getText().isEmpty()) {
					kelvinValue.setEditable(true);
					fahrenheitValue.setEditable(true);

				} else {

					// Disallow double inputs by setting other inputs false
					kelvinValue.setEditable(false);
					fahrenheitValue.setEditable(false);
				}
			}
		});

		// Listen to Fahrenheit value input
		fahrenheitValue.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {

				// Allow inputs back to all sections (Read else statement)
				if (fahrenheitValue.getText().isEmpty()) {
					kelvinValue.setEditable(true);
					celsiusValue.setEditable(true);

				} else {

					// Disallow double inputs by setting other inputs false
					kelvinValue.setEditable(false);
					celsiusValue.setEditable(false);
				}
			}
		});

		// Reset buttons action
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Set every input back to editable
				kelvinValue.setEditable(true);
				celsiusValue.setEditable(true);
				fahrenheitValue.setEditable(true);

				// Clear the inputs
				kelvinValue.setText("");
				celsiusValue.setText("");
				fahrenheitValue.setText("");
			}
		});

		// Calculate button action
		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				// Use try catch block to make sure no false input is given (By
				// handling the exception to a new alert window)
				try {

					// Get the value from the input which is currently editable
					if (kelvinValue.isEditable()) {

						// If Kelvin is the input set Kelvin's value to
						// formula's class variable (Kelvin) and calculate other
						// values using it

						
						mTemperatureFormulas.setKelvin(Float
								.parseFloat(kelvinValue.getText()));

						// TemperatureFormulas class handles the calculations to
						// other units (so using getters assign all the values)
						kelvinValue.setText(mTemperatureFormulas.getKelvin()
								+ " K");
						celsiusValue.setText(mTemperatureFormulas.getCelsius()
								+ " °C");
						fahrenheitValue.setText(mTemperatureFormulas
								.getFahrenheit() + " °F");

					} else if (celsiusValue.isEditable()) {

						// If Celsius is the input set Celsius's value to
						// formula's class variable (Celsius) and calculate
						// other values using it
						mTemperatureFormulas.setCelsius(Float
								.parseFloat(celsiusValue.getText()));

						// TemperatureFormulas class handles the calculations to
						// other units (so using getter assign all the values)

						kelvinValue.setText(mTemperatureFormulas.getKelvin()
								+ " K");
						celsiusValue.setText(mTemperatureFormulas.getCelsius()
								+ " °C");
						fahrenheitValue.setText(mTemperatureFormulas
								.getFahrenheit() + " °F");

					} else if (fahrenheitValue.isEditable()) {

						// If Fahrenheit is the input set Fahrenheit's value to
						// formula's class variable (Fahrenheit) and calculate
						// other values using it
						mTemperatureFormulas.setFahrenheit(Float
								.parseFloat(fahrenheitValue.getText()));

						// TemperatureFormulas class handles the calculations to
						// other units (so using getter assign all the values)
						kelvinValue.setText(mTemperatureFormulas.getKelvin()
								+ " K");
						celsiusValue.setText(mTemperatureFormulas.getCelsius()
								+ " °C");
						fahrenheitValue.setText(mTemperatureFormulas
								.getFahrenheit() + " °F");

					}

				} catch (Exception exception) {

					// Display alert window if false input is give e.g. letters
					// or wrong decimal separator
					JOptionPane
							.showMessageDialog(
									container,
									"Incorrect value \n1. Entry must be a (decimal) number \n2. Decimal separtor is \".\" (Point)");
				}

			}
		});

	}

}
