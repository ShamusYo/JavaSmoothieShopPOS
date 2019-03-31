package smoothie_shop;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

public class cashPayWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	// Objects for GUI
	private JFrame javaCashPayFrame = new JFrame("Cash Payment");
	
	private Label cashValLabel = new Label("Enter cash amount paid");
	private TextField cashNum = new TextField("", 16);

	private Button btCashPay = new Button("Press to Pay");
	
	public cashPayWindow() {
		Panel numCashPanel = new Panel(new BorderLayout());
		
		numCashPanel.add(cashValLabel, BorderLayout.NORTH);
		numCashPanel.add(cashNum, BorderLayout.CENTER);
		numCashPanel.add(btCashPay, BorderLayout.SOUTH);
		
		btCashPay.addActionListener(new cashFinalPay());
		
		javaCashPayFrame.add(numCashPanel);
		javaCashPayFrame.pack();
		
		javaCashPayFrame.setLocationRelativeTo(null);
		javaCashPayFrame.setVisible(true);
	}
	
	class cashFinalPay implements ActionListener {
		public void actionPerformed(ActionEvent click) {
			
			// Check for valid input
			
			// Call function to calculate amount owed
			
			// Display amount owed
			
			// Display an exit message 
			
			/* FIXME:: add a timer that deconstructs the window after 
			 * displaying an exit message for 10 seconds
			 */
			
			// For now deconstruct the window
			javaCashPayFrame.dispose(); 
		}
	}
	
}
