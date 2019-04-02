package smoothie_shop;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cashPayWindow extends JFrame{
	
	static public Double owed;
	
	public SmoothieShop tempShop;
	
	// Objects for GUI
	JDialog javaCashPayFrame = new JDialog();
	
	JLabel cashValLabel = new JLabel("Enter cash amount paid");
	JTextField cashNum = new JTextField("");

	JButton btCashPay = new JButton("Press to Pay");
	
	public cashPayWindow(double totalOwed, SmoothieShop _tempShop) {
		
		owed = totalOwed;
		tempShop = _tempShop;
		
		Panel numCashPanel = new Panel(new BorderLayout());
		
		numCashPanel.add(cashValLabel, BorderLayout.NORTH);
		numCashPanel.add(cashNum, BorderLayout.CENTER);
		numCashPanel.add(btCashPay, BorderLayout.SOUTH);
		
		btCashPay.setFont(new Font("Serif", Font.BOLD, 20));
		
		btCashPay.addActionListener(new cashFinalPay());
		
		javaCashPayFrame.add(numCashPanel);
		javaCashPayFrame.pack();
		
		// Make this frame the only interactable frame until disposed of
		javaCashPayFrame.setModal(true);
		
		javaCashPayFrame.setLocationRelativeTo(null);
		javaCashPayFrame.setVisible(true);
	}
	
	class cashFinalPay implements ActionListener {
		public void actionPerformed(ActionEvent click) {
			
			// Check for valid input ??ioexception??
			
			// Parse text and convert to a double
			double paidAmount = Double.parseDouble(cashNum.getText());
			
			// Call function to calculate change
			Double change = calculateChange(paidAmount);
			
			// Display change and exit message
			new ChangeWindow(change, tempShop);
			
			// For now deconstruct the window
			javaCashPayFrame.dispose(); 
			
		}
	}
	
	public double calculateChange(double paid) {
		return (paid = (paid - owed));
	}
}
