package week3.Day1.Assignment5;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String i1 = "stops";
		String i2 = "hyper";
		int flag = 1;

		if (i1.length() == i2.length()) {
			char[] i1Array = i1.toCharArray();
			char[] i2Array = i2.toCharArray();
			Arrays.sort(i1Array);
			Arrays.sort(i2Array);

			for (int i = 0, j = 0; i < i1Array.length; i++, j++) {
				if (i1Array[i] != i2Array[j]) {
					flag = 0;
				}

			}
			if (flag == 1) {
				System.out.println("Given two strings were Anagram");
			} else {
				System.out.println("Given two Strings were not Anagram");
			}

		} else {

			System.out.println("With this two string we can't validate Anagram");
		}

	}

}
