package smoothie_shop;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

public class ccPayWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	// Objects for GUI
	private JFrame javaCCPayFrame = new JFrame("Credit Card Payment");
	
	private Label cardNumLabel = new Label("Enter a 16 digit credit card number");
	private TextField cardNum = new TextField("", 16);
	
	private Label cardExpLabel = new Label("Enter the expiration date : MMYY");
	private TextField cardExp = new TextField("", 16);
	
	private Label cardCVCLabel = new Label("Enter the 3 digit cvc number");
	private TextField cardCVC = new TextField("", 16);
	
	private Button btCCPay = new Button("Press to Pay");
	
	public ccPayWindow() {
		
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
		
		btCCPay.addActionListener(new ccFinalPay());
		
		Panel ccFieldPanel = new Panel(new GridLayout(0, 1, 20, 20));
		ccFieldPanel.add(numPanel);
		ccFieldPanel.add(expPanel);
		ccFieldPanel.add(CVCPanel);
		
		javaCCPayFrame.add(ccFieldPanel);
		javaCCPayFrame.pack();
		
		
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
			
			// Deconstruct the payment window
			javaCCPayFrame.dispose();
		}
	}
}
