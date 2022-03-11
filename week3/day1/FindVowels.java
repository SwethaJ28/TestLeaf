package week3.day1;

public class FindVowels {
	public static void main(String[] args) {
		String input = "Education";
		String lInput = input.toLowerCase();
		int cnt =0;
		
		for (int i = 0; i < lInput.length(); i++) {
			 if (lInput.charAt(i) == 'a' || lInput.charAt(i) == 'e' || lInput.charAt(i) == 'i' || lInput.charAt(i) == 'o'|| lInput.charAt(i) == 'u') {
				cnt++;
			}
		}
		
		if (cnt == 5) {
			System.out.println("Given string has all the vowels : "+input);
		}
		else {
			System.out.println("Given string does not have all the vowels : "+input);
		}
	}

}
