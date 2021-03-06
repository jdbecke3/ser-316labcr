/*
  File:ServerSolution.java	
  Author:Kevin Gary
  Date:02/20/2017
  
  Description: Contains the ServerSolution class which saves and loads account objects
*/
package banking.primitive.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.io.*;

import banking.primitive.core.Account.State;
/**
  Class:ServerSolution 
  
  Description: Serializes account objects to and from a .ser file
*/
class ServerSolution implements AccountServer {

	static String fileName = "accounts.ser";
	/**
	Method:ServerSolution
	Inputs:none
	Returns: ServerSolution object

	Description: Reads from a .ser file and loads the account objects in to a hash map 
	*/
	public ServerSolution() {
		accountMap = new HashMap<String,Account>();
		File file = new File(fileName);
		ObjectInputStream in = null;
		try {
			if (file.exists()) {
				System.out.println("Reading from file " + fileName + "...");
				in = new ObjectInputStream(new FileInputStream(file));

				Integer sizeI = (Integer) in.readObject();
				int size = sizeI.intValue();
				for (int i=0; i < size; i++) {
					Account acc = (Account) in.readObject();
					if (acc != null)
						accountMap.put(acc.getName(), acc);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
	}
/**
  Method:newAccountFactory
  Inputs:String type,String name,float balance
  Returns:boolean telling whether the account was created or not

  Description: Checks that the account already exists and if not discerns which type of accoutn is being created and creates it
*/
	private boolean newAccountFactory(String type, String name, float balance)
		throws IllegalArgumentException {
		
		if (accountMap.get(name) != null) return false;
		
		Account acc;
		if ("Checking".equals(type)) {
			acc = new Checking(name, balance);

		} else if ("Savings".equals(type)) {
			acc = new Savings(name, balance);

		} else {
			throw new IllegalArgumentException("Bad account type:" + type);
		}
		try {
			accountMap.put(acc.getName(), acc);
		} catch (Exception exc) {
			return false;
		}
		return true;
	}
	/**
	Method:newAccount
	Inputs:type,name,balance
	Returns: boolean 

	Description:Creates a new account with the corresponding values
	*/
	
	public boolean newAccount(String type, String name, float balance) 
		throws IllegalArgumentException {
		
		if (balance < 0.0f) throw new IllegalArgumentException("New account may not be started with a negative balance");
		
		return newAccountFactory(type, name, balance);
	}
	/**
	Method:closeAccount
	Inputs:name 
	Returns:boolean saying if the account was closed

	Description:Finds the account with the given name and tells whether the closing was succesful
	*/
	public boolean closeAccount(String name) {
		Account acc = accountMap.get(name);
		if (acc == null) {
			return false;
		}
		acc.setState(State.CLOSED);
		return true;
	}
	
	public Account getAccount(String name) {
		return accountMap.get(name);
	}

	public List<Account> getAllAccounts() {
		return new ArrayList<Account>(accountMap.values());
	}

	public List<Account> getActiveAccounts() {
		List<Account> result = new ArrayList<Account>();

		for (Account acc : accountMap.values()) {
			if (acc.getState() != State.CLOSED) {
				result.add(acc);
			}
		}
		return result;
	}
	/**
	Method:saveAccounts
	Inputs:none
	Returns:none

	Description: Serializes all accounts to a .ser file
	*/
	public void saveAccounts() throws IOException {
		ObjectOutputStream out = null; 
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));

			out.writeObject(Integer.valueOf(accountMap.size()));
			//insert new code
			Set<String> keys = accountMap.keySet();		// get keys from map
			for(String key : keys) 						// get one key from the set of keys
			{
				out.writeObject(accountMap.get(key));	// write one value to file
			}
			//end of new Code
			/* Old Code
			 * for (int i=0; i < accountMap.size(); i++) {
			 * out.writeObject(accountMap.get(i));
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("Could not write file:" + fileName);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
	}
    private Map<String,Account> accountMap = null;
}


