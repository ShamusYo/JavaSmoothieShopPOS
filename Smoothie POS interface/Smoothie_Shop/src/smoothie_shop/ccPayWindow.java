package smoothie_shop;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ccPayWindow extends JFrame{
	
	SmoothieShop tempShop;
	
	// Objects for GUI
	JDialog javaCCPayFrame = new JDialog();
	
	JLabel cardNumLabel = new JLabel("Enter a 16 digit credit card number");
	JTextField cardNum = new JTextField("", 16);
	
	JLabel cardExpLabel = new JLabel("Enter the expiration date : MMYY");
	JTextField cardExp = new JTextField("", 16);
	
	JLabel cardCVCLabel = new JLabel("Enter the 3 digit cvc number");
	JTextField cardCVC = new JTextField("", 16);
	
	JButton btCCPay = new JButton("Press to Pay");
	
	public ccPayWindow(double totalOwed, SmoothieShop _tempShop) {
		
		tempShop = _tempShop;
		
		Panel numPanel = new Panel(new BorderLayout());
		Panel expPanel = new Panel(new BorderLayout());
		Panel CVCPanel = new Panel(new BorderLayout());
		
		numPanel.add(cardNumLabel, BorderLayout.NORTH);
		numPanel.add(cardNum, BorderLayout.SOUTH);
		
		expPanel.add(cardExpLabel, BorderLayout.NORTH);
		expPanel.add(cardExp, BorderLayout.SOUTH);
		
		CVCPanel.add(cardCVCLabel, BorderLayout.NORTH);
		CVCPanel.add(cardCVC, BorderLayout.CENTER);
		CVCPanel.add(btCCPay, BorderLayout.SOUTH);
		
		btCCPay.setFont(new Font("Serif", Font.BOLD, 20));
		
		btCCPay.addActionListener(new ccFinalPay());
		
		Panel ccFieldPanel = new Panel(new GridLayout(0, 1, 20, 20));
		ccFieldPanel.add(numPanel);
		ccFieldPanel.add(expPanel);
		ccFieldPanel.add(CVCPanel);
		
		javaCCPayFrame.add(ccFieldPanel);
		javaCCPayFrame.pack();
		
		// Make this frame the only interactable frame until disposed of
		javaCCPayFrame.setModal(true);
		
		javaCCPayFrame.setLocationRelativeTo(null);
		javaCCPayFrame.setVisible(true);
	}
	
	class ccFinalPay implements ActionListener {
		public void actionPerformed(ActionEvent click) {
			
			// Check fields for valid input
			
			/* DO NOT IMPLEMENT:
			 * if this was actually a real product we would check credit card
			 * details online to confirm validity
			 */
			
			// Calculate change
			
			tempShop.reset();
			// Deconstruct the payment window
			javaCCPayFrame.dispose();
		}
	}
}
