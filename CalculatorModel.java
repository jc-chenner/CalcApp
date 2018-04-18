package CalcApp;

/**@author Jingchi Chen 
* @version 1.0
* @since 22/03/2018
*/

import java.io.*;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


@SuppressWarnings("serial")
public class CalculatorModel{
	
	private String inputValue = "";
	private double outputValue;
	
	
	//------------------------------------------------------
	/**
	 * getter for output panel (panel 2)
	 * @return second panel value
	 */
	public double getOuputValue() {
		return outputValue;
	}
	
	/**
	 * setter for output panel (panel 2)
	 */
	public void setOutputValue(double out) {
		this.outputValue = out;
	}
	
	/**
	 * getter for input panel (panel 1)
	 * @return first panel value
	 */
	public String getInputValue() {
		return inputValue;
	}
	
	/**
	 * setter for input panel (panel 1)
	 * updates first panel
	 */
	public void setInputValue(String s) {
		this.inputValue = this.inputValue + s;
	}
	//----------------------------------------------------------
	//Model Methods 
	
	
	/**
	 * clears input box
	 */
	public void clearInput() {
		this.inputValue = "";
	}
	
	/**
	 * calculates output given string "inputValue"
	 */
	public void calculate() {
		double out = 0.0;
		//error handler for improper user input
		try {
			String num1 = "";
			String num2 = "";
			String op = "";
			int i = 0;
			
			//seperates two numbers and operator
			String[] parts = this.getInputValue().split("");
			while(i <= parts.length - 1) {
				if(parts[i].equals("+") | parts[i].equals("-") | parts[i].equals("*")
						| parts[i].equals("/")) {
					op = parts[i];
					i += 1;
					break;
				}else {
				num1 = num1 + parts[i];
				i += 1;
				}
			}
			
			while(i <= parts.length - 1) {
				num2 = num2 + parts[i];
				i += 1;
			}
			
			//converts string to double 
			double n1 = Double.parseDouble(num1);
			double n2 = Double.parseDouble(num2);
			
			
			//calculates output "out"
			if(op.equals("+")) {
				out = n1 + n2;
			}else if(op.equals("-")) {
				out = n1 - n2;
			}else if(op.equals("*")) {
				out = n1 * n2;
			}else if(op.equals("/")) {
				out = n1 / n2;
			}
			
			//updates output
			this.setOutputValue(out);
		}catch (Exception e) {
			this.setOutputValue(0.0);
		}
		
	}
	
	
}
