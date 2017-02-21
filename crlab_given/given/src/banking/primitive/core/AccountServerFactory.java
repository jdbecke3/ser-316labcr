
/*
  File:AccountServerFactory.java	
  Author:Kevin Gary
  Date:02/20/2017
  
  Description: AccountServerFactory.java contains the AccountServerFactory class.
*/


package banking.primitive.core;

/**
  Class:	AccountServerFactory
  
  Description: A class that creates an AccountServerFactory and ensures its singleton
*/
public class AccountServerFactory {

	protected static AccountServerFactory singleton = null;
    /**
    Method:AccountServerFactory
    Inputs:none
    Returns: AccountServerFactory object

    Description: returns a new AccountServerFactory object
    */
	protected AccountServerFactory() {

	}

	public static AccountServerFactory getMe() {
		if (singleton == null) {
			singleton = new AccountServerFactory();
		}

		return singleton;
	}
	/**
    Method:lookup
    Inputs:none
    Returns: AccountServer

    Description: returns a new ServerSolution
    */
	public AccountServer lookup() {
		return new ServerSolution();
	}
}
