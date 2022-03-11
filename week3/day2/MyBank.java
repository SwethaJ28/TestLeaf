package week3.day2;

public class MyBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Below list of methods available in Interface and Implementation class");
		SBI sbi = new SBI();
		sbi.openAccount();
		sbi.provideCreditCard();
		sbi.provideDebitCard();
		
		System.out.println();
		System.out.println("Below list of methods available in Interface");
		RBI rbi=new SBI();
		rbi.openAccount();
		rbi.provideDebitCard();

	}

}
