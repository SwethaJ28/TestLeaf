package week3.Day1.Assignment5;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "Madam";
		String rev ="";
		for (int i = input.length()-1; i >=0; i--) {
			rev=rev+input.charAt(i);
		}
		if (input.equalsIgnoreCase(rev)) {
			System.out.println("The given String is palindrome");
		} else {
			System.out.println("The given String is not a palindrome");

		}
		

	}

}
