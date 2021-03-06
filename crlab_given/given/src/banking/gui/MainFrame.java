
/**
  File:MainFrame.java	
  Author:Kevin Gary
  Date:02/20/2017
**/
package banking.gui;
/**
  Class:	MainFrame 

  
  Description:Creates the gui for the application
*/
import banking.primitive.core.Account;
import banking.primitive.core.AccountServer;
import banking.primitive.core.AccountServerFactory;

import java.io.*;
import java.util.*;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class MainFrame extends JFrame {
/**
  Method:MainFrame
  Inputs:propertyFile string giving the name of a property file
  Returns: returns a MainFrame object

  Description:Creates a MainFrame object which creates the gui
*/
	public MainFrame(String propertyFile) throws IOException {

		//** initialize myServer
		myServer = AccountServerFactory.getMe().lookup();

		props = new Properties();

		FileInputStream fis = null; 
		try {
			System.out.println(propertyFile);
			fis =  new FileInputStream(propertyFile);
			props.load(fis);
			fis.close();
		} 
        catch (IOException ioe) {
			ioe.printStackTrace();
			throw ioe;
		}
		constructForm();
	}

	/**
  Method:constructForm
  Inputs:none
  Returns:none

  Description:Creates the gui components contained in the MainFrame
*/
	private void constructForm() {
		//*** Make these read from properties
		typeLabel		= new JLabel(props.getProperty("TypeLabel"));
		nameLabel		= new JLabel(props.getProperty("NameLabel"));
		balanceLabel	= new JLabel(props.getProperty("BalanceLabel"));

		Object[] accountTypes = {"Savings", "Checking"};
		typeOptions = new JComboBox(accountTypes);
		nameField = new JTextField(20);
		balanceField = new JTextField(20);

		newAccountButton = new JButton("New Account");
		JButton depositButton = new JButton("Deposit");
		JButton withdrawButton = new JButton("Withdraw");
		JButton saveButton = new JButton("Save Accounts");
		displayAccountsButton = new JButton("List Accounts");
		JButton displayAllAccountsButton = new JButton("All Accounts");

		this.addWindowListener(new FrameHandler());
		newAccountButton.addActionListener(new NewAccountHandler());
		displayAccountsButton.addActionListener(new DisplayHandler());
		displayAllAccountsButton.addActionListener(new DisplayHandler());
		depositButton.addActionListener(new DepositHandler());
		withdrawButton.addActionListener(new WithdrawHandler());
		saveButton.addActionListener(new SaveAccountsHandler());		
		
		Container pane = getContentPane();
		pane.setLayout(new FlowLayout());
		
		JPanel panel1 = new JPanel();
		panel1.add(typeLabel);
		panel1.add(typeOptions);
		
		JPanel panel2 = new JPanel();
		panel2.add(displayAccountsButton);
		panel2.add(displayAllAccountsButton);
		panel2.add(saveButton);
		
		JPanel panel3 = new JPanel();
		panel3.add(nameLabel);
		panel3.add(nameField);
		
		JPanel panel4 = new JPanel();
		panel4.add(balanceLabel);
		panel4.add(balanceField);
		
		JPanel panel5 = new JPanel();
		panel5.add(newAccountButton);
		panel5.add(depositButton);
		panel5.add(withdrawButton);

		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		pane.add(panel4);
		pane.add(panel5);
		
		setSize(400, 250);
	}

	class DisplayHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<Account> accounts = null;
			if (e.getSource() == displayAccountsButton) {
				accounts = myServer.getActiveAccounts();
			} 
            else {
				accounts = myServer.getAllAccounts();
			}
			StringBuffer sb = new StringBuffer();
			Account thisAcct = null;
			for (Iterator<Account> li = accounts.iterator(); li.hasNext();) {
				thisAcct = (Account)li.next();
				sb.append(thisAcct.toString()+"\n");
			}

			JOptionPane.showMessageDialog(null, sb.toString());
		}
	}

	// Complete a handler for new account button
	class NewAccountHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String type = typeOptions.getSelectedItem().toString();
			String name = nameField.getText();
			String balance = balanceField.getText();

			if(!isNumeric(balance))
			{
				JOptionPane.showMessageDialog(null, "Account not created!\nAmount must be a number");
			}
			else if (myServer.newAccount(type, name, Float.parseFloat(balance))) {
				JOptionPane.showMessageDialog(null, "Account created successfully");
			} 
            else {
				JOptionPane.showMessageDialog(null, "Account not created!");
			}
		}
	}
	
	// Complete a handler for new account button
	class SaveAccountsHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				myServer.saveAccounts();
				JOptionPane.showMessageDialog(null, "Accounts saved");
			} 
			catch (IOException exc) {
				JOptionPane.showMessageDialog(null, "Error saving accounts");
			}
		}
	}

	// Complete a handler for deposit button
	class DepositHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			String balance = balanceField.getText();
			Account acc = myServer.getAccount(name);
			//New Code
			if(!isNumeric(balance))
			{
				JOptionPane.showMessageDialog(null, "Deposit unsuccessful:\nAmount must be a number");
			}
			else if (acc != null && acc.deposit(Float.parseFloat(balance))) {
				JOptionPane.showMessageDialog(null, "Deposit successful");
			} 
			else {
				JOptionPane.showMessageDialog(null, "Deposit unsuccessful");
			}		
		}
	}
	// Complete a handler for deposit button
	class WithdrawHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			String balance = balanceField.getText();
			Account acc = myServer.getAccount(name);
			if(!isNumeric(balance))
			{
				JOptionPane.showMessageDialog(null, "Withdrawal unsuccessful:\nAmount must be a number");
			}
			else if (acc != null && acc.withdraw(Float.parseFloat(balance))) {
				JOptionPane.showMessageDialog(null, "Withdrawal successful");
			} 
			else {
				JOptionPane.showMessageDialog(null, "Withdrawal unsuccessful");
			}		
		}
	}
	
	//** Complete a handler for the Frame that terminates 
	//** (System.exit(1)) on windowClosing event

	static class FrameHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {

			System.exit(0);
		}
	}
	
	/**
	  Method: isNumeric
	  Inputs: String
	  Returns: boolean

	  Description: will return true if the string can be
	  			   converted to a number and false if it
	  			   cannot.
	*/
	public boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
    private AccountServer	myServer;
	private Properties		props;
	private JLabel			typeLabel;
	private JLabel			nameLabel;
	private JLabel			balanceLabel;
	private JComboBox		typeOptions;
	private JTextField		nameField;
	private JTextField		balanceField;
	private JButton 		depositButton;
	private JButton 		withdrawButton;
	private JButton			newAccountButton;
	private JButton			displayAccountsButton;
	private JButton			displayODAccountsButton;
}


