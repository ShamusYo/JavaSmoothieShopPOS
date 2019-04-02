package smoothie_shop;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gcPayWindow extends JFrame{
	
	public SmoothieShop tempShop;
	
	// Objects for GUI
	JDialog javaGCPayFrame = new JDialog();
	
	JLabel gcNumLabel = new JLabel("Enter the 12 digit gift card number");
	JTextField gcNum = new JTextField("", 16);
	
	JButton btGCPay = new JButton("Press to Pay");
	
	public gcPayWindow(double totalOwed, SmoothieShop _tempShop) {
		
		tempShop = _tempShop;
		
		Panel numGCPanel = new Panel(new BorderLayout());
		
		numGCPanel.add(gcNumLabel, BorderLayout.NORTH);
		numGCPanel.add(gcNum, BorderLayout.CENTER);
		numGCPanel.add(btGCPay, BorderLayout.SOUTH);
		
		btGCPay.setFont(new Font("Serif", Font.BOLD, 20));
		
		btGCPay.addActionListener(new gcFinalPay());
		
		javaGCPayFrame.add(numGCPanel);
		javaGCPayFrame.pack();
		
		// Make this frame the only interactable frame until disposed of
		javaGCPayFrame.setModal(true);
		
		javaGCPayFrame.setLocationRelativeTo(null);
		javaGCPayFrame.setVisible(true);
	}

	class gcFinalPay implements ActionListener {
		public void actionPerformed(ActionEvent click) {
			
			// Check fields for valid input
			
			/* Check input against database
			 * get card value
			 * calculate new card value
			 * update new card value in database
			 * display new card value on screen
			 */
			
			// FIXME:: update this after Martin finishes gift card database stuff
			tempShop.reset();
			
			// Deconstruct the payment window
			javaGCPayFrame.dispose();
		}
	}
}
