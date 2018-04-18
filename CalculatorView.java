package CalcApp;

/**@author Jingchi Chen 
* @version 1.0
* @since 21/03/2018
*/


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;


@SuppressWarnings("serial")


/**
 *Generates View/GUI
 */
public class CalculatorView extends JFrame {
	
	/**
	 *Listener class for number buttons
	 */
	private class inputListener implements ActionListener{
		String input = "";
		
		public inputListener(final String input) {
			this.input = input;
		}
		
	@Override
	/**
	 * Implements methods in listener interface
	 * @param ActionEvent action event
	 */
	public void actionPerformed(final ActionEvent e) {
		
		//sends values to Model class
		if(e.getSource()== number1)
            CalculatorView.this.model.setInputValue("1");
        
        if(e.getSource()== number2)
        	CalculatorView.this.model.setInputValue("2");
        
        if(e.getSource()== number3)
        	CalculatorView.this.model.setInputValue("3");
        
        if(e.getSource()== number4)
        	CalculatorView.this.model.setInputValue("4");
        
        if(e.getSource()== number5)
        	CalculatorView.this.model.setInputValue("5");
        
        if(e.getSource()== number6)
        	CalculatorView.this.model.setInputValue("6");
        
        if(e.getSource()== number7)
        	CalculatorView.this.model.setInputValue("7");
        
        if(e.getSource()== number8)
        	CalculatorView.this.model.setInputValue("8");
        
        if(e.getSource()== number9)
        	CalculatorView.this.model.setInputValue("9");
        
        if(e.getSource() == number0)
        	CalculatorView.this.model.setInputValue("0");
        
        // --------------------------------------------------
        //operators
        if(e.getSource() == addbutton)
        	CalculatorView.this.model.setInputValue("+");
        
        if(e.getSource() == subtractbutton)
        	CalculatorView.this.model.setInputValue("-");
        
        if(e.getSource() == multiplybutton)
        	CalculatorView.this.model.setInputValue("*");
        
        if(e.getSource() == dividebutton)
        	CalculatorView.this.model.setInputValue("/");
        
        if(e.getSource() == expbutton)
        	CalculatorView.this.model.setInputValue("^");
        
        //updates input panel when action occurs
		CalculatorView.this.input.setText(CalculatorView.this.model.getInputValue());
	}
	}
	//-------------------------------------------------------------------------------
	/**
	 *listener class for "=" button
	 */
	private class calculateListener implements ActionListener{
			
		public calculateListener() {
		}
		
	@Override
	/**
	 * implements Model modules when "=" is clicked
	 *@param ActionEvent action event
	 */
	public void actionPerformed(final ActionEvent e) {
		if(e.getSource() == equalsbutton)
        	CalculatorView.this.model.calculate();
        	CalculatorView.this.output.setText(
        			Double.toString(CalculatorView.this.model.getOuputValue()));
		}
	}
	
	//-------------------------------------------------------------------------------
	
	/**
	 *listener class for clear button
	 */
	private class clearListener implements ActionListener{
				
			public clearListener() {
			}
		
		
		@Override
		/**
		 * implements Model modules when clear is clicked
		 *@param ActionEvent action event
		 */
		public void actionPerformed(final ActionEvent e) {
			if(e.getSource() == clearbutton)
	        	CalculatorView.this.model.clearInput();
				
			CalculatorView.this.input.setText(CalculatorView.this.model.getInputValue());
			CalculatorView.this.output.setText("");
			}
		}
	
	// ------------------------------------------------------------------
	private final CalculatorModel model;
	
	JPanel buttonPanel = new JPanel();
	JPanel buttonPanel2 = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel outputPanel = new JPanel();
	
	private JLabel input = new JLabel("");
	private JLabel output = new JLabel("");
	
	//number buttons
	private JButton number1 = new JButton("1");
	private JButton number2 = new JButton("2");
	private JButton number3 = new JButton("3");
	private JButton number4 = new JButton("4");
	private JButton number5 = new JButton("5");
	private JButton number6 = new JButton("6");
	private JButton number7 = new JButton("7");
	private JButton number8 = new JButton("8");
	private JButton number9 = new JButton("9");
	private JButton number0 = new JButton("0");
	
	//operator buttons
	private JButton addbutton = new JButton("+");
	private JButton subtractbutton = new JButton("-");
	private JButton multiplybutton = new JButton("*");
	private JButton dividebutton = new JButton("/");
	private JButton expbutton = new JButton("^");
	
	private JButton clearbutton = new JButton("C");
	private JButton equalsbutton = new JButton("=");
	
	// -----------------------------------------------------
	/**
	 * Calculator Constructor
	 * @param model model object
	 */
	CalculatorView(CalculatorModel model){
		
		super("Calculator");
		
		this.model = model;
		
		//Button Panel
		buttonPanel.setLayout(new GridLayout(2,5));
		buttonPanel.add(number7);
		buttonPanel.add(number8);
		buttonPanel.add(number9);
		buttonPanel.add(dividebutton);
		buttonPanel.add(clearbutton);
		
		buttonPanel.add(number4);
		buttonPanel.add(number5);
		buttonPanel.add(number6);
		buttonPanel.add(multiplybutton);
		buttonPanel.add(new JButton());
		
		buttonPanel2.setLayout(new GridLayout(2,5));
		buttonPanel2.add(number1);
		buttonPanel2.add(number2);
		buttonPanel2.add(number3);
		buttonPanel2.add(subtractbutton);
		buttonPanel2.add(new JButton());
		
		buttonPanel2.add(new JButton());
		buttonPanel2.add(number0);
		buttonPanel2.add(new JButton());
		buttonPanel2.add(addbutton);
		buttonPanel2.add(equalsbutton);
		
		//Input/Output Panels
		inputPanel.add(input);
		outputPanel.add(output);
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		outputPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//adds Panels to JFrame
		this.setLayout(new GridLayout(4,1));
		
		this.add(inputPanel);
		this.add(outputPanel);
		this.add(buttonPanel);
		this.add(buttonPanel2);
		
		this.registerListeners();
		
		
		this.setPreferredSize(new Dimension(400,400));
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	// -------------------------------------------------
	/**
	 * Registers listeners for all buttons
	 */
	private void registerListeners() {
		this.number1.addActionListener(new inputListener("1"));
		this.number2.addActionListener(new inputListener("2"));
		this.number3.addActionListener(new inputListener("3"));
		this.number4.addActionListener(new inputListener("4"));
		this.number5.addActionListener(new inputListener("5"));
		this.number6.addActionListener(new inputListener("6"));
		this.number7.addActionListener(new inputListener("7"));
		this.number8.addActionListener(new inputListener("8"));
		this.number9.addActionListener(new inputListener("9"));
		this.number0.addActionListener(new inputListener("0"));
		
		this.addbutton.addActionListener(new inputListener("+"));
		this.subtractbutton.addActionListener(new inputListener("-"));
		this.multiplybutton.addActionListener(new inputListener("*"));
		this.dividebutton.addActionListener(new inputListener("/"));
		this.equalsbutton.addActionListener(new calculateListener());
		this.clearbutton.addActionListener(new clearListener());
		
	}
	
	
	
}

