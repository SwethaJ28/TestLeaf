package week3.day2;

public interface RBI {
	/**
	 * RBI is Banking system Method 1: -> openAccount() This Method requires user
	 * name,age,dob and government proof details to create account Accounts can be
	 * either be saving or salary account depends on user specification
	 */
	public void openAccount();

	/**
	 * RBI in general it will provide the Debit care for the user User can withdraw
	 * with certain limit of amount for day It has unique pin and user should share
	 * with anyone
	 */
	public void provideDebitCard();
}
