package smoothie_shop;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

public class gcPayWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	// Objects for GUI
	private JFrame javaGCPayFrame = new JFrame("Gift Card Payment");
	
	private Label gcNumLabel = new Label("Enter the 12 digit gift card number");
	private TextField gcNum = new TextField("", 16);
	
	private Button btGCPay = new Button("Press to Pay");
	
	public gcPayWindow() {
		
		Panel numGCPanel = new Panel(new BorderLayout());
		
		numGCPanel.add(gcNumLabel, BorderLayout.NORTH);
		numGCPanel.add(gcNum, BorderLayout.CENTER);
		numGCPanel.add(btGCPay, BorderLayout.SOUTH);
		
		btGCPay.addActionListener(new gcFinalPay());
		
		javaGCPayFrame.add(numGCPanel);
		javaGCPayFrame.pack();
		
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
			
			// Deconstruct the payment window
			javaGCPayFrame.dispose();
		}
	}
}
