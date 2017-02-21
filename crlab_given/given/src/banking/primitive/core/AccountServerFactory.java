package banking.primitive.core;

/**
  Class:	AccountServerFactory
  
  Description: A class that creates an AccountServerFactory and ensures its singleton
*/
public class AccountServerFactory {

	protected static AccountServerFactory singleton = null;

	protected AccountServerFactory() {

	}

	public static AccountServerFactory getMe() {
		if (singleton == null) {
			singleton = new AccountServerFactory();
		}

		return singleton;
	}

	public AccountServer lookup() {
		return new ServerSolution();
	}
}
