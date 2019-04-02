package smoothie_shop;

import java.lang.Math;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

/* Author:				Shamus French
 * Creation Date:		20190325
 * Last Date Modified: 	20190401
 */



public class SmoothieShop {
	
	public static double preTaxTotal = 0;
	public static double postTaxTotal = 0;
	public static double change = 0;
	
	SmoothieShop tempShop;
	
	/* Objects for the GUI */
	JFrame javaFrame = new JFrame("Cyber Smoothie");
	
	JLabel welcomeLabel = new JLabel("Welcome to Cyber Smoothie!", SwingConstants.CENTER);
	JButton btStOrder = new JButton("Start New Order");
	
	JLabel typeLabel = new JLabel("What type of smoothie would you like?", SwingConstants.CENTER);
	String [] smooth;
	JComboBox smoothieType;
	
	JLabel sizeLabel = new JLabel("What size would you like?", SwingConstants.CENTER);
	String [] size;
	JComboBox sizeType;
	
	JLabel sweetenerLabel = new JLabel("What type of sweetener would you like?", SwingConstants.CENTER);
	String [] sweetener;
	JComboBox sweetType;
	
	JButton btAdd = new JButton("Add current smoothie to order");
	
	JLabel ordSumLabel = new JLabel("Order Summary");
	TextArea orderSummary = new TextArea();
	JTextField total = new JTextField("", 60);
	
	JLabel payLabel = new JLabel("How would you like to pay?", SwingConstants.CENTER);
	JButton btPayProc = new JButton("Proceed to Payment");
	String [] payment;
	JComboBox paymentType;
	
	// Create an object of each class to call from
	AcaiBerrySmoothie acaiBerrySmoothie = new AcaiBerrySmoothie();
	StrawberrySmoothie strawberrySmoothie = new StrawberrySmoothie();
	BananaSmoothie bananaSmoothie = new BananaSmoothie();
	
	/* Create a new SmoothieClient window */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public SmoothieShop() {		
		
		/* Format the text font and size */
		welcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));
		typeLabel.setFont(new Font("Serif", Font.BOLD, 20));
		sizeLabel.setFont(new Font("Serif", Font.BOLD, 20));
		sweetenerLabel.setFont(new Font("Serif", Font.BOLD, 20));
		payLabel.setFont(new Font("Serif", Font.BOLD, 20));
		
		/* Create the panel for holding all fields*/
		Panel startPanel = new Panel(new BorderLayout());
		Panel typePanel = new Panel(new GridLayout(1, 2, 20, 20));
		Panel sizePanel = new Panel(new GridLayout(1, 2, 20, 20));
		Panel sweetenerPanel = new Panel(new GridLayout(1, 2, 20, 20));
		Panel ordSumPanel = new Panel(new BorderLayout());
		Panel addPanel = new Panel(new BorderLayout());
		Panel paymentPanel = new Panel(new GridLayout(0, 1, 0, 20));
		Panel endPanel =  new Panel(new BorderLayout());
		
		/* Put together the GUI objects into panels */
		startPanel.add(welcomeLabel, BorderLayout.CENTER);
		
		typePanel.add(typeLabel, BorderLayout.NORTH);
		smooth = new String[] {"Acai Berry smoothie", "Strawberry smoothie", "Banana smoothie"};
		smoothieType = new JComboBox(smooth);
		((JLabel)smoothieType.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		typePanel.add(smoothieType, BorderLayout.SOUTH);
		
		sizePanel.add(sizeLabel, BorderLayout.NORTH);
		size = new String[] {"Large", "Medium", "Small"};
		sizeType = new JComboBox(size);
		((JLabel)sizeType.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		sizePanel.add(sizeType, BorderLayout.SOUTH);
		
		sweetenerPanel.add(sweetenerLabel, BorderLayout.NORTH);
		sweetener = new String[] {"Sugar", "Splenda", "No Sweetener"};
		sweetType = new JComboBox(sweetener);
		((JLabel)sweetType.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		sweetenerPanel.add(sweetType, BorderLayout.SOUTH);
		
		addPanel.add(btAdd, BorderLayout.CENTER);

		ordSumPanel.add(ordSumLabel, BorderLayout.NORTH);
		ordSumPanel.add(orderSummary, BorderLayout.CENTER);
		ordSumPanel.add(total, BorderLayout.SOUTH);
		
		payment = new String[] {"Credit Card", "Gift Card", "Cash"};
		paymentType = new JComboBox(payment);
		((JLabel)paymentType.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		paymentPanel.add(payLabel, BorderLayout.WEST);
		paymentPanel.add(paymentType, BorderLayout.EAST);
		paymentPanel.add(btPayProc, BorderLayout.SOUTH);

		endPanel.add(btStOrder);
		
		/* Put together the separate panels into the fieldFramePanel */
		JPanel fieldFramePanel = new JPanel(new GridLayout(0, 1, 1, 1));
		fieldFramePanel.add(startPanel);
		fieldFramePanel.add(typePanel);
		fieldFramePanel.add(sizePanel);
		fieldFramePanel.add(sweetenerPanel);
		fieldFramePanel.add(addPanel);
		fieldFramePanel.add(endPanel);

		/* Put the higher level panels into the main javaFrame */
		javaFrame.add(fieldFramePanel, BorderLayout.NORTH);
		javaFrame.add(ordSumPanel, BorderLayout.CENTER);
		javaFrame.add(paymentPanel, BorderLayout.SOUTH);
		
		btAdd.setFont(new Font("Serif", Font.BOLD, 18));
		btStOrder.setFont(new Font("Serif", Font.BOLD, 18));
		btPayProc.setFont(new Font("Serif", Font.BOLD, 20));
		
		/* Attach the action listeners to the buttons */
		btAdd.addActionListener(new AddSmoothieListener());
		btStOrder.addActionListener(new NewOrderListener());
		btPayProc.addActionListener(new PayListener());
		
		/* Close the window when close icon of the window is clicked */
		javaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Make the text areas not editable */
		total.setEditable(false);
		orderSummary.setEditable(false);

		javaFrame.pack();
		javaFrame.setLocationRelativeTo(null);
		javaFrame.setVisible(true);
	
		/* declare and define variable to pass be able to pass this object */
		tempShop = this;
	}
	
	/* Resets the main frame to prepare for a new order */
	public void reset() {
		orderSummary.setText("");
		total.setText("");
		preTaxTotal = 0;
		postTaxTotal = 0;
		
		javaFrame.revalidate();
	}
	
	/* Event listener, attached to btStOrder; Resets the main frame to prepare for a new order  */
	class NewOrderListener implements ActionListener {
		public void actionPerformed(ActionEvent click) {
			orderSummary.setText("");
			total.setText("");
			preTaxTotal = 0;
			postTaxTotal = 0;
			
			javaFrame.revalidate();
		}
	}

	/* Event listener, attached to btAdd; Adds the current smoothie selections 
	 * to the order summary and updates total cost */
	class AddSmoothieListener implements ActionListener {
		public void actionPerformed(ActionEvent click) {
			String currentSmoothie = "";
			String currentSize = "";
			String currentSweetener = "";
		
			/* Set the smoothie size */
			if (sizeType.getSelectedItem() == size[0]) {
				currentSize = size[0];
			}
			if (sizeType.getSelectedItem() == size[1]) {
				currentSize = size[1];
			}
			if (sizeType.getSelectedItem() == size[2]) {
				currentSize = size[2];
			}
			
			/* Set the sweetener type */
			if (sweetType.getSelectedItem() == sweetener[0]) {
				currentSweetener = sweetener[0];
			}
			if (sweetType.getSelectedItem() == sweetener[1]) {
				currentSweetener = sweetener[1];
			}
			if (sweetType.getSelectedItem() == sweetener[2]) {
				currentSweetener = sweetener[2];
			}
			
			/* Set the smoothie type;  
			 * Update preTaxTotal */
			if (smoothieType.getSelectedItem() == smooth[0]) {
				currentSmoothie = acaiBerrySmoothie.getDescription();
				currentSmoothie += (acaiBerrySmoothie.cost(currentSize) + "\r\n");
				preTaxTotal += acaiBerrySmoothie.cost(currentSize);
			}
			if (smoothieType.getSelectedItem() == smooth[1]) {
				currentSmoothie = strawberrySmoothie.getDescription();
				currentSmoothie += (strawberrySmoothie.cost(currentSize) + "\r\n");
				preTaxTotal += strawberrySmoothie.cost(currentSize);
			}
			if (smoothieType.getSelectedItem() == smooth[2]) {
				currentSmoothie = bananaSmoothie.getDescription();
				currentSmoothie += (bananaSmoothie.cost(currentSize) + "\r\n");
				preTaxTotal += bananaSmoothie.cost(currentSize);
			}
			
			/* Add smoothie to orderSummary */
			orderSummary.setEditable(true);
			orderSummary.append(currentSize + currentSmoothie);
			orderSummary.append("           (" + currentSweetener + ")\r\n");
			orderSummary.append("\r\n");
			orderSummary.setEditable(false);
			
			/* Update postTaxTotal */
			postTaxTotal = addTax(preTaxTotal);
			DecimalFormat pTT = new DecimalFormat("#.00");
			String s = pTT.format(postTaxTotal);
			total.setEditable(true);
			total.setText("Total w/ tax =          $ " + s);
			total.setEditable(false);
			
			/*  */
			javaFrame.revalidate();
		}
	}
	
	class PayListener implements ActionListener {
		public void actionPerformed(ActionEvent click) {
			
			if (paymentType.getSelectedItem() == payment[0]) {
				
				// Construct cc payment window
				new ccPayWindow(postTaxTotal, tempShop);
			}
			if (paymentType.getSelectedItem() == payment[1]) {
				
				// Construct gc payment window
				new gcPayWindow(postTaxTotal, tempShop);
			}
			if (paymentType.getSelectedItem() == payment[2]) {
				
				// Construct cash payment window
				new cashPayWindow(postTaxTotal, tempShop);
			}
		}
	}
	
	// add comment
	static public void main(String argv[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 SmoothieShop smoothieShop = new SmoothieShop(); // Let the constructor do the job
	         }
	      });
	}
	
	// add comment
	public double addTax(double total) {
		total = (total * 1.06);
		total = Math.round(total * 100.00) / 100.00;
		return total;
	}
}

