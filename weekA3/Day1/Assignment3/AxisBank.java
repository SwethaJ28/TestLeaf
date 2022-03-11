package week3.Day1.Assignment3;

public class AxisBank extends BankInfo {

	public void deposit() {
		System.out.println("Maximum Deposit per day Rs.1,00,000-> Axis Bank");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AxisBank abank = new AxisBank();
		abank.saving();
		abank.fixed();
		abank.deposit();
		
    }

}
