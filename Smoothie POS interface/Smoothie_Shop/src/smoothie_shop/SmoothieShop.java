package smoothie_shop;

import java.lang.Math;
import java.text.DecimalFormat;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

/* Author:				Shamus French
 * Creation Date:		20190325
 * Last Date Modified: 	20190327
 */

public class SmoothieShop extends Frame {
	private static final long serialVersionUID = 1L;
	
	public static double preTaxTotal = 0;
	public static double postTaxTotal = 0;
	
	/* Objects for the GUI */
	private JFrame javaFrame = new JFrame("Cyber Smoothie");
	
	private Label welcomeLabel = new Label("Welcome to Cyber Smoothie!");
	private Button btStOrder = new Button("Start New Order");
	
	private Label typeLabel = new Label("What type of smoothie would you like?");
	private String [] smooth;
	private JComboBox smoothieType;
	
	private Label sizeLabel = new Label("What size would you like?");
	private String [] size;
	private JComboBox sizeType;
	
	private Label sweetenerLabel = new Label("What kind of sweetener would you like?");
	private String [] sweetener;
	private JComboBox sweetType;
	
	private Label fruitLabel = new Label("Would you like to add a fruit?");
	private String [] fruit;
	private JComboBox fruitType;
	
	private Button btAdd = new Button("Add current smoothie to order");
	
	private Label ordSumLabel = new Label("Order Summary");
	private TextArea orderSummary = new TextArea(10, 40);
	private TextField total = new TextField("", 60);
	
	private Button btPayProc = new Button("Proceed to Payment");
	private String [] payment;
	private JComboBox paymentType;
	
	// add comment
	AcaiBerrySmoothie acaiBerrySmoothie = new AcaiBerrySmoothie();
	StrawberrySmoothie strawberrySmoothie = new StrawberrySmoothie();
	BananaSmoothie bananaSmoothie = new BananaSmoothie();
	
	/* Create a new SmoothieClient window */
	@SuppressWarnings({ "deprecation", "unchecked" })
	
	public SmoothieShop() {
		super("Cyber Smoothie client");
		
		/* Create the panel for holding all fields*/
		Panel startPanel = new Panel(new BorderLayout());
		Panel typePanel = new Panel(new BorderLayout());
		Panel sizePanel = new Panel(new BorderLayout());
		Panel sweetenerPanel = new Panel(new BorderLayout());
		Panel fruitPanel = new Panel(new BorderLayout());
		Panel ordSumPanel = new Panel(new BorderLayout());
		Panel addPanel = new Panel(new BorderLayout());
		Panel paymentPanel = new Panel(new BorderLayout());
		
		// add comment
		startPanel.add(welcomeLabel, BorderLayout.CENTER);
		startPanel.add(btStOrder, BorderLayout.SOUTH);
		
		typePanel.add(typeLabel, BorderLayout.NORTH);
		smooth = new String[] {"Acai Berry smoothie", "Strawberry smoothie", "Banana smoothie"};
		smoothieType = new JComboBox(smooth);
		typePanel.add(smoothieType, BorderLayout.SOUTH);
		
		sizePanel.add(sizeLabel, BorderLayout.NORTH);
		size = new String[] {"Large", "Medium", "Small"};
		sizeType = new JComboBox(size);
		sizePanel.add(sizeType, BorderLayout.SOUTH);
		
		sweetenerPanel.add(sweetenerLabel, BorderLayout.NORTH);
		sweetener = new String[] {"Sugar", "Splenda", "No Sweetener"};
		sweetType = new JComboBox(sweetener);
		sweetenerPanel.add(sweetType, BorderLayout.SOUTH);
		
		fruitPanel.add(fruitLabel, BorderLayout.NORTH);
		fruit = new String[] {"Acai Berry", "Strawberry", "Banana"};
		fruitType = new JComboBox(fruit);
		fruitPanel.add(fruitType, BorderLayout.CENTER);
		
		addPanel.add(btAdd, BorderLayout.CENTER);

		ordSumPanel.add(ordSumLabel, BorderLayout.NORTH);
		ordSumPanel.add(orderSummary, BorderLayout.CENTER);
		ordSumPanel.add(total, BorderLayout.SOUTH);
		
		payment = new String[] {"Credit Card", "Gift Card", "Cash"};
		paymentType = new JComboBox(payment);
		paymentPanel.add(paymentType, BorderLayout.CENTER);
		paymentPanel.add(btPayProc, BorderLayout.SOUTH);

		// add comment
		Panel fieldFramePanel = new Panel(new GridLayout(0, 1, 1, 6));
		fieldFramePanel.add(startPanel);
		fieldFramePanel.add(typePanel);
		fieldFramePanel.add(sizePanel);
		fieldFramePanel.add(sweetenerPanel);
		//fieldFramePanel.add(fruitPanel);
		fieldFramePanel.add(addPanel);

		/* Add, pack and show */
		javaFrame.add(fieldFramePanel, BorderLayout.NORTH);
		javaFrame.add(ordSumPanel, BorderLayout.CENTER);
		javaFrame.add(paymentPanel, BorderLayout.SOUTH);
		javaFrame.pack();
		
		btAdd.addActionListener(new AddSmoothieListener());
		btStOrder.addActionListener(new NewOrderListener());
		btPayProc.addActionListener(new PayListener());
		
		// Close the window when close icon of the window is clicked
		javaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		orderSummary.setEditable(false);
		
		javaFrame.setLocationRelativeTo(null);
		javaFrame.setVisible(true);
		
		
	}
	
	class NewOrderListener implements ActionListener {
		public void actionPerformed(ActionEvent click) {
			orderSummary.setText("");
			total.setText("");
			preTaxTotal = 0;
			postTaxTotal = 0;
			
			javaFrame.setVisible(true);
		}
	}

	// add comment
	class AddSmoothieListener implements ActionListener {
		public void actionPerformed(ActionEvent click) {
			String currentSmoothie = "";
			String currentSize = "";
			String currentSweetener = "";
		
			//add comment
			if (sizeType.getSelectedItem() == size[0]) {
				currentSize = size[0];
			}
			if (sizeType.getSelectedItem() == size[1]) {
				currentSize = size[1];
			}
			if (sizeType.getSelectedItem() == size[2]) {
				currentSize = size[2];
			}
			
			// add comment
			if (sweetType.getSelectedItem() == sweetener[0]) {
				currentSweetener = sweetener[0];
			}
			if (sweetType.getSelectedItem() == sweetener[1]) {
				currentSweetener = sweetener[1];
			}
			if (sweetType.getSelectedItem() == sweetener[2]) {
				currentSweetener = sweetener[2];
			}
			
			// add comment
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
			
			// add comment
			
			orderSummary.setEditable(true);
			
			orderSummary.append(currentSize + currentSmoothie);
			orderSummary.append("           (" + currentSweetener + ")\r\n");
			orderSummary.append("\r\n");
			
			orderSummary.setEditable(false);
			
			postTaxTotal = addTax(preTaxTotal);
			DecimalFormat pTT = new DecimalFormat("#.00");
			String s = pTT.format(postTaxTotal);
			
			total.setText("Total w/tax =          $ " + s);
			javaFrame.setVisible(true);
		}
	}
	
	class PayListener implements ActionListener {
		public void actionPerformed(ActionEvent click) {
			if (paymentType.getSelectedItem() == payment[0]) {
				
				// Construct payment window
				new ccPayWindow();
			}
			if (paymentType.getSelectedItem() == payment[1]) {
				
				// Construct payment window
				new gcPayWindow();
			}
			if (paymentType.getSelectedItem() == payment[2]) {
				
				// Construct payment window
				new cashPayWindow();
			}
		}
	}
	
	public void setFrameVisible() {
		javaFrame.setVisible(true);
	}
	
	public void setFrameNotVisible() {
		javaFrame.setVisible(false);
	}
	
	// add comment
	static public void main(String argv[]) {
		new SmoothieShop();
	}
	
	// add comment
	public double addTax(double total) {
		total = (total * 1.06);
		total = Math.round(total * 100.00) / 100.00;
		return total;
	}
}

