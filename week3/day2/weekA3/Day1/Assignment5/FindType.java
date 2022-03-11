package week3.Day1.Assignment5;

public class FindType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		int  letter = 0, space = 0, num = 0, specialChar = 0;
		char[] charArray = test.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isAlphabetic(test.charAt(i))) {
				letter++;
			}
			else if (Character.isDigit(test.charAt(i))) {
				num++;
			}
			else if (Character.isSpaceChar(test.charAt(i))) {
				specialChar++;
			}
			else {
				space++;
			}
		}
		System.out.println("letter: " + letter);
		System.out.println("space: " + space);
		System.out.println("number: " + num);
		System.out.println("specialCharcter: " + specialChar);

	}

}
