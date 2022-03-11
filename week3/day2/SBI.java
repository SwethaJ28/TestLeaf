package week3.day2;

public class SBI implements RBI{

	public void openAccount() {
		// TODO Auto-generated method stub
		System.out.println("For opening saving account, please provide Details: Name, Age proof,Govt ID Proof - Interface(RBI)");
		System.out.println("For opening salary account, please provide Details: Name, Age proof,Govt ID Proof,Appointment order - Interface(RBI)");
	}

	public void provideDebitCard() {
		// TODO Auto-generated method stub
		System.out.println("Daily withdrawl limit is upto Rs.50,000 - Interface(RBI)");
	}
	/**
	 * SBI is available in every state and it should work under RBI regulation
	 * use the same methods available in RBI
	 */
	public void provideCreditCard() {
		System.out.println("This will be provided based on user preference - Implementation Class(SBI)");
	}
}
