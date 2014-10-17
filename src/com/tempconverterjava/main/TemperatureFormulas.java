package com.tempconverterjava.main;

public class TemperatureFormulas {

	// Define variables
	private float kelvin;
	private float celsius;
	private float fahrenheit;

	public TemperatureFormulas() {

		// Initialize variables to 0
		this.kelvin = 0;
		this.celsius = 0;
		this.fahrenheit = 0;
	}

	public float getKelvin() {

		// Getter for Kelvin
		return kelvin;
	}

	public void setKelvin(float kelvin) {

		// Calculation methods when Kelvin is known
		this.kelvin = kelvin;
		this.celsius = kelvin - 273.15f;
		this.fahrenheit = kelvin * (9f / 5f) - 459.6f;
	}

	public float getCelsius() {

		// Getter for Celsius
		return celsius;
	}

	public void setCelsius(float celsius) {

		// Calculation methods when Celsius is known
		this.celsius = celsius;
		this.kelvin = celsius + 273.15f;
		this.fahrenheit = celsius * (9f / 5f) + 32;
	}

	public float getFahrenheit() {

		// Getter for Fahrenheit
		return fahrenheit;
	}

	public void setFahrenheit(float fahrenheit) {

		// Calculation methods when Fahrenheit is known
		this.fahrenheit = fahrenheit;
		this.kelvin = (fahrenheit + 459.67f) * (5f / 9f);
		this.celsius = (fahrenheit - 32) * (5f / 9f);
	}

}
