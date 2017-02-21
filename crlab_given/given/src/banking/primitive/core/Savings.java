/*
  File:Account:Savings.java	
  Author:Kevin Gary
  Date:02/20/2017
  
  Description: Contains the Saving class which represents a Savings account
*/
package banking.primitive.core;

public class Savings extends Account {
	private static final long serialVersionUID = 111L;
	private int numWithdraws = 0;

	public Savings(String name) {
		super(name);
	}

	public Savings(String name, float balance) throws IllegalArgumentException {
		super(name, balance);
	}

	/**
	 * A deposit comes with a fee of 50 cents per deposit
	 */
	public boolean deposit(float amount) {
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount - 0.50F;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
			//insert new Code
			return true;
			//end of new Code
		}
		return false;
	}

	/**
	 * A withdrawal. After 3 withdrawals a fee of $1 is added to each withdrawal.
	 * An account whose balance dips below 0 is in an OVERDRAWN state
	 */
	public boolean withdraw(float amount) {
		if (getState() == State.OPEN && amount > 0.0f) {
			balance = balance - amount;
			numWithdraws++;
			if (numWithdraws > 3)
				balance = balance - 1.0f;
			// KG BVA: should be < 0
			if (balance < 0.0f) {
				setState(State.OVERDRAWN);
			}
			return true;
		}
		return false;
	}
	
	public String getType() { return "Checking"; }

	public String toString() {
		return "Savings: " + getName() + ": " + getBalance();
	}
}
=======

package banking.primitive.core;

public class Savings extends Account {
	private static final long serialVersionUID = 111L;
	private int numWithdraws = 0;
	/**
  Method:Savings
  Inputs:name 
  Returns:Savings account object name
  Description: Savings creates a Savings object with the given name
*/
	public Savings(String name) {
		super(name);
	}
	/**
  Method:Savings 
  Inputs:name and balance
  Returns:Savings object

  Description:Creates a Savings object with the given values
*/
	public Savings(String name, float balance) throws IllegalArgumentException {
		super(name, balance);
	}

	/**
	 *Method: deposit
	 *Inputs: amount to deposit
	 * Return: boolean telling whether the deposit was successful or not
	 *Description:A deposit comes with a fee of 50 cents per deposit
	 */
	public boolean deposit(float amount) {
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount - 0.50F;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
		}
		return false;
	}

	/**
	 *Method:withdraw
	 *Inputs: amount to withdraw
	 *Return: boolean telling whether the withrdraw was succesful or not
	 * A withdrawal. After 3 withdrawals a fee of $1 is added to each withdrawal.
	 * An account whose balance dips below 0 is in an OVERDRAWN state
	 */
	public boolean withdraw(float amount) {
		if (getState() == State.OPEN && amount > 0.0f) {
			balance = balance - amount;
			numWithdraws++;
			if (numWithdraws > 3)
				balance = balance - 1.0f;
			// KG BVA: should be < 0
			if (balance <= 0.0f) {
				setState(State.OVERDRAWN);
			}
			return true;
		}
		return false;
	}
	
	public String getType() { return "Checking"; }

	public String toString() {
		return "Savings: " + getName() + ": " + getBalance();
	}
}
=======

package banking.primitive.core;

public class Savings extends Account {
	private static final long SERIALVERSIONUID = 111L;
	private int numWithdraws = 0;
	/**
  Method:Savings
  Inputs:name 
  Returns:Savings account object name 

  Description: Savings creates a Savings object with the given name
*/
	public Savings(String name) {
		super(name);
	}
	/**
  Method:Savings 
  Inputs:name and balance
  Returns:Savings object

  Description:Creates a Savings object with the given values
*/
	public Savings(String name, float balance) throws IllegalArgumentException {
		super(name, balance);
	}

	/**
	 *Method: deposit
	 *Inputs: amount to deposit
	 * Return: boolean telling whether the deposit was successful or not
	 *Description:A deposit comes with a fee of 50 cents per deposit
	 */
	public boolean deposit(float amount) {
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount - 0.50F;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
		}
		return false;
	}

	/**
	 *Method:withdraw
	 *Inputs: amount to withdraw
	 *Return: boolean telling whether the withrdraw was succesful or not
	 * A withdrawal. After 3 withdrawals a fee of $1 is added to each withdrawal.
	 * An account whose balance dips below 0 is in an OVERDRAWN State
	 */
	public boolean withdraw(float amount) {
		if (getState() == State.OPEN && amount > 0.0f) {
			balance = balance - amount;
			numWithdraws++;
			if (numWithdraws > 3)
				balance = balance - 1.0f;
			// KG BVA: should be < 0
			if (balance <= 0.0f) {
				setState(State.OVERDRAWN);
			}
			return true;
		}
		return false;
	}
	
	public String getType() { return "Checking"; }

	public String toString() {
		return "Savings: " + getName() + ": " + getBalance();
	}
}
=======

package banking.primitive.core;

public class Savings extends Account {
	static final long serialVersionUID = 111L;
	private int numWithdraws = 0;
	/**
  Method:Savings
  Inputs:name 
  Returns:Savings account object name 

  Description: Savings creates a Savings object with the given name
*/
	public Savings(String name) {
		super(name);
	}
	/**
  Method:Savings 
  Inputs:name and balance
  Returns:Savings object

  Description:Creates a Savings object with the given values
*/
	public Savings(String name, float balance) throws IllegalArgumentException {
		super(name, balance);
	}

	/**
	 *Method: deposit
	 *Inputs: amount to deposit
	 * Return: boolean telling whether the deposit was successful or not
	 *Description:A deposit comes with a fee of 50 cents per deposit
	 */
	public boolean deposit(float amount) {
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount - 0.50F;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
		}
		return false;
	}

	/**
	 *Method:withdraw
	 *Inputs: amount to withdraw
	 *Return: boolean telling whether the withrdraw was succesful or not
	 * A withdrawal. After 3 withdrawals a fee of $1 is added to each withdrawal.
	 * An account whose balance dips below 0 is in an OVERDRAWN state
	 */
	public boolean withdraw(float amount) {
		if (getState() == State.OPEN && amount > 0.0f) {
			balance = balance - amount;
			numWithdraws++;
			if (numWithdraws > 3)
				balance = balance - 1.0f;
			// KG BVA: should be < 0
			if (balance <= 0.0f) {
				setState(State.OVERDRAWN);
			}
			return true;
		}
		return false;
	}
	
	public String getType() { return "Savings"; }

	public String toString() {
		return "Savings: " + getName() + ": " + getBalance();
	}
}
=======

/*
  File:Savings.java	
  Author:Kevin Gary
  Date:02/20/2017	
*/
package banking.primitive.core;
/**
  Class:	Savings

  
  Description: Represents a Savings account
*/
public class Savings extends Account {
	private static final long serialVersionUID = 111L;
	private int numWithdraws = 0;
	/**
  Method:Savings
  Inputs:name 
  Returns:Savings account object name 

  Description: Savings creates a Savings object with the given name
*/
	public Savings(String name) {
		super(name);
	}
	/**
  Method:Savings 
  Inputs:name and balance
  Returns:Savings object

  Description:Creates a Savings object with the given values
*/
	public Savings(String name, float balance) throws IllegalArgumentException {
		super(name, balance);
	}

	/**
	 *Method: deposit
	 *Inputs: amount to deposit
	 * Return: boolean telling whether the deposit was successful or not
	 *Description:A deposit comes with a fee of 50 cents per deposit
	 */
	public boolean deposit(float amount) {
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount - 0.50F;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
		}
		return false;
	}

	/**
	 *Method:withdraw
	 *Inputs: amount to withdraw
	 *Return: boolean telling whether the withrdraw was succesful or not
	 * A withdrawal. After 3 withdrawals a fee of $1 is added to each withdrawal.
	 * An account whose balance dips below 0 is in an OVERDRAWN state
	 */
	public boolean withdraw(float amount) {
		if (getState() == State.OPEN && amount > 0.0f) {
			balance = balance - amount;
			numWithdraws++;
			if (numWithdraws > 3)
				balance = balance - 1.0f;
			// KG BVA: should be < 0
			if (balance <= 0.0f) {
				setState(State.OVERDRAWN);
			}
			return true;
		}
		return false;
	}
	
	public String getType() { return "Checking"; }

	public String toString() {
		return "Savings: " + getName() + ": " + getBalance();
	}
}


