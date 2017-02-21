
package banking.primitive.core;

public class Checking extends Account {

	private static final long SERIALVERSIONUID = 11L;
	private int numWithdraws = 0;
	/**
  Method:Checking
  Inputs: name of the account
  Returns:A checking account object

  Description: Creates a checking account with the given name
*/
	private Checking(String name) {
		super(name);
	}
	/**
  Method:createChecking
  Inputs:Name
  Returns:Checking account object

  Description: Creates checking account with the given name.
*/
    public static Checking createChecking(String name) {
        return new Checking(name);
    }
	/**
  Method:Checking
  Inputs:name and balance
  Returns:Creates a checking account object with the given values

  Description:
*/
	public Checking(String name, float balance) {
		super(name, balance);
	}

	/**
	 * A deposit may be made unless the Checking account is closed
	 * @param float is the deposit amount
	 */
	public boolean deposit(float amount) {
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
			return true;
		}
		return false;
	}

	/**
	 * Withdrawal. After 10 withdrawals a fee of $2 is charged per transaction You may 
	 * continue to withdraw an overdrawn account until the balance is below -$100
	 */
	public boolean withdraw(float amount) {
		if (amount > 0.0f) {		
			// KG: incorrect, last balance check should be >=
			if (getState() == State.OPEN || (getState() == State.OVERDRAWN && balance > -100.0f)) {
				balance = balance - amount;
				numWithdraws++;
				if (numWithdraws > 10)
					balance = balance - 2.0f;
				if (balance < 0.0f) {
					setState(State.OVERDRAWN);
				}
				return true;
			}
		}
		return false;
	}

	public String getType() { return "Checking"; }
	
	public String toString() {
		return "Checking: " + getName() + ": " + getBalance();
	}
}
=======

package banking.primitive.core;

public class Checking extends Account {

	static final long serialVersionUID = 11L;
	private int numWithdraws = 0;
	/**
  Method:Checking
  Inputs: name of the account
  Returns:A checking account object

  Description: Creates a checking account with the given name
*/
	private Checking(String name) {
		super(name);
	}
	/**
  Method:createChecking
  Inputs:Name
  Returns:Checking account object

  Description: Creates checking account with the given name.
*/
    public static Checking createChecking(String name) {
        return new Checking(name);
    }
	/**
  Method:Checking
  Inputs:name and balance
  Returns:Creates a checking account object with the given values

  Description:
*/
	public Checking(String name, float balance) {
		super(name, balance);
	}

	/**
	 * A deposit may be made unless the Checking account is closed
	 * @param float is the deposit amount
	 */
	public boolean deposit(float amount) {
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
			return true;
		}
		return false;
	}

	/**
	 * Withdrawal. After 10 withdrawals a fee of $2 is charged per transaction You may 
	 * continue to withdraw an overdrawn account until the balance is below -$100
	 */
	public boolean withdraw(float amount) {
		if (amount > 0.0f) {		
			// KG: incorrect, last balance check should be >=
			if (getState() == State.OPEN || (getState() == State.OVERDRAWN && balance > -100.0f)) {
				balance = balance - amount;
				numWithdraws++;
				if (numWithdraws > 10)
					balance = balance - 2.0f;
				if (balance < 0.0f) {
					setState(State.OVERDRAWN);
				}
				return true;
			}
		}
		return false;
	}

	public String getType() { return "Checking"; }
	
	public String toString() {
		return "Checking: " + getName() + ": " + getBalance();
	}
}
=======

/*
  File:Checking.java	
  Author:Kevin Gary
  Date:02/20/2017
*/
package banking.primitive.core;
/**
  Class:	Checking 

  
  Description:Represents a checking account
*/
public class Checking extends Account {

	private static final long serialVersionUID = 11L;
	private int numWithdraws = 0;
	/**
  Method:Checking
  Inputs: name of the account
  Returns:A checking account object

  Description: Creates a checking account with the given name
*/
	private Checking(String name) {
		super(name);
	}
	/**
  Method:createChecking
  Inputs:Name
  Returns:Checking account object

  Description: Creates checking account with the given name.
*/
    public static Checking createChecking(String name) {
        return new Checking(name);
    }
	/**
  Method:Checking
  Inputs:name and balance
  Returns:Creates a checking account object with the given values

  Description:
*/
	public Checking(String name, float balance) {
		super(name, balance);
	}

	/**
	 * A deposit may be made unless the Checking account is closed
	 * @param float is the deposit amount
	 */
	public boolean deposit(float amount) {
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
			return true;
		}
		return false;
	}

	/**
	 * Withdrawal. After 10 withdrawals a fee of $2 is charged per transaction You may 
	 * continue to withdraw an overdrawn account until the balance is below -$100
	 */
	public boolean withdraw(float amount) {
		if (amount > 0.0f) {		
			// KG: incorrect, last balance check should be >=
			if (getState() == State.OPEN || (getState() == State.OVERDRAWN && balance > -100.0f)) {
				balance = balance - amount;
				numWithdraws++;
				if (numWithdraws > 10)
					balance = balance - 2.0f;
				if (balance < 0.0f) {
					setState(State.OVERDRAWN);
				}
				return true;
			}
		}
		return false;
	}

	public String getType() { return "Checking"; }
	
	public String toString() {
		return "Checking: " + getName() + ": " + getBalance();
	}
}


