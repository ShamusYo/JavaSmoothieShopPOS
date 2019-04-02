package smoothie_shop;

import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

public class ChangeWindow {
	
	SmoothieShop tempShop;
	
	boolean saleComplete;
	
	// Objects for GUI
	JDialog payExitFrame = new JDialog();
	
	JLabel changeMessage = new JLabel("Your change is    ");
	JTextField changeNum = new JTextField("");

	JButton btChangeConfirm = new JButton("                    Proceed?                    ");
	
	public ChangeWindow(Double change, SmoothieShop _tempShop) {
		
		tempShop = _tempShop;
		
		Panel numCashPanel = new Panel(new BorderLayout());
		
		numCashPanel.add(changeMessage, BorderLayout.NORTH);
		numCashPanel.add(changeNum, BorderLayout.CENTER);
		numCashPanel.add(btChangeConfirm, BorderLayout.SOUTH);

		btChangeConfirm.addActionListener(new changeConfirm());
		
		payExitFrame.add(numCashPanel);
		payExitFrame.pack();
		
		if (change >= 0) {
			DecimalFormat pTT = new DecimalFormat("#.00");
			String changeDec = pTT.format(change);
			
			JTextArea goodbye = new JTextArea(5, 20);
			goodbye.setText("\r\nThank you for choosing Cyber Cmoothie! \r\n"
					+ "\r\n                      Come Again!");
			payExitFrame.add(goodbye, BorderLayout.SOUTH);
			payExitFrame.pack();
			goodbye.setEditable(false);
			
			changeNum.setText("$ " + changeDec);
			changeNum.setEditable(false);
			
			saleComplete = true;
			
			//SmoothieShop.saleComplete = true;
		} else {
			DecimalFormat pTT = new DecimalFormat("#.00");
			String changeDec = pTT.format(Math.abs(change));
			
			btChangeConfirm.setText("                    Go Back?                    ");
			
			changeMessage.setText("NOT ENOUGH, you are short");
			changeNum.setText(changeDec);
			changeNum.setEditable(false);
		}
		
		// Make this frame the only interactable frame until disposed of
		payExitFrame.setModal(true);
		
		payExitFrame.setLocationRelativeTo(null);
		payExitFrame.setVisible(true);
	}
	
	class changeConfirm implements ActionListener {
		public void actionPerformed(ActionEvent click) {
			if (saleComplete) {
				tempShop.reset();
			}
			payExitFrame.dispose();
		}
	}
}
