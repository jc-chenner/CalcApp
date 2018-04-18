package CalcApp;

/**@author Jingchi Chen 
* @version 1.0
* @since 21/03/2018
*/

public class CalculatorMain {
	
	/**
	 * Initializes Calculator 
	 * @param args
	 */
	public static void main(String args[]) {
	CalculatorModel calcmodel = new CalculatorModel();
	CalculatorView calcview = new CalculatorView(calcmodel);
	
	
	calcview.setVisible(true);
	}
}
